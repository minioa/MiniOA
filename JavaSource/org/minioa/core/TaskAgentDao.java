package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;

import org.minioa.core.TaskAgent;

public class TaskAgentDao {
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

	public TaskAgentDao() {
	}

	public ArrayList<TaskAgent> buildItems() {
		ArrayList<TaskAgent> items = new ArrayList<TaskAgent>();
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new TaskAgent());
				return items;
			}
			items = new ArrayList<TaskAgent>();
			Query query = getSession().getNamedQuery("core.task.agent.items");
			query.setParameter("cId", getMySession().getUserId());
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			Iterator<?> it = query.list().iterator();
			TaskAgent bean;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				bean = new TaskAgent();
				bean.setID_(FunctionLib.getInt(obj[0]));
				bean.setCID_(FunctionLib.getInt(obj[1]));
				bean.setCDATE(FunctionLib.getDateTimeString(obj[2]));
				bean.setMID_(FunctionLib.getInt(obj[3]));
				bean.setMDATE(FunctionLib.getDateTimeString(obj[4]));
				bean.setUUID_(FunctionLib.getString(obj[5]));
				bean.setTaskDefId(FunctionLib.getInt(obj[6]));
				bean.setStartDateTime(FunctionLib.getDateTimeString(obj[7]));
				bean.setEndDateTime(FunctionLib.getDateTimeString(obj[8]));
				bean.setAgentId(FunctionLib.getInt(obj[9]));
				bean.setProcessName(FunctionLib.getString(obj[10]));
				bean.setTaskName(FunctionLib.getString(obj[11]));
				bean.setAgent(FunctionLib.getString(obj[12]));
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public TaskAgent selectRecordById() {
		TaskAgent bean = new TaskAgent();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("taskAgentId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public TaskAgent selectRecordById(Integer id) {
		TaskAgent bean = new TaskAgent();
		try {
			Criteria criteria = getSession().createCriteria(TaskAgent.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()){
				bean = (TaskAgent) it.next();
				getMySession().getTempInt().put("UserTree.id", bean.getAgentId());
				UserInfo user = new UserInfo();
				String agent = user.selectRecordById(getSession(), bean.getAgentId()).getDisplayName();
				getMySession().getTempStr().put("UserTree.displayName", agent);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(TaskAgent bean) {
		try {
			if (getMySession().getTempInt() != null) {
				int agentId = getMySession().getTempInt().get("UserTree.id");
				if (agentId > 0) {
					bean.setCID_(getMySession().getUserId());
					bean.setCDATE_(new java.util.Date());
					bean.setTaskDefId(bean.getTaskDefId());
					bean.setAgentId(agentId);
					bean.setTaskId(-1);
					getSession().save(bean);
					getSession().flush();
					bean = null;
				}
			}
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(TaskAgent bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				if (getMySession().getTempInt() != null) {
					int agentId = getMySession().getTempInt().get("UserTree.id");
					if (agentId > 0) {
						bean.setMID_(getMySession().getUserId());
						bean.setMDATE_(new java.util.Date());
						bean.setID_(Integer.valueOf(id));
						bean.setTaskId(bean.getTaskId());
						bean.setAgentId(agentId);
						getSession().update(bean);
						getSession().flush();
						String msg = getLang().getProp().get(getMySession().getL()).get("success");
						getMySession().setMsg(msg, 1);
					}
				}
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("TaskAgent.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(TaskAgent.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()) {
					TaskAgent bean = (TaskAgent) it.next();
					// 删除设置
					getSession().delete(bean);
					//
					getSession().flush();
				}
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
			getMySession().getTempStr().put("TaskAgent.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public List<SelectItem> buildSi() {
		List<SelectItem> si = new ArrayList<SelectItem>();
		try {
			if (getMySession().getTempInt().containsKey("TaskAgent.processDefId")) {
				Integer headerId = Integer.valueOf(String.valueOf(getMySession().getTempInt().get("TaskAgent.processDefId")));
				if (headerId > 0) {
					Query query = getSession().getNamedQuery("core.processdefinition.task.si");
					query.setParameter("headerId", headerId);
					Iterator<?> it = query.list().iterator();
					while (it.hasNext()) {
						Object obj[] = (Object[]) it.next();
						si.add(new SelectItem(FunctionLib.getInt(obj[0]), FunctionLib.getString(obj[1])));
					}
				}
			} else
				getMySession().getTempInt().put("TaskAgent.processDefId", 1);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return si;
	}
}
