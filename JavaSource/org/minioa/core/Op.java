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

public class Op {

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

	private List<Op> items;

	public List<Op> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	public Op() {
	}

	public Op(int i) {
	}

	public Op(Map<String, String> data) {
		setProp(data);
	}

	public List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			if(null == getMySession())
				return null;
			dsList = new ArrayList<Integer>();

			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Op.key") != null)
					key = mySession.getTempStr().get("Op.key").toString();
			}

			String sql = getSession().getNamedQuery("core.op.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and ta.opName like :key";
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
			items = new ArrayList<Op>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new Op(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Op.key") != null)
					key = mySession.getTempStr().get("Op.key").toString();
			}

			String sql = getSession().getNamedQuery("core.op.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.opName desc";

			if (!key.equals(""))
				where += " and ta.opName like :key";
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
				p.put("opName", FunctionLib.getString(obj[6]));
				p.put("opDesc", FunctionLib.getString(obj[7]));
				items.add(new Op(p));
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
			if (id == null || !FunctionLib.isNum(id))
				return;
			Query query = getSession().getNamedQuery("core.op.getrecordbyid");
			query.setParameter("id", id);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				prop = new HashMap<String, String>();
				prop.put("opName", FunctionLib.getString(obj[6]));
				prop.put("opDesc", FunctionLib.getString(obj[7]));
			}
			it = null;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void newRecord() {
		try {
			getMySession();
			if ("".equals(prop.get("opName"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("noempty");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (isRecordExists(prop.get("opName"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("opnamehasbeanexists");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}

			Query query = getSession().getNamedQuery("core.op.newrecord");
			query.setParameter("cId", 0);
			query.setParameter("opName", prop.get("opName"));
			query.setParameter("opDesc", prop.get("opDesc"));
			query.executeUpdate();

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public int newRecord(String opName, String opDesc) {
		try {
			getMySession();
			if (isRecordExists(opName)) {
				// update
				Query query = getSession().getNamedQuery("core.op.updaterecordbyopname");
				query.setParameter("mId", 0);
				query.setParameter("opName", opName);
				query.setParameter("opDesc", opDesc);
				query.executeUpdate();
				return 1;
			} else {
				// insert
				Query query = getSession().getNamedQuery("core.op.newrecord");
				query.setParameter("cId", 0);
				query.setParameter("opName", opName);
				query.setParameter("opDesc", opDesc);
				query.executeUpdate();
				return 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public boolean isRecordExists(String opName) {
		try {
			if (Integer.valueOf(FunctionLib.exeSql(getSession(), "core.op.isrecordexistbyname", "opName", opName, "float")) == 0)
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public boolean isRecordExists(String opName, String id) {
		try {
			if (Integer.valueOf(FunctionLib.exeSql(getSession(), "core.op.isrecordexistbyname.byid", "opName", opName, "id", id, "float")) == 0)
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public void updateRecordById() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(id))
				return;

			if ("".equals(prop.get("opName"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("noempty");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (isRecordExists(prop.get("opName"), id)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("opnamehasbeanexists");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			Query query = getSession().getNamedQuery("core.op.updaterecordbyid");
			query.setParameter("mId", 0);
			query.setParameter("opName", prop.get("opName"));
			query.setParameter("opDesc", prop.get("opDesc"));
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

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("Op.id");
			Query query = getSession().getNamedQuery("core.op.deleterecordbyid");
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
			getMySession().getTempStr().put("Op.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

}
