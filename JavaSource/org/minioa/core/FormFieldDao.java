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

import org.minioa.core.FormField;

public class FormFieldDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-27
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

	public FormFieldDao() {
	}

	public ArrayList<FormField> buildItems() {
		ArrayList<FormField> items = new ArrayList<FormField>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			if (!FunctionLib.isNum(formId))
				formId = "0";
			items = new ArrayList<FormField>();
			Criteria criteria = getSession().createCriteria(FormField.class);
			criteria.add(Restrictions.eq("formId", Integer.valueOf(formId)));
			criteria.addOrder(Order.asc("orderNum"));
			criteria.addOrder(Order.asc("fieldType"));
			criteria.addOrder(Order.asc("fieldName"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				FormField bean = (FormField) it.next();
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
			if (FunctionLib.isNum(formId)){
				Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.form.field.items");
				query.setParameter("formId", formId);
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

	public FormField selectRecordById() {
		FormField bean = new FormField();
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

	public FormField selectRecordById(Integer id) {
		FormField bean = new FormField();
		try {
			Criteria criteria = getSession().createCriteria(FormField.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (FormField) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(FormField bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			if (FunctionLib.isNum(formId)) {
				FormField bean2 = this.selectRecordById(bean.getID_());
				bean.setID_(null);
				bean.setFieldName(bean2.getFieldName());
				bean.setFieldType(bean2.getFieldType());
				bean.setFieldWidth(bean2.getFieldWidth());
				bean.setFormId(Integer.valueOf(formId));
				bean.setCID_(getMySession().getUserId());
				bean.setCDATE_(new java.util.Date());
				getSession().save(bean);
				bean = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(FormField bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
			}

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("FormField.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(FormField.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((FormField) it.next());
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
			getMySession().getTempStr().put("FormField.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
