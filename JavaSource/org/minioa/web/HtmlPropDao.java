package org.minioa.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FunctionLib;
import org.minioa.core.MySession;

public class HtmlPropDao {

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

	public HtmlPropDao() {
	}

	public ArrayList<HtmlProp> buildItems() {
		ArrayList<HtmlProp> items = new ArrayList<HtmlProp>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String xtype = (String) params.get("xtype");
			items = new ArrayList<HtmlProp>();
			Criteria criteria = getSession().createCriteria(HtmlProp.class);
			criteria.add(Restrictions.eq("propType", xtype));
			criteria.addOrder(Order.desc("propName"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				HtmlProp bean = (HtmlProp) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public HtmlProp selectRecordById() {
		HtmlProp bean = new HtmlProp();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("PropId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public HtmlProp selectRecordById(Integer id) {
		HtmlProp bean = new HtmlProp();
		try {
			Criteria criteria = getSession().createCriteria(HtmlProp.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()){
				bean = (HtmlProp) it.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(HtmlProp bean) {
		try {
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			getSession().save(bean);
			getSession().flush();
			getMySession().setMsg("已创建一条记录", 1);
		} catch (Exception ex) {
			getMySession().setMsg("创建记录时遇到错误，请重试", 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(HtmlProp bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
				getMySession().setMsg("已修改记录", 1);
			}
		} catch (Exception ex) {
			getMySession().setMsg("修改记录时遇到错误，请重试", 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("Prop.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(HtmlProp.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()) {
					HtmlProp bean = (HtmlProp) it.next();
					getSession().delete(bean);
				}
			}
			getMySession().setMsg("已删除指定记录", 1);
		} catch (Exception ex) {
			getMySession().setMsg("删除记录时遇到错误，请重试", 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		getMySession().getTempStr().put("Prop.id", (String) params.get("id"));
	}
}
