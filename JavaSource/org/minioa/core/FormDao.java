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
import org.jboss.seam.ui.*;

import org.minioa.core.Form;

public class FormDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-25
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

	public FormDao() {
	}

	public List<Integer> buildDsList() {
		if(null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Form.key") != null)
					key = mySession.getTempStr().get("Form.key").toString();
				if (mySession.getTempStr().get("Form.key2") != null)
					key2 = mySession.getTempStr().get("Form.key2").toString();
			}

			String sql = getSession().getNamedQuery("core.form.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and formName like :key";
			if (!key2.equals(""))
				where += " and tableName like :key2";
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");

			int tc = Integer.valueOf(String.valueOf(query.list().get(0)));
			for (int i = 0; i < tc; i++)
				dsList.add(i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<Form> buildItems() {
		ArrayList<Form> items = new ArrayList<Form>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new Form());
				return items;
			}
			// 设置第一页
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Form.key") != null)
					key = mySession.getTempStr().get("Form.key").toString();
				if (mySession.getTempStr().get("Form.key2") != null)
					key2 = mySession.getTempStr().get("Form.key2").toString();
			}
			items = new ArrayList<Form>();
			Criteria criteria = getSession().createCriteria(Form.class);
			if (!key.equals(""))
				criteria.add(Restrictions.like("formName", key, MatchMode.ANYWHERE));
			if (!key2.equals(""))
				criteria.add(Restrictions.like("tableName", key2, MatchMode.ANYWHERE));
			criteria.addOrder(Order.desc("formName"));
			criteria.setMaxResults(mySession.getPageSize());
			criteria.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				Form bean = (Form) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Form selectRecordById() {
		Form bean = new Form();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("formId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Form selectRecordById(Integer id) {
		Form bean = new Form();
		try {
			Criteria criteria = getSession().createCriteria(Form.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Form) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(Form bean) {
		try {
			String uuid = java.util.UUID.randomUUID().toString();
			bean.setUUID_(uuid);
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			getSession().save(bean);
			getSession().flush();
			
			int id = FunctionLib.getIdByUUID(getSession(),"core_form", uuid);
			Op op = new Op();
			op.newRecord("form." + id + ".user", bean.getFormName() + "-表单记录创建者");
			op.newRecord("form." + id + ".admin", bean.getFormName() + "-表单管理员");
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(Form bean) {
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
			String id = getMySession().getTempStr().get("Form.id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.form.deleterecordbyid");
				query.setParameter("id", id);
				query.executeUpdate();
				getMySession().setMsg("已删除一张表单", 1);
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
			getMySession().getTempStr().put("Form.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public List<SelectItem> si;

	public List<SelectItem> getSi() {
		if (si == null)
			buildSi();
		return si;
	}

	public void buildSi() {
		si = new ArrayList<SelectItem>();
		try {
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.form.si");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				si.add(new SelectItem(FunctionLib.getString(obj[0]), FunctionLib.getString(obj[1])));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
