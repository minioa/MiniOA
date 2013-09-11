package org.minioa.core;

import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.jboss.seam.ui.*;
import org.jivesoftware.util.Blowfish;

public class ProcessUserPicker {

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

	private Map<Integer, Boolean> checkIdsMap = new HashMap<Integer, Boolean>();

	public void setCheckIdsMap(Map<Integer, Boolean> data) {
		checkIdsMap = data;
	}

	public Map<Integer, Boolean> getCheckIdsMap() {
		return checkIdsMap;
	}

	public void UpdateApprovers() {
		try {
			getSession();
			getMySession();
			// 单人或多人自由审批时设置人员
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			int processId = FunctionLib.getInt(params.get("processId"));
			int taskDefId = FunctionLib.getInt(params.get("taskDefId"));
			int taskFromId = FunctionLib.getInt(params.get("taskFromId"));
			int instanceId = FunctionLib.getInt(params.get("instanceId"));
			String url = (String) params.get("url");
			String note = (String) params.get("note");
			note = new String(note.getBytes("ISO-8859-1"),"UTF-8");
			String taskUuid = (String) params.get("uuid");
			String taskStatus = (String) params.get("taskStatus");
			url = new Blowfish(FunctionLib.passwordKey).decryptString(url);
			// 设置审批人
			int i = 0;
			for (Map.Entry<Integer, Boolean> entry : checkIdsMap.entrySet()) {
				if (entry.getValue())
					i++;
			}
			if(i > 0){
				// 先创建下一节点
				for (Map.Entry<Integer, Boolean> entry : checkIdsMap.entrySet()) {
					if (entry.getValue()) {
						Task task = WorkFlow.CreateTask(session, entry.getKey(), processId, taskDefId, taskFromId);
						WorkFlow.SendNotice(session, url, processId, task.getID_());
						i++;
					}
				}
				// 完成当前节点
				Task task = new TaskDao().selectRecordByUUID(taskUuid);
				ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(task.getTaskDefId());
				//System.out.println("note:" + note);
				//
				new TaskDao().completeTask(taskDef.getHeaderId(), task.getProcessId(), taskDef.getTaskCode(), instanceId, taskUuid, taskStatus, note);
				
				getMySession().setMsg("审批完成", 1);
				mySession.getTempStr().put("Task.note", "");
				FunctionLib.refresh();
			}
			FunctionLib.redirectUrl(url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void CompleteTask() {
		try {
			// 单人或多人自由审批时设置人员
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			int instanceId = FunctionLib.getInt(params.get("instanceId"));
			String url = (String) params.get("url");
			String note = (String) params.get("note");
			note = new String(note.getBytes("ISO-8859-1"),"UTF-8");
			String taskUuid = (String) params.get("uuid");
			String taskStatus = (String) params.get("taskStatus");
			url = new Blowfish(FunctionLib.passwordKey).decryptString(url);
			// 完成当前节点
			Task task = new TaskDao().selectRecordByUUID(taskUuid);
			ProcessDefinitionTask taskDef = new ProcessDefinitionTaskDao().selectRecordById(task.getTaskDefId());
			new TaskDao().completeTask(taskDef.getHeaderId(), task.getProcessId(), taskDef.getTaskCode(), instanceId, taskUuid, taskStatus, note);
			FunctionLib.redirectUrl(url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
