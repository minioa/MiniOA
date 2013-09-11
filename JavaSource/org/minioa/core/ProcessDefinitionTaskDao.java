package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;

import org.minioa.core.ProcessDefinitionTask;

public class ProcessDefinitionTaskDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-22
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

	public ProcessDefinitionTaskDao() {
	}

	public ArrayList<ProcessDefinitionTask> buildItems() {
		ArrayList<ProcessDefinitionTask> items = new ArrayList<ProcessDefinitionTask>();
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String headerId = (String) params.get("headerId");
			if (!FunctionLib.isNum(headerId))
				return null;
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new ProcessDefinitionTask());
				return items;
			}

			items = new ArrayList<ProcessDefinitionTask>();
			String sql = getSession().getNamedQuery("core.processdefinition.task.items").getQueryString();
			Query query = getSession().createSQLQuery(sql).addEntity(ProcessDefinitionTask.class);
			query.setParameter("headerId", Integer.valueOf(headerId));
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				ProcessDefinitionTask bean = (ProcessDefinitionTask) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ProcessDefinitionTask selectRecordById() {
		ProcessDefinitionTask bean = new ProcessDefinitionTask();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id))
				bean = selectRecordById(Integer.valueOf(id));
			else {
				id = (String) params.get("ProcessDefinitionTaskId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
			if (bean.getTaskApproverId() == null) {
				getMySession().getTempInt().put("UserTree.id", 0);
				getMySession().getTempStr().put("UserTree.displayName", "");
			} else {
				String displayName = FunctionLib.getUserDisplayNameByUserId(getSession(), bean.getTaskApproverId());
				getMySession().getTempInt().put("UserTree.id", bean.getTaskApproverId());
				getMySession().getTempStr().put("UserTree.displayName", displayName);
			}
			if (bean.getTaskApproverJobId() == null) {
				getMySession().getTempInt().put("JobTree.id", 0);
				getMySession().getTempStr().put("JobTree.jobName", "");
			} else {
				String jobName = FunctionLib.getJobNameById(getSession(), bean.getTaskApproverJobId());
				getMySession().getTempInt().put("JobTree.id", bean.getTaskApproverJobId());
				getMySession().getTempStr().put("JobTree.jobName", jobName);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public ProcessDefinitionTask selectRecordById(Integer id) {
		ProcessDefinitionTask bean = new ProcessDefinitionTask();
		try {
			Criteria criteria = getSession().createCriteria(ProcessDefinitionTask.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (ProcessDefinitionTask) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}
	
	public ProcessDefinitionTask selectRecordByCode(int processDefId, String taskDefCode) {
		ProcessDefinitionTask bean = new ProcessDefinitionTask();
		try {
			Criteria criteria = getSession().createCriteria(ProcessDefinitionTask.class).add(Restrictions.eq("headerId", processDefId)).add(Restrictions.eq("taskCode", taskDefCode));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (ProcessDefinitionTask) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(ProcessDefinitionTask bean) {
		try {

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String headerId = (String) params.get("headerId");
			if (!FunctionLib.isNum(headerId))
				return;
			if (bean.getTaskNextStep().startsWith("approved"))
				bean.setTaskType("1");
			else
				bean.setTaskType("0");
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			bean.setHeaderId(Integer.valueOf(headerId));
			bean.setTaskApproverId(getMySession().getTempInt().get("UserTree.id"));
			bean.setTaskApproverJobId(getMySession().getTempInt().get("JobTree.id"));
			getSession().save(bean);
			bean = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(ProcessDefinitionTask bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				if (bean.getTaskNextStep().startsWith("approved"))
					bean.setTaskType("1");
				else
					bean.setTaskType("0");
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				bean.setTaskApproverId(getMySession().getTempInt().get("UserTree.id"));
				bean.setTaskApproverJobId(getMySession().getTempInt().get("JobTree.id"));
				getSession().update(bean);
				getSession().flush();
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
			String id = getMySession().getTempStr().get("ProcessDefinitionTask.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(ProcessDefinitionTask.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((ProcessDefinitionTask) it.next());
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
			getMySession().getTempStr().put("ProcessDefinitionTask.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
