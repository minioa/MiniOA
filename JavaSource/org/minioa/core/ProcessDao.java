package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.jivesoftware.util.Blowfish;

import org.minioa.core.Process;

public class ProcessDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-23
	 */
	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		if (lang == null)
			FunctionLib.redirect(FunctionLib.getWebAppName());
		return lang;
	}

	public MySession mySession;

	public MySession getMySession() {
		if (mySession == null)
			mySession = (MySession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MySession");
		if(null == mySession)
			return null;
		if(!"true".equals(mySession.getIsLogin()))
			return null;
		return mySession;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	public ProcessDao() {
	}

	public List<Integer> buildDsList() {
		if(null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String sql = getSession().getNamedQuery("core.process.items.count").getQueryString();
			String where = " where 1=1";
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String status = (String) params.get("status");
			if ("running".equals(status))
				where = where + " and processStatus='running'";
			else
				where = where + " and processStatus!='running'";
			String key = "0";
			String key2 = "0";
			java.util.Date key3, key4;
			key3 = key4 = null;
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Process.key") != null)
					key = mySession.getTempStr().get("Process.key").toString();
				if (mySession.getTempStr().get("Process.key2") != null)
					key2 = mySession.getTempStr().get("Process.key2").toString();
			}

			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("Process.key3") != null)
					key3 = mySession.getTempDate().get("Process.key3");
				if (mySession.getTempDate().get("Process.key4") != null)
					key4 = mySession.getTempDate().get("Process.key4");
			}

			if (Integer.valueOf(key) > 0)
				where = where + " and ta.processDefId = " + key;
			if ("1".equals(key2))
				where = where + " and ta.CID_ = :userId";
			else if ("2".equals(key2)) {
				if ("running".equals(status))
					where = where + " and :userId in (select tt.approverId from core_task tt where tt.processId = ta.ID_)";
				else
					where = where + " and :userId in (select tt.MID_ from core_task tt where tt.processId = ta.ID_)";
			} else
				;

			if (key3 != null && key4 != null)
				where = where + " and ta.startDate > :key3 and ta.endDate < :key4";
			Query query = getSession().createSQLQuery(sql + where);
			if ("1".equals(key2) || "2".equals(key2))
				query.setParameter("userId", mySession.getUserId());

			if (key3 != null && key4 != null) {
				query.setParameter("key3", key3);
				query.setParameter("key4", key4);
			}
			int tc = Integer.valueOf(String.valueOf(query.list().get(0)));
			for (int i = 0; i < tc; i++)
				dsList.add(i);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<Process> buildItems() {
		ArrayList<Process> items = new ArrayList<Process>();
		try {
			if(null == getMySession())
				return null;
			String sql = getSession().getNamedQuery("core.process.items").getQueryString();
			String other = " order by ta.CDATE_ desc";
			String where = " where 1=1";

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String status = (String) params.get("status");
			if ("running".equals(status))
				where = where + " and processStatus='running'";
			else
				where = where + " and processStatus!='running'";

			String key = "0";
			String key2 = "0";
			java.util.Date key3, key4;
			key3 = key4 = null;
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Process.key") != null)
					key = mySession.getTempStr().get("Process.key").toString();
				if (mySession.getTempStr().get("Process.key2") != null)
					key2 = mySession.getTempStr().get("Process.key2").toString();
			}

			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("Process.key3") != null)
					key3 = mySession.getTempDate().get("Process.key3");
				if (mySession.getTempDate().get("Process.key4") != null)
					key4 = mySession.getTempDate().get("Process.key4");
			}

			if (Integer.valueOf(key) > 0)
				where = where + " and ta.processDefId = " + key;
			if ("1".equals(key2))
				where = where + " and ta.CID_ = :userId";
			else if ("2".equals(key2)) {
				if ("running".equals(status))
					where = where + " and :userId in (select tt.approverId from core_task tt where tt.processId = ta.ID_)";
				else
					where = where + " and :userId in (select tt.MID_ from core_task tt where tt.processId = ta.ID_)";
			} else
				;
			if (key3 != null && key4 != null)
				where = where + " and ta.startDate > :key3 and ta.endDate < :key4";

			items = new ArrayList<Process>();
			Query query = getSession().createSQLQuery(sql + where + other);
			if ("1".equals(key2) || "2".equals(key2))
				query.setParameter("userId", mySession.getUserId());
			if (key3 != null && key4 != null) {
				query.setParameter("key3", key3);
				query.setParameter("key4", key4);
			}
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			Iterator<?> it = query.list().iterator();
			Process bean;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				bean = new Process();
				bean.setID_(FunctionLib.getInt(obj[0]));
				bean.setProcessDefId(FunctionLib.getInt(obj[1]));
				bean.setInstanceId(FunctionLib.getInt(obj[2]));
				bean.setProcessDesc(FunctionLib.getString(obj[3]));
				bean.setStartDateTime(FunctionLib.getDateTimeString(obj[4]));
				bean.setEndDateTime(FunctionLib.getDateTimeString(obj[5]));
				bean.setProcessStatusText(FunctionLib.getProcessStatusText(FunctionLib.getString(obj[6])));
				bean.setProcessName(FunctionLib.getString(obj[7]));
				bean.setApplicant(FunctionLib.getString(obj[8]));
				bean.setFormId(FunctionLib.getInt(obj[9]));
				bean.setProcessNote(FunctionLib.getString(obj[10]));
				items.add(bean);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Process selectRecordById() {
		Process bean = new Process();
		try {
			getMySession();
			mySession.getTempStr().put("processStatus", "");
			mySession.getTempStr().put("UserTree.displayName", "");
			
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			int processId = FunctionLib.getInt((String) params.get("processId"));
			int processDefId = FunctionLib.getInt((String) params.get("processDefId"));
			int instanceId = FunctionLib.getInt((String) params.get("instanceId"));

			if (processDefId == 0 || instanceId == 0) {
				getMySession().getHasOp().put("Process.hasOp", false);
				return null;
			}

			if (getMySession().getJobId() == 0) {
				getMySession().getHasOp().put("Process.hasOp", false);
				getMySession().setMsg("您还没有设置岗位，不能使用审批系统！", 2);
				return null;
			}

			if (processId > 0) {
				bean = selectRecordById(processId);
				getMySession().getHasOp().put("Process.hasOp", hasOp(processId));
			} else
				getMySession().getHasOp().put("Process.hasOp", true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Process selectRecordById(Integer id) {
		Process bean = new Process();
		try {
			Criteria criteria = getSession().createCriteria(Process.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Process) it.next();

			if (bean.getID_() != null) {
				/* 设置流程实例的状态 */
				getMySession().getTempStr().put("processStatus", bean.getProcessStatus());
				bean.setProcessStatusText(FunctionLib.getProcessStatusText(bean.getProcessStatus()));
				if (bean.getStartDate() != null)
					bean.setStartDateTime(FunctionLib.dtf.format(bean.getStartDate()));
				if (bean.getEndDate() != null)
					bean.setEndDateTime(FunctionLib.dtf.format(bean.getEndDate()));
				ProcessDefinition processDef = new ProcessDefinitionDao().selectRecordById(bean.getProcessDefId());
				
				/* 设置流程名称 */
				bean.setProcessName(processDef.getProcessName());
				/* 设置流程图片地址 */
				bean.setProcessImage(processDef.getProcessImage());
				if (processDef.getProcessImage() != null)
					bean.setProcessImage(processDef.getProcessImage().replaceAll("\\\\", "/"));

				/* 设置流程申请人 */
				bean.setApplicant(FunctionLib.getUserDisplayNameByUserId(getSession(), bean.getCID_()));
				//

				int taskDefId = FunctionLib.getLastRuningTaskDefId(getSession(), bean.getID_());
				if(taskDefId>0){
					ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(taskDefId);
					bean.setFormViewPath("formview" + taskDef.getFormViewId() + ".jsf?formId=" + processDef.getFormId() + "&FormMainId="+ bean.getInstanceId() +"&itemId=" + bean.getInstanceId());
				}else{
					bean.setFormViewPath("formview" + processDef.getFormViewId() + ".jsf?formId=" + processDef.getFormId() + "&FormMainId="+ bean.getInstanceId() +"&itemId=" + bean.getInstanceId());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Process selectRecordByUUID() {
		Process bean = new Process();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String uuid = (String) params.get("uuid");
			if (uuid != null)
				bean = selectRecordByUUID(uuid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Process selectRecordByUUID(String uuid) {
		Process bean = new Process();
		try {
			Criteria criteria = getSession().createCriteria(Process.class).add(Restrictions.eq("UUID_", uuid));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				bean = (Process) it.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void updateRecordById(Process bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			int id = FunctionLib.getInt(getMySession().getTempStr().get("Process.id"));
			if (id > 0) {
				Process process = this.selectRecordById(Integer.valueOf(id));
				ProcessDefinition processDef = new ProcessDefinitionDao().selectRecordById(process.getProcessDefId());
				String sqlStr = processDef.getSqlWhenDelete();
				exceSql(sqlStr, id, process.getInstanceId());

				Query query = getSession().createSQLQuery("call core_delete_process_p(:processId)");
				query.setParameter("processId", id);
				query.executeUpdate();
				query = null;
				getMySession().setMsg("当前流程已删除", 1);
				// 取得最近的流程实例
				int lastProcessId = FunctionLib.getLastProcessId(getSession(), process.getProcessDefId(), process.getInstanceId());
				FunctionLib.refresh("processId=" + id, "processId=" + lastProcessId);
			}
			getMySession().setMsg("已删除当前流程", 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Process.id", (String) params.get("processId"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 判断当前用户是否有查看当前流程实例的权限，流程的创建者、审批参与人（含被授权人）具备访问权限
	 * 
	 * @param id
	 * @return
	 */
	public boolean hasOp(int id) {
		boolean tmp = false;
		try {

			if (!getMySession().getHasOp().get("isAdmin")) {
				/* 首先检查是否是流程的创建者或修改者 */
				String sql = "select count(*) from core_task ta where ta.processId = :id and (ta.CID_ = :userId or locate(concat(',',:userId,','),core_gettaskapproverids_f(ta.ID_,0)) > 0 or core_gettaskagentid_f(ta.ID_,0) = :userId)";
				Query query = getSession().createSQLQuery(sql);
				query.setParameter("id", id);
				query.setParameter("userId", getMySession().getUserId());
				if (Integer.valueOf(query.list().get(0).toString()) > 0)
					tmp = true;
			} else
				tmp = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tmp;
	}

	/**
	 * 创建一个流程
	 */
	public void createProcess() {
		try {
			if (getMySession().getJobId() == 0) {
				getMySession().setMsg("您还没有设置岗位，不能使用审批系统！", 0);
				return;
			}
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			int processDefId = FunctionLib.getInt((String) params.get("processDefId"));
			int instanceId = FunctionLib.getInt((String) params.get("instanceId"));
			createProcessByInstanceId(processDefId, instanceId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void createProcessByInstanceId(int processDefId, int instanceId) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			int formId = FunctionLib.getInt((String) params.get("formId"));

			// 取得最近的流程实例
			int lastProcessId = FunctionLib.getLastProcessId(getSession(), processDefId, instanceId);

			String processUuid = java.util.UUID.randomUUID().toString();
			ProcessDefinition processDef = new ProcessDefinitionDao().selectRecordById(processDefId);
			getSession().flush();
			String processDesc = "";
			Query query;
			String fieldText = processDef.getProcessDesc();
			if (!"".equals(fieldText)) {
				if(fieldText.startsWith("select"))
				{
					query = getSession().createSQLQuery(fieldText);
					if(fieldText.toLowerCase().indexOf("instanceid")>-1)
						query.setParameter(":instanceid", instanceId);
					processDesc = FunctionLib.getString(query.list().get(0));
				}
				else
				{
					String fieldName = FunctionLib.getFormFieldName(getSession(), formId, fieldText);
					if (!"".equals(fieldName)) {
						query = getSession().createSQLQuery("select ifnull((select " + fieldName + " from core_form_main where ID_ = :instanceId),'') from dual");
						query.setParameter("instanceId", instanceId);
						processDesc = FunctionLib.getString(query.list().get(0));
					}
				}

			}
			getSession().flush();
			// 流程备注设置
			String note = "";
			if (mySession.getTempStr() != null && mySession.getTempStr().get("Process.note") != null)
				note = mySession.getTempStr().get("Process.note").toString();
			if (note.length() > 200) {
				getMySession().setMsg("请检查备注是否过长，不要超过200个汉字", 1);
				return;
			}
			
			// 创建流程实例
			Process bean = new Process();
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			bean.setProcessDefId(processDefId);
			bean.setInstanceId(instanceId);
			bean.setProcessDesc(processDesc);
			bean.setProcessStatus("running");
			bean.setStartDate(new java.util.Date());
			bean.setUUID_(processUuid);
			bean.setJobId(getMySession().getJobId());
			bean.setProcessNote(note);
			getSession().save(bean);
			getSession().flush();
			// 取得流程入口,也就是任务代码最小的任务
			query = getSession().getNamedQuery("core.processdefinition.task.firsttask");
			query.setParameter("headerId", processDefId);
			// currentTaskCode
			String firstTask = FunctionLib.getString(query.list().get(0));
			// 取得流程Id
			bean = this.selectRecordByUUID(processUuid);
			String sqlStr = processDef.getSqlWhenCreate();
			exceSql(sqlStr, bean.getID_(), instanceId);
			FunctionLib.refresh("processId=" + lastProcessId, "processId=" + bean.getID_());
			getMySession().setMsg("《" + processDesc + "》审批流程已经启动", 1);
			createTask(processDefId, firstTask, bean.getID_());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void createTask(int processDefId, String taskCode, int processId) {
		try {
			int taskDefId = FunctionLib.getTaskDefId(getSession(), processDefId, taskCode);
			new TaskDao().createTask(processDefId, processId, taskDefId, taskCode, 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void approve() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String taskUuid = (String) params.get("taskUuid");
			String taskStatus = (String) params.get("taskStatus");
			int instanceId = FunctionLib.getInt((String) params.get("instanceId"));

			String note = "";
			if (mySession.getTempStr() != null && mySession.getTempStr().get("Task.note") != null)
				note = mySession.getTempStr().get("Task.note").toString();
			if (note.length() > 200) {
				getMySession().setMsg("请检查审批意见是否过长，不要超过200个汉字", 1);
				return;
			}
			Task task = new TaskDao().selectRecordByUUID(taskUuid);
			ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(task.getTaskDefId());
			// 判断下一节点是否是自由审批节点，如果是就先弹出人员选择框
			int nextTaskDefId = new TaskDao().IsNextTaskIsFreedom(taskUuid);
			if(nextTaskDefId > 0){
				// 取得流程实例页面
				FacesContext context = FacesContext.getCurrentInstance();
				String url = context.getExternalContext().getRequestHeaderMap().get("referer");
				url = url.replace("processId=0", "processId=" + task.getProcessId());
				url = new Blowfish(FunctionLib.passwordKey).encryptString(url);
				note = java.net.URLEncoder.encode(note,"utf-8");
				FunctionLib.redirect(getMySession().getTemplateName(), "processuserpickers.jsf?uuid="+ taskUuid +"&instanceId="+instanceId+"&taskStatus="+ taskStatus +"&processId=" + task.getProcessId() + "&taskDefId=" + nextTaskDefId + "&taskFromId=" + task.getID_() + "&url=" + url + "&note=" + note);
			}
			else{
				new TaskDao().completeTask(taskDef.getHeaderId(), task.getProcessId(), taskDef.getTaskCode(), instanceId, taskUuid, taskStatus, note);
				getMySession().setMsg("审批完成", 1);
				mySession.getTempStr().put("Task.note", "");
				FunctionLib.refresh();
			}
		} catch (Exception ex) {
			getMySession().setMsg("审批遇到错误，请检查审批意见是否过长，不要超过200个汉字", 1);
			ex.printStackTrace();
		}
	}

	public void authorize() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String taskUuid = (String) params.get("taskUuid");

			Task task = new TaskDao().selectRecordByUUID(taskUuid);
			ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(task.getTaskDefId());

			if (getMySession().getTempInt() != null) {
				int agentId = getMySession().getTempInt().get("UserTree.id");
				//System.out.println("agentId:" + getMySession().getTempInt().get("UserTree.id"));
				if (agentId > 0) {
					TaskAgent bean = new TaskAgent();
					bean.setCID_(getMySession().getUserId());
					bean.setCDATE_(new java.util.Date());
					bean.setStartDate(new java.util.Date());
					// 设置有效期7天
					bean.setEndDate(new java.util.Date(new java.util.Date().getTime() + 7 * 24 * 60 * 60 * 1000));
					bean.setAgentId(agentId);
					bean.setTaskId(task.getID_());
					bean.setTaskDefId(taskDef.getID_());
					getSession().save(bean);
					getSession().flush();
					bean = null;
					UserInfo user = new UserInfo();
					String agent = user.selectRecordById(getSession(), agentId).getDisplayName();
					getMySession().setMsg("您已经授权给" + agent + "，取消授权后您才能审批当前任务！", 1);
				}
			}
			FunctionLib.refresh();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void completeProcess(int processId, String processStatus) {
		try {
			Process process = new ProcessDao().selectRecordById(processId);

			ProcessDefinition processDef = new ProcessDefinitionDao().selectRecordById(process.getProcessDefId());

			String sqlStr;
			if ("agree".equals(processStatus))
				sqlStr = processDef.getSqlWhenAgree();
			else
				sqlStr = processDef.getSqlWhenReject();
			exceSql(sqlStr, processId, process.getInstanceId());

			Query query = getSession().getNamedQuery("core.process.complete.where.id");
			query.setParameter("mId", getMySession().getUserId());
			query.setParameter("processStatus", processStatus);
			query.setParameter("id", processId);
			query.executeUpdate();
			// 取消正在运行中的任务
			query = getSession().getNamedQuery("core.task.cancel");
			query.setParameter("processId", processId);
			query.executeUpdate();
			if (processStatus.equals("agree"))
				processStatus = "审批已通过";
			else
				processStatus = "审批未通过";
			String subject = "您的流程《" + process.getProcessName() + ":" + process.getProcessDesc() + "》审批结果:" + processStatus;
			String message = subject;
			
			MessageList messageList = new MessageList();
			messageList.setEmail(FunctionLib.getUserMailByUserId(getSession(), process.getCID_()));
			messageList.setDisplayName(process.getApplicant());
			messageList.setHtmlContent(message);
			messageList.setTextContent(message);
			messageList.setSubject(subject);
			getSession().save(messageList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateProcessStatus(int processId, String processStatus) {
		try {
			Query query = getSession().getNamedQuery("core.process.update.record.status.where.id");
			query.setParameter("mId", getMySession().getUserId());
			query.setParameter("processStatus", processStatus);
			query.setParameter("id", processId);
			query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void completeProcessNote(String processId, String processStatus) {
		try {
			Query query = getSession().getNamedQuery("core.process.update.record.complete.where.id");
			query.setParameter("mId", getMySession().getUserId());
			query.setParameter("processStatus", processStatus);
			query.setParameter("id", processId);
			query.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 执行节点sql
	 * 
	 * @param query
	 * @param sqls
	 * @param processId
	 * @param instanceId
	 */
	public void exceSql(String sqls, int processId, int instanceId) {
		try {
			//System.out.println("sqls:" + sqls);
			if (null != sqls) {
				String[] sql = sqls.split(";");
				for (int i = 0; i < sql.length; i++) {
					if (!"".equals(sql[i])) {
						Query query = getSession().createSQLQuery(sql[i]);
						if (sqls.indexOf(":processid") > -1)
							query.setParameter("processid", processId);
						if (sqls.indexOf(":instanceid") > -1)
							query.setParameter("instanceid", instanceId);
						if (sqls.startsWith("select"))
							query.list();
						else
							query.executeUpdate();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
