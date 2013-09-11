package org.minioa.core;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;

public class WorkFlow {

	/**
	 * 发送任务提醒，当设置审批代理后，将不给原审批人发送消息
	 * 
	 * @param s
	 *            数据库连接会话
	 * @param url
	 *            审批实例网址
	 * @param processId
	 *            流程实例id
	 * @param taskId
	 *            节点id
	 * @return
	 */
	public static int SendNotice(Session s, String url, int processId, int taskId) {
		try {
			String sql = "select ifnull((select concat(tb.processName,'-', ta.processDesc)  as subject from core_process ta";
			sql = sql + " left join core_processdefinition tb on tb.ID_  = ta.processDefId";
			sql = sql + " where ta.ID_ = :processId),'')";
			Query query = s.createSQLQuery(sql);
			query.setParameter("processId", processId);
			String subject = FunctionLib.getString(query.list().get(0));
			//System.out.println("subject:" + subject + ",processId:" + processId);
			if (subject.equals(""))
				return -1;
			sql = "select ifnull((select tb.taskName as subject from core_task ta ";
			sql = sql + " left join core_processdefinition_task tb on tb.ID_  = ta.taskDefId";
			sql = sql + " where ta.ID_ = :taskId),'')";
			query = s.createSQLQuery(sql);
			query.setParameter("taskId", taskId);
			String taskName = FunctionLib.getString(query.list().get(0));

			String textContent = "您有新的审批《" + subject + "》，节点名称：" + taskName;
			textContent = textContent + url;
			String htmlContent = "您有新的审批《" + subject + "》，节点名称：" + taskName;
			htmlContent = htmlContent + "<br/><a href=\"" + url + "\">" + url + "</a>";

			String smsNotice = "", emailNotice = "", imNotice = "";
			sql = " select emailNotice,smsNotice,imNotice from core_processdefinition_task where ID_ in (select taskDefId from core_task where ID_ = :taskId)";
			query = s.createSQLQuery(sql);
			query.setParameter("taskId", taskId);
			//System.out.println("taskId:" + taskId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				emailNotice = FunctionLib.getString(obj[0]);
				smsNotice = FunctionLib.getString(obj[1]);
				imNotice = FunctionLib.getString(obj[2]);
			}
			it = null;

			String agentId = getTaskAgent(s, taskId, 0);
			if (FunctionLib.getInt(agentId) > 0) {
				AddToMessageList(s, agentId, smsNotice, emailNotice, imNotice, htmlContent, textContent, subject);
			} else {
				String approvers = getTaskApprover(s, taskId, 0);
				//System.out.println("approvers:" + approvers);
				for (String userId : approvers.split(",")) {
					//System.out.println("userId:" + userId);
					if (FunctionLib.getInt(userId) > 0){
						AddToMessageList(s, userId, smsNotice, emailNotice, imNotice, htmlContent, textContent, subject);
						//System.out.println("userId1:" + userId);
					}
				}
			}
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	private static int AddToMessageList(Session s, String userId, String smsNotice, String emailNotice, String imNotice, String htmlContent, String textContent, String subject) {
		try {
			if ("0".equals(userId))
				return 0;
			UserInfo userInfo = new UserInfo().selectRecordById(s, Integer.valueOf(userId));
			MessageList messageList = new MessageList();
			if ("Y".equals(smsNotice) && FunctionLib.isPhoneNum(userInfo.getMobilePhone()))
				messageList.setMobilePhone(userInfo.getMobilePhone());
			else
				messageList.setMobilePhone("");
			//System.out.println("emailNotice:" + emailNotice);
			//System.out.println("userInfo.getEmail():" + userInfo.getEmail());
			//System.out.println("isEmail:" + FunctionLib.isEmail(userInfo.getEmail()));
			if ("Y".equals(emailNotice) && FunctionLib.isEmail(userInfo.getEmail()))
				messageList.setEmail(userInfo.getEmail());
			else
				messageList.setEmail("");

			if ("Y".equals(imNotice))
				messageList.setUserName(userInfo.getUserName());
			else
				messageList.setUserName("");
			messageList.setDisplayName(userInfo.getDisplayName());
			messageList.setHtmlContent(htmlContent);
			messageList.setTextContent(textContent);
			messageList.setSubject(subject);
			s.save(messageList);
			
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 返回节点审批人
	 * 
	 * @param s
	 *            数据库连接会话
	 * @param taskId
	 *            节点id
	 * @param xtype
	 *            0返回ids 1返回displayNames
	 * @return
	 */
	public static String getTaskApprover(Session s, int taskId, int xtype) {
		String str = "";
		try {
			String sql = "select core_gettaskapproverids_f(ID_,:xtype) from core_task where ID_ = :taskId";
			Query query = s.createSQLQuery(sql);
			query.setParameter("xtype", xtype);
			query.setParameter("taskId", taskId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object o = (Object) it.next();
				str = str + FunctionLib.getString(o) + ",";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	/**
	 * 返回节点审批人
	 * 
	 * @param s
	 *            数据库连接会话
	 * @param taskId
	 *            节点id
	 * @param xtype
	 *            0返回ids 1返回displayNames
	 * @return
	 */
	public static String getTaskAgent(Session s, int taskId, int xtype) {
		String str = "";
		try {
			String sql = "select core_gettaskagentid_f(ID_,:xtype) from core_task where ID_ = :taskId";
			Query query = s.createSQLQuery(sql);
			query.setParameter("xtype", xtype);
			query.setParameter("taskId", taskId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object o = (Object) it.next();
				str = FunctionLib.getString(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public static Task CreateTask(Session s, int userId, int processId, int taskDefId, int taskFromId) {
		try {

			String uuid = java.util.UUID.randomUUID().toString();
			Task bean = new Task();
			bean.setCID_(userId);//自由流程时，CID_是待审批的人
			bean.setCDATE_(new java.util.Date());
			bean.setStartDate(new java.util.Date());
			bean.setProcessId(processId);
			bean.setTaskDefId(taskDefId);
			bean.setUUID_(uuid);
			bean.setApproverId(0);
			bean.setTaskFrom(taskFromId);
			bean.setTaskStatus("running");
			s.save(bean);
			bean = null;
			s.flush();
			return new TaskDao().selectRecordByUUID(uuid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static int AutoCompleteTask(Session s, int processDefId, String taskDefCode, int processId) {
		try {
			Query query = s.createSQLQuery("call core_task_autocomplete(:processDefId,:taskDefCode,:processId)");
			query.setParameter("processDefId", processDefId);
			query.setParameter("taskDefCode", taskDefCode);
			query.setParameter("processId", processId);
			return query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
}
