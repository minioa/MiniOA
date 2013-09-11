package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.jivesoftware.util.Blowfish;

import org.minioa.core.Prop;

public class PropDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-29
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

	public PropDao() {
	}

	public List<Integer> buildDsList() {
		if(null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Prop.key") != null)
					key = mySession.getTempStr().get("Prop.key").toString();
				if (mySession.getTempStr().get("Prop.key2") != null)
					key2 = mySession.getTempStr().get("Prop.key2").toString();
			}

			String sql = getSession().getNamedQuery("core.prop.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and propName like :key";
			if (!key2.equals(""))
				where += " and propDesc like :key2";
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

	public ArrayList<Prop> buildItems() {
		ArrayList<Prop> items = new ArrayList<Prop>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new Prop());
				return items;
			}
			// 设置第一页
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Prop.key") != null)
					key = mySession.getTempStr().get("Prop.key").toString();
				if (mySession.getTempStr().get("Prop.key2") != null)
					key2 = mySession.getTempStr().get("Prop.key2").toString();
			}
			items = new ArrayList<Prop>();
			Criteria criteria = getSession().createCriteria(Prop.class);
			if (!key.equals(""))
				criteria.add(Restrictions.like("propName", key, MatchMode.ANYWHERE));
			if (!key2.equals(""))
				criteria.add(Restrictions.like("propDesc", key2, MatchMode.ANYWHERE));
			criteria.addOrder(Order.asc("propName"));
			criteria.setMaxResults(mySession.getPageSize());
			criteria.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				Prop bean = (Prop) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Prop selectRecordById() {
		Prop bean = new Prop();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Prop.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					bean = (Prop) it.next();

				getMySession();
				mySession.getTempStr().clear();
				mySession.getTempStr().put(bean.getInputType(), "Y");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(Prop bean) {
		try {
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			getSession().save(bean);
			bean = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
			FunctionLib.systemProps.put(bean.getPropName(), bean.getPropValue());
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(Prop bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
				Application app = (Application) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Application");
				app.getProp().put(bean.getPropName(), bean.getPropValue());
				//
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
				if (bean.getPropName().equals("passwordKey")) {
					String oldkey = "";
					String password = "";
					String newpassword = "";
					Query query = getSession().createSQLQuery("select propValue from ofproperty where name = 'passwordkey'");
					oldkey = String.valueOf(query.list().get(0));
					query = getSession().createSQLQuery("select username,password from core_user");
					Iterator<?> it = query.list().iterator();
					while (it.hasNext()) {
						Object[] obj = (Object[]) it.next();
						password = new Blowfish(oldkey).decryptString(FunctionLib.getString(obj[1]));
						newpassword = new Blowfish(bean.getPropValue()).encryptString(password);
						query = getSession().createSQLQuery("update core_user set password = :password where username = :username");
						query.setParameter("username", FunctionLib.getString(obj[0]));
						query.setParameter("password", newpassword);
						query.executeUpdate();

						query = getSession().createSQLQuery("update ofuser set encryptedPassword = :password where username = :username");
						query.setParameter("username", FunctionLib.getString(obj[0]));
						query.setParameter("password", newpassword);
						query.executeUpdate();
					}
					query = getSession().createSQLQuery("update ofproperty set propValue = :propValue where name = 'passwordkey'");
					query.setParameter("propValue", bean.getPropValue());
					query.executeUpdate();
					FunctionLib.systemProps.put(bean.getPropName(), bean.getPropValue());
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
			String id = getMySession().getTempStr().get("Prop.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Prop.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((Prop) it.next());
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
			getMySession().getTempStr().put("Prop.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
