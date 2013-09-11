package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.jivesoftware.util.Blowfish;

import org.minioa.core.Task;

public class TaskDao {
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
		if (null == mySession)
			return null;
		if (!"true".equals(mySession.getIsLogin()))
			return null;
		return mySession;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	public TaskDao() {
	}

	public List<Integer> buildDsList() {
		if (null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String sql = getSession().getNamedQuery("core.task.items.count").getQueryString();
			String where = "";
			String key = "0";
			String key2 = "0";
			java.util.Date key3, key4;
			key3 = key4 = null;
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Task.key") != null)
					key = mySession.getTempStr().get("Task.key").toString();
				if (mySession.getTempStr().get("Task.key2") != null)
					key2 = mySession.getTempStr().get("Task.key2").toString();
			}

			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("Task.key3") != null)
					key3 = mySession.getTempDate().get("Task.key3");
				if (mySession.getTempDate().get("Task.key4") != null)
					key4 = mySession.getTempDate().get("Task.key4");
			}

			if (Integer.valueOf(key) > 0)
				where = where + " and th.ID_ = " + key;
			where = where + " and approverId = :userId";
			//
			if (key3 != null && key4 != null)
				where = where + " and ta.CDATE_ > :key3 and ta.MDATE_ < :key4";

			Query query = getSession().createSQLQuery(sql + where);
			query.setParameter("userId", mySession.getUserId());
			if (key3 != null && key4 != null) {
				query.setParameter("key3", key3);
				query.setParameter("key4", key4);
			}
			for (int i = 0; i < Integer.valueOf(String.valueOf(query.list().get(0))); i++)
				dsList.add(i);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<Task> buildItems() {
		ArrayList<Task> items = new ArrayList<Task>();
		try {
			if (null == getMySession())
				return null;
			//
			mySession.getTempStr().put("Task.hasOp", "N");
			mySession.getTempStr().put("Task.btnAgree", "N");
			mySession.getTempStr().put("Task.btnComplete", "N");
			mySession.getTempStr().put("Task.btnConfirm", "N");
			mySession.getTempStr().put("Task.btnReject", "N");
			mySession.getTempStr().put("Task.btnWithdraw", "N");
			mySession.getTempStr().put("Task.btnTakeback", "N");
			mySession.getTempStr().put("Task.btnAuthorize", "N");
			mySession.getTempStr().put("Task.notice", "N");
			mySession.getTempStr().put("Task.UUID_", "");
			mySession.getTempStr().put("Task.taskName", "");
			mySession.getTempStr().put("Task.agent", "");
			mySession.getTempInt().put("Task.agentId", 0);

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String instanceId = (String) params.get("instanceId");
			String processDefId = (String) params.get("processDefId");
			if (FunctionLib.isNum(instanceId) && FunctionLib.isNum(processDefId)) {
				// 记录文本框出现的次数，要求只要能出现一次
				int count = 0;
				items = new ArrayList<Task>();
				Query query = getSession().getNamedQuery("core.task.items");

				query.setParameter("instanceId", instanceId);
				query.setParameter("processDefId", processDefId);
				Iterator<?> it = query.list().iterator();
				Task bean;
				int version = 0;
				int processId = 0;
				String approverIds = "";
				int agentId = 0;
				String agentName = "";
				while (it.hasNext()) {
					Object[] obj = (Object[]) it.next();
					bean = getTaskFromObject(obj);
					approverIds = FunctionLib.getString(obj[26]);
					agentId = FunctionLib.getInt(obj[27]);
					agentName = FunctionLib.getString(obj[28]);

					if (processId != bean.getProcessId()) {
						processId = bean.getProcessId();
						version++;
					}
					bean.setProcessVersion(version);
					items.add(bean);
					if ("running".equals(bean.getTaskStatus())) {
						if (count == 0) {
							mySession.getTempStr().put("Task.UUID_", bean.getUUID_());
							mySession.getTempStr().put("Task.taskName", bean.getTaskName());
							mySession.getTempStr().put("Task.agent", agentName);
							mySession.getTempInt().put("Task.agentId", agentId);

							// 流程审批人是否有审批当前流程实例的权限，如果设置了代理人，则只有代理人可审批
							if (agentId == 0 && approverIds.indexOf("," + getMySession().getUserId() + ",") > -1) {
								mySession.getTempStr().put("Task.hasOp", "Y");
								mySession.getTempStr().put("Task.notice", "Y");
								if (bean.getTaskNextStep().indexOf("agree") > -1)
									mySession.getTempStr().put("Task.btnAgree", "Y");
								if (bean.getTaskNextStep().indexOf("complete") > -1)
									mySession.getTempStr().put("Task.btnComplete", "Y");
								if (bean.getTaskNextStep().indexOf("confirm") > -1)
									mySession.getTempStr().put("Task.btnConfirm", "Y");
								if (bean.getTaskNextStep().indexOf("reject") > -1)
									mySession.getTempStr().put("Task.btnReject", "Y");
								if (bean.getTaskNextStep().indexOf("withdraw") > -1)
									mySession.getTempStr().put("Task.btnWithdraw", "Y");
								if (bean.getTaskNextStep().indexOf("takeback") > -1)
									mySession.getTempStr().put("Task.btnTakeback", "Y");
								mySession.getTempStr().put("Task.btnAuthorize", "Y");
								count++;
							}
							if (agentId > 0 && getMySession().getUserId() == agentId) {
								mySession.getTempStr().put("Task.hasOp", "Y");
								mySession.getTempStr().put("Task.notice", "Y");
								if (bean.getTaskNextStep().indexOf("agree") > -1)
									mySession.getTempStr().put("Task.btnAgree", "Y");
								if (bean.getTaskNextStep().indexOf("confirm") > -1)
									mySession.getTempStr().put("Task.btnConfirm", "Y");
								if (bean.getTaskNextStep().indexOf("reject") > -1)
									mySession.getTempStr().put("Task.btnReject", "Y");
								if (bean.getTaskNextStep().indexOf("withdraw") > -1)
									mySession.getTempStr().put("Task.btnWithdraw", "Y");
								if (bean.getTaskNextStep().indexOf("takeback") > -1)
									mySession.getTempStr().put("Task.btnTakeback", "Y");
								count++;
							}
						}
					}
				}
				it = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<Task> buildItemsRunning() {
		ArrayList<Task> items = new ArrayList<Task>();
		try {
			getMySession();
			items = new ArrayList<Task>();
			String sql = getSession().getNamedQuery("core.task.items.running").getQueryString();
			String other = " order by ta.ID_ asc";
			String where = "";

			String key = "0";
			String key2 = "0";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Task.key") != null)
					key = mySession.getTempStr().get("Task.key").toString();
				if (mySession.getTempStr().get("Task.key2") != null)
					key2 = mySession.getTempStr().get("Task.key2").toString();
			}
			if (Integer.valueOf(key) > 0)
				where = where + " and th.ID_ = " + key;
			if ("0".equals(key2))
				where = where + " and (locate(concat(',',:userId,','),core_gettaskapproverids_f(ta.ID_,0)) > 0 or core_gettaskagentid_f(ta.ID_,0) = :userId)";
			else if ("1".equals(key2))
				where = where + " and locate(concat(',',:userId,','),core_gettaskapproverids_f(ta.ID_,0)) > 0 and core_gettaskagentid_f(ta.ID_,0) > 0";
			else
				where = where + " and core_gettaskagentid_f(ta.ID_,0) = :userId";

			Query query = getSession().createSQLQuery(sql + where + other);
			query.setParameter("userId", mySession.getUserId());
			Iterator<?> it = query.list().iterator();
			Task bean;
			while (it.hasNext()) {
				bean = getTaskFromObject((Object[]) it.next());
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<Task> buildItemsCompleted() {
		ArrayList<Task> items = new ArrayList<Task>();
		try {
			getMySession();
			items = new ArrayList<Task>();
			String sql = getSession().getNamedQuery("core.task.items.completed").getQueryString();
			String other = " order by ta.ID_ desc";
			String where = "";

			String key = "0";
			String key2 = "0";
			java.util.Date key3, key4;
			key3 = key4 = null;
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Task.key") != null)
					key = mySession.getTempStr().get("Task.key").toString();
				if (mySession.getTempStr().get("Task.key2") != null)
					key2 = mySession.getTempStr().get("Task.key2").toString();
			}

			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("Task.key3") != null)
					key3 = mySession.getTempDate().get("Task.key3");
				if (mySession.getTempDate().get("Task.key4") != null)
					key4 = mySession.getTempDate().get("Task.key4");
			}

			if (Integer.valueOf(key) > 0)
				where = where + " and th.ID_ = " + key;
			where = where + " and approverId = :userId";
			//
			if (key3 != null && key4 != null)
				where = where + " and ta.CDATE_ > :key3 and ta.MDATE_ < :key4";

			Query query = getSession().createSQLQuery(sql + where + other);
			query.setParameter("userId", mySession.getUserId());
			if (key3 != null && key4 != null) {
				query.setParameter("key3", key3);
				query.setParameter("key4", key4);
			}
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			Iterator<?> it = query.list().iterator();
			Task bean;
			while (it.hasNext()) {
				bean = getTaskFromObject((Object[]) it.next());
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Task getTaskFromObject(Object[] obj) {
		Task bean = new Task();
		bean.setID_(FunctionLib.getInt(obj[0]));
		bean.setCID_(FunctionLib.getInt(obj[1]));
		bean.setCDATE(FunctionLib.getDateTimeString(obj[2]));
		bean.setMID_(FunctionLib.getInt(obj[3]));
		bean.setMDATE(FunctionLib.getDateTimeString(obj[4]));
		bean.setUUID_(FunctionLib.getString(obj[5]));
		bean.setProcessId(FunctionLib.getInt(obj[6]));
		bean.setTaskDefId(FunctionLib.getInt(obj[7]));
		bean.setTaskName(FunctionLib.getString(obj[8]));
		bean.setStartDateTime(FunctionLib.getDateTimeString(obj[9]));
		bean.setEndDateTime(FunctionLib.getDateTimeString(obj[10]));
		bean.setTaskStatus(FunctionLib.getString(obj[11]));
		bean.setTaskStatusText(FunctionLib.getTaskStatusText(bean.getTaskStatus()));
		bean.setTaskApproveType(FunctionLib.getString(obj[12]));
		bean.setTaskNextStep(FunctionLib.getString(obj[13]));
		bean.setDuDateTime(FunctionLib.getDateTimeString(obj[14]));
		bean.setNote(FunctionLib.getString(obj[15]));
		bean.setApplicantId(FunctionLib.getInt(obj[16]));
		bean.setApproverId(FunctionLib.getInt(obj[17]));
		bean.setApplicant(FunctionLib.getString(obj[18]));
		bean.setApprover(FunctionLib.getString(obj[19]));
		bean.setProcessName(FunctionLib.getString(obj[20]) + "-" + FunctionLib.getString(obj[21]));
		bean.setFormId(FunctionLib.getInt(obj[22]));
		bean.setProcessDefId(FunctionLib.getInt(obj[23]));
		bean.setInstanceId(FunctionLib.getInt(obj[24]));
		bean.setWfPage(FunctionLib.getString(obj[25]));
		bean.setSignameImage(FunctionLib.getString(obj[29]));
		if(bean.getSignameImage()!=null && bean.getSignameImage().length() > 10)
			bean.setSignameImage(bean.getSignameImage().replaceAll("\\\\", "/"));
		return bean;
	}

	public Task selectRecordById() {
		Task bean = new Task();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("taskId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Task selectRecordByUUID() {
		Task bean = new Task();
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

	public Task selectRecordById(Integer id) {
		Task bean = new Task();
		try {
			Criteria criteria = getSession().createCriteria(Task.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Task) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Task selectRecordByUUID(String uuid) {
		Task bean = new Task();
		try {
			Criteria criteria = getSession().createCriteria(Task.class).add(Restrictions.eq("UUID_", uuid));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Task) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void updateRecordById(Task bean) {
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
			String id = getMySession().getTempStr().get("Task.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Task.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((Task) it.next());
			}
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Task.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 创建任务
	 * 
	 * @param processId
	 * @param taskDefId
	 * @param taskDefCode
	 * @param note
	 * @param uuid
	 */
	public int createTask(int processDefId, int processId, int taskDefId, String taskDefCode, int taskFromId) {
		try {
			getSession();
			getMySession();

			ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(taskDefId);

			Process process = new ProcessDao().selectRecordById(processId);
			int instanceId = process.getInstanceId();

			String taskNextStep = taskDef.getTaskNextStep().toLowerCase();
			// System.out.println("taskNextStep:" + taskNextStep);
			if (taskNextStep.startsWith("sql") || taskNextStep.startsWith("exp")) {
				// 如果是自动执行的sql
				Task task = WorkFlow.CreateTask(session, mySession.userId, processId, taskDefId, taskFromId);
				completeTask(processDefId, processId, taskDefCode, instanceId, task.getUUID_(), "auto", "");
			} else {
				// 取得流程实例页面
				FacesContext context = FacesContext.getCurrentInstance();
				String url = context.getExternalContext().getRequestHeaderMap().get("referer");
				url = url.replace("processId=0", "processId=" + processId);
				if (!taskDef.getTaskApproveType().equals("9")) {
					// 如果是自由流程就不重复创建节点任务了
					Task task = WorkFlow.CreateTask(session, mySession.userId, processId, taskDefId, taskFromId);
					WorkFlow.SendNotice(session, url, processId, task.getID_());
				}
				return 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 完成任务
	 * 
	 * @param processDefId
	 * @param taskDefCode
	 * @param instanceId
	 * @param uuid
	 * @param taskStatus
	 * @param note
	 */
	public int completeTask(int processDefId, int processId, String taskDefCode, int instanceId, String uuid, String taskStatus, String note) {
		try {

			/**
			 * taskType 0 表示是自动节点， 1表示是人工节点或称条件节点。
			 * 自动节点下的taskNextStep都会被执行，而人工节点下的taskNextStep一旦遇到符合条件的就停止继续执行 人工审批
			 * approved=agree:12;同意后执行节点12 approved=reject:1000;拒绝后结束流程
			 * approved=withdraw:1;退回至节点1 approved=takeback:1;收回至节点1
			 * approved=complete:1000;同意并结束 条件节点 sql(select 1 from dual)=1:12,13
			 * 12,13表示同时创建12和13这两个任务 条件节点 exp(1,2,3,4,5,6,3)=agree:3
			 * 表示任务1、任务2、任务3、任务4、任务5、任务6中只要有3个任务完成就才算完成 条件节点
			 * exp(subtaskcount(5))表示任务5所启动的任务且正在运行的数量，当等于零时表示完成
			 * ，该表达式指的是当任务6和7都完成时才启动任务8。
			 */
			getMySession();
			Task task = this.selectRecordByUUID(uuid);
			if (task.getID_() == 0)
				return 0;
			ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(task.getTaskDefId());

			Query query;
			StringBuffer nextTaskCode = new StringBuffer();
			String sql, result, next;
			if ("0".equals(taskDef.getTaskType())) {
				// 自动审批 sql方式
				if (taskDef.getTaskNextStep().startsWith("sql")) {
					// System.out.println("sql.getTaskNextStep:" +
					// taskDef.getTaskNextStep());
					String[] arr = taskDef.getTaskNextStep().split(";");
					for (int i = 0; i < arr.length; i++) {
						sql = result = next = "";
						String reg = "^sql\\((.*?)\\)=([0-9]{0,5}):([0-9,]*)$";
						Pattern pat = Pattern.compile(reg, Pattern.DOTALL);
						Matcher mac = pat.matcher(arr[i].toString());
						while (mac.find()) {
							sql = mac.group(1).toLowerCase();
							result = mac.group(2).toLowerCase();
							next = mac.group(3).toLowerCase();
						}
						if (!"".equals(sql)) {
							query = getSession().createSQLQuery(sql);
							if (sql.indexOf(":processid") > -1)
								query.setParameter("processid", task.getProcessId());
							if (sql.indexOf(":instanceid") > -1)
								query.setParameter("instanceid", instanceId);
							if (result.equals(String.valueOf(query.list().get(0)))) {
								note = "自动完成";
								WorkFlow.AutoCompleteTask(getSession(), processDefId, taskDefCode, task.getProcessId());
								nextTaskCode.append(next + ",");
								taskStatus = "auto";
							}
						}
					}
				}
				// 自动审批 exp方式
				if (taskDef.getTaskNextStep().startsWith("exp")) {
					String[] arr = taskDef.getTaskNextStep().split(";");
					// 固定节点exp(1,2,3,4,3)=agree:1000
					// 自由流程exp(subtaskcount(5))=agree:1000
					// 流程所有节点exp(alltaskcount(5))=agree:1000
					String reg = "^exp\\(([0-9,]*)\\)=(agree|auto|confirm|complete):([0-9,]*)$";
					String regSubTaskCount = "^exp\\(subtaskcount\\(([0-9]*)\\)\\)=(agree|auto|confirm|complete):([0-9,]*)$";
					String regAllTaskCount = "^exp\\(alltaskcount\\(([0-9]*)\\)\\)=(agree|auto|confirm|complete):([0-9,]*)$";
					String exp = "";
					for (int i = 0; i < arr.length; i++) {
						exp = arr[i].toString();
						if (exp.startsWith("exp(subtaskcount")) {
							Pattern pat = Pattern.compile(regSubTaskCount, Pattern.DOTALL);
							Matcher mac = pat.matcher(exp);
							while (mac.find()) {
								sql = mac.group(1);
								int count = this.getSubTaskCount(getSession(), processDefId, sql, task.getProcessId());
								result = mac.group(2);
								next = mac.group(3);
								// 当正在运行的子节点数量等于零时自动完成
								if (count == 0) {
									note = "自动完成";
									WorkFlow.AutoCompleteTask(getSession(), processDefId, taskDefCode, task.getProcessId());
									nextTaskCode.append(next + ",");
									taskStatus = "auto";
								}
							}
						} else if (exp.startsWith("exp(alltaskcount")) {
							Pattern pat = Pattern.compile(regAllTaskCount, Pattern.DOTALL);
							Matcher mac = pat.matcher(exp);
							while (mac.find()) {
								sql = mac.group(1);
								int count = this.getAllTaskCount(getSession(), processDefId, task.getProcessId());
								result = mac.group(2);
								next = mac.group(3);
								// 当正在运行的所有节点数量等于零时自动完成
								if (count == 0) {
									note = "自动完成";
									WorkFlow.AutoCompleteTask(getSession(), processDefId, taskDefCode, task.getProcessId());
									nextTaskCode.append(next + ",");
									taskStatus = "auto";
								}
							}

						} else {
							Pattern pat = Pattern.compile(reg, Pattern.DOTALL);
							Matcher mac = pat.matcher(exp);
							while (mac.find()) {
								sql = mac.group(1);
								result = mac.group(2);
								next = mac.group(3);
								// 必须完成的任务数量
								String[] st = sql.split(",");
								int checkcount = FunctionLib.getInt(st[st.length - 1]);
								int beenCompleteCount = 0;
								for (int j = 0; j < st.length - 1; j++) {
									if (result.equals(this.getLastTaskStatus(getSession(), processDefId, st[j], task.getProcessId())))
										beenCompleteCount++;
								}
								if (beenCompleteCount >= checkcount && checkcount > 0) {
									note = "自动完成";
									WorkFlow.AutoCompleteTask(getSession(), processDefId, taskDefCode, task.getProcessId());
									nextTaskCode.append(next + ",");
									taskStatus = "auto";
								}
							}
						}
					}
				}
			} else {
				// 人工审批
				if (taskDef.getTaskNextStep().startsWith("approved")) {
					String[] arr = taskDef.getTaskNextStep().split(";");
					for (int i = 0; i < arr.length; i++) {
						result = next = "";
						String reg = "^approved=(agree|reject|withdraw|takeback|complete|confirm):([0-9,]*)$";
						Pattern pat = Pattern.compile(reg, Pattern.DOTALL);
						Matcher mac = pat.matcher(arr[i].toString());
						while (mac.find()) {
							result = mac.group(1);
							next = mac.group(2);
						}
						if (taskStatus.equals(result)) {
							nextTaskCode.append(next);
							// 人工节点只要遇到符合条件的就停止继续往下执行
							break;
						}
					}
				}
			}

			if (taskStatus.equals("agree") || taskStatus.equals("reject") || taskStatus.equals("complete") || taskStatus.equals("withdraw") || taskStatus.equals("auto") || taskStatus.equals("takeback") || taskStatus.equals("confirm")) {
				if (!taskStatus.equals("auto")) {
					query = getSession().getNamedQuery("core.task.completetaskbyuuid");
					query.setParameter("approverId", getMySession().getUserId());
					query.setParameter("taskStatus", taskStatus);
					query.setParameter("note", note);
					query.setParameter("uuid", uuid);
					query.executeUpdate();
				}
				// 完成时执行SQL
				exceSql(taskDef.getSqlWhenCompleted(), task.getProcessId(), instanceId);
				if (nextTaskCode == null || nextTaskCode.equals(""))
					return 0;
				String[] arr = nextTaskCode.toString().split(",");
				for (int i = 0; i < arr.length; i++) {
					if (!arr[i].equals("") && FunctionLib.isNum(arr[i])) {
						if (arr[i].equals("1000")) {
							// 结束流程
							if (taskStatus.equals("auto") || taskStatus.equals("confirm") || taskStatus.equals("complete"))
								taskStatus = "agree";
							new ProcessDao().completeProcess(processId, taskStatus);
						} else {
							// 继续执行任务，如果是下一节点是自由节点，就终止创建新节点
							int pDefId = Integer.valueOf(processDefId);
							int taskDefId = FunctionLib.getTaskDefId(getSession(), pDefId, arr[i]);
							ProcessDefinitionTask taskDefTemp = new ProcessDefinitionTaskDao().selectRecordById(taskDefId);
							if(taskDefTemp.getTaskApproveType().equals("9")){
								// 如果下一节点是自由节点，且当前没有正在进行的节点，就结束流程
								int count = this.getAllTaskCount(getSession(), processDefId, task.getProcessId());
								if(count == 0)
									new ProcessDao().completeProcess(processId, taskStatus);
							}
							else
								this.createTask(pDefId, Integer.valueOf(processId), taskDefId, arr[i], task.getID_());
							taskDefTemp = null;
						}
					}
				}
				return 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int IsNextTaskIsFreedom(String uuid) {
		try {
			Task task = this.selectRecordByUUID(uuid);
			if (task.getID_() == 0)
				return 0;
			ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(task.getTaskDefId());
			// 人工审批
			if (taskDef.getTaskNextStep().startsWith("approved")) {
				String[] arr = taskDef.getTaskNextStep().split(";");
				for (int i = 0; i < arr.length; i++) {
					String next = "";
					String reg = "^approved=(agree|reject|withdraw|takeback|complete|confirm):([0-9,]*)$";
					Pattern pat = Pattern.compile(reg, Pattern.DOTALL);
					Matcher mac = pat.matcher(arr[i].toString());
					while (mac.find()) {
						next = mac.group(2);
					}
					// 判断next 是否是自由审批节点
					if (Integer.valueOf(next) > 0) {
						ProcessDefinitionTask taskDef2 = new ProcessDefinitionTaskDao().selectRecordByCode(taskDef.getHeaderId(), next);
						if (taskDef2.getTaskApproveType().equals("9"))
							return taskDef2.getID_();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
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

	/**
	 * 取得指定节点创建子节点的数量
	 * 
	 * @param s
	 * @param processDefId
	 * @param taskDefCode
	 * @param processId
	 * @return
	 */
	public int getSubTaskCount(Session s, int processDefId, String taskDefCode, int processId) {
		int subtaskcount = 0;
		try {
			Query query = s.createSQLQuery("select ifnull(core_task_getsubtaskcount_f(:pDefId,:taskDefCode,:pId),0)");
			query.setParameter("pDefId", processDefId);
			query.setParameter("taskDefCode", taskDefCode);
			query.setParameter("pId", processId);
			subtaskcount = FunctionLib.getInt(query.list().get(0));
			query = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return subtaskcount;
	}

	public int getAllTaskCount(Session s, int processDefId, int processId) {
		int subtaskcount = 0;
		try {
			Query query = s.createSQLQuery("select ifnull(core_task_getalltaskcount_f(:pDefId,:pId),0)");
			query.setParameter("pDefId", processDefId);
			query.setParameter("pId", processId);
			subtaskcount = FunctionLib.getInt(query.list().get(0));
			query = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return subtaskcount;
	}

	/**
	 * 取得指定节点的当前状态
	 * 
	 * @param s
	 * @param processDefId
	 * @param taskDefCode
	 * @param processId
	 * @return
	 */
	public String getLastTaskStatus(Session s, int processDefId, String taskDefCode, int processId) {
		String status = "";
		try {
			Query query = s.createSQLQuery("call core_getlasttaskstatus(:processDefId,:taskDefCode,:processId)");
			query.setParameter("processDefId", processDefId);
			query.setParameter("taskDefCode", taskDefCode);
			query.setParameter("processId", processId);
			status = String.valueOf(query.list().get(0));
			query = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
}
