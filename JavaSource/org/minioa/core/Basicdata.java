package org.minioa.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;

public class Basicdata {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
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

	private String init;

	public String getInit() {
		selectRecordById();
		return init;
	}

	private Map<String, String> prop;

	public void setProp(Map<String, String> data) {
		prop = data;
	}

	public Map<String, String> getProp() {
		if (prop == null)
			prop = new HashMap<String, String>();
		return prop;
	}

	private List<Basicdata> items;

	public List<Basicdata> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	public Basicdata() {
	}

	public Basicdata(int i) {
	}

	public Basicdata(Map<String, String> data) {
		setProp(data);
	}

	public List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			if(null == getMySession())
				return null;
			if (mySession == null)
				return null;
			dsList = new ArrayList<Integer>();

			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Basicdata.key") != null)
					key = mySession.getTempStr().get("Basicdata.key").toString();
			}

			String sql = getSession().getNamedQuery("core.basicdata.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and name like :key";
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");

			int i = 0;
			int dc = Integer.valueOf(String.valueOf(query.list().get(0)));
			while (i < dc) {
				dsList.add(i);
				i++;
			}
			mySession.setRowCount(dsList.size());
		}
		return dsList;
	}

	public void buildItems() {
		try {
			if(null == getMySession())
				return;
			getDsList();
			items = new ArrayList<Basicdata>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new Basicdata(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Basicdata.key") != null)
					key = mySession.getTempStr().get("Basicdata.key").toString();
			}

			String sql = getSession().getNamedQuery("core.basicdata.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.name, ta.sequence, ta.value, ta.value2";

			if (!key.equals(""))
				where += " and ta.name like :key";
			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");

			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("name", FunctionLib.getString(obj[6]));
				p.put("value", FunctionLib.getString(obj[7]));
				p.put("value2", FunctionLib.getString(obj[8]));
				p.put("sequence", FunctionLib.getString(obj[9]));
				items.add(new Basicdata(p));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 读取一条记录
	 */
	public void selectRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.basicdata.getrecordbyid");
				query.setParameter("id", id);
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					prop = new HashMap<String, String>();
					prop.put("id", FunctionLib.getString(obj[0]));
					prop.put("name", FunctionLib.getString(obj[6]));
					prop.put("value", FunctionLib.getString(obj[7]));
					prop.put("value2", FunctionLib.getString(obj[8]));
					prop.put("sequence", FunctionLib.getString(obj[9]));
				}
				it = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void newRecord() {
		try {
			getMySession();
			String sequence = prop.get("sequence");
			if(sequence.equals(""))
				sequence = "0";
			Query query = getSession().getNamedQuery("core.basicdata.newrecord");
			query.setParameter("cId", mySession.getUserId());
			query.setParameter("name", prop.get("name"));
			query.setParameter("value", prop.get("value"));
			query.setParameter("value2", prop.get("value2"));
			query.setParameter("sequence", sequence);
			query.executeUpdate();

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.basicdata.updaterecordbyid");
				query.setParameter("mId", mySession.getUserId());
				query.setParameter("name", prop.get("name"));
				query.setParameter("value", prop.get("value"));
				query.setParameter("value2", prop.get("value2"));
				query.setParameter("sequence", prop.get("sequence"));
				query.setParameter("id", id);
				query.executeUpdate();
				query = null;

				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("Basicdata.id");
			Query query = getSession().getNamedQuery("core.basicdata.deleterecordbyid");
			query.setParameter("id", id);
			query.executeUpdate();
			query = null;
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
			getMySession().getTempStr().put("Basicdata.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
