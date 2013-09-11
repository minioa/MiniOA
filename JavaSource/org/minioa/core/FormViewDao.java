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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.validator.InvalidStateException;
import org.hibernate.validator.InvalidValue;
import org.jboss.seam.ui.*;

import org.minioa.core.FormView;

public class FormViewDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-6
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

	public FormViewDao() {
	}

	public ArrayList<FormView> buildItems() {
		ArrayList<FormView> items = new ArrayList<FormView>();
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			if (!FunctionLib.isNum(formId))
				formId = "0";
			items = new ArrayList<FormView>();
			Criteria criteria = getSession().createCriteria(FormView.class);
			criteria.add(Restrictions.eq("formId", Integer.valueOf(formId)));
			criteria.addOrder(Order.asc("ID_"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				FormView bean = (FormView) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<SelectItem> buildSi() {
		ArrayList<SelectItem> si = new ArrayList<SelectItem>();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			if(null== formId && getMySession().getTempInt().containsKey("formViewId"))
				formId = String.valueOf(getMySession().getTempInt().get("formViewId"));
			if (FunctionLib.isNum(formId)) {
				Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.form.view.items");
				query.setParameter("formId", Integer.valueOf(formId));
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					si.add(new SelectItem(FunctionLib.getInt(obj[0]), FunctionLib.getString(obj[1])));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return si;
	}

	public FormView selectRecordById() {
		FormView bean = new FormView();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id))
				bean = selectRecordById(Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public FormView selectRecordById(Integer id) {
		FormView bean = new FormView();
		try {
			Criteria criteria = getSession().createCriteria(FormView.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (FormView) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(FormView bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			if (FunctionLib.isNum(formId)) {
				FormDao formDao = new org.minioa.core.FormDao();
				Form form = (Form) formDao.selectRecordById(Integer.valueOf(formId));
				
				String uuid = java.util.UUID.randomUUID().toString();
				bean.setUUID_(uuid);
				bean.setFormId(Integer.valueOf(formId));
				bean.setCID_(getMySession().getUserId());
				bean.setCDATE_(new java.util.Date());
				getSession().save(bean);
				
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
				getSession().flush();
				
				int id = FunctionLib.getIdByUUID(getSession(),"core_form_view", uuid);
				Op op = new Op();
				op.newRecord("form." + formId + ".view." + id + ".read", form.getFormName() + "-" + bean.getViewName() + "-浏览");
				bean = null;
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(FormView bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			String formId = (String) params.get("formId");
			if (FunctionLib.isNum(formId) && FunctionLib.isNum(id)) {
				FormDao formDao = new org.minioa.core.FormDao();
				Form form = (Form) formDao.selectRecordById(Integer.valueOf(formId));
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
			String id = getMySession().getTempStr().get("FormView.id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.form.view.deleterecordbyid");
				query.setParameter("id", id);
				query.executeUpdate();
				getMySession().setMsg("已删除一个表单视图", 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("FormView.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public List<SelectItem> menuSelectItem;

	public List<SelectItem> getMenuSelectItem() {
		if (menuSelectItem == null)
			buildMenuSelectItem();
		return menuSelectItem;
	}

	public void buildMenuSelectItem() {
		menuSelectItem = new ArrayList<SelectItem>();
		try {
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.form.view.selectitems");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				menuSelectItem.add(new SelectItem(FunctionLib.getString(obj[0]), FunctionLib.getString(obj[1])));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
