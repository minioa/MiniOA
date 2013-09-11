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

public class Search {
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

	private Map<String, String> prop;

	public void setProp(Map<String, String> data) {
		prop = data;
	}

	public Map<String, String> getProp() {
		if (prop == null)
			prop = new HashMap<String, String>();
		return prop;
	}

	private List<Search> items;

	public List<Search> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	public Search() {
	}

	public Search(int i) {
	}

	public Search(Map<String, String> data) {
		setProp(data);
	}

	public List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			if(null == getMySession())
				return null;
			dsList = new ArrayList<Integer>();
			Query query = getSession().getNamedQuery("core.search.count");
			query.setParameter("key", mySession.getSearchKeyWords());

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
			items = new ArrayList<Search>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new Search(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = mySession.getSearchKeyWords();
			Query query = getSession().getNamedQuery("core.search.selectrecords");
			query.setParameter("key", key);
			query.setParameter("limit", mySession.getPageSize());
			query.setParameter("offset", (Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			String str = "<span style=\"color:red;font-weight:bold\">" + key + "</span>";
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("uuid", FunctionLib.getString(obj[1]));
				p.put("title", FunctionLib.getString(obj[2]).replaceAll(key, str));
				p.put("content", FunctionLib.getString(obj[3]).replaceAll(key, str));
				items.add(new Search(p));
			}
			it = null;
			if ("true".equals((String) params.get("redirect")))
				FunctionLib.redirect(mySession.getTemplateName(), "search.jsf");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
