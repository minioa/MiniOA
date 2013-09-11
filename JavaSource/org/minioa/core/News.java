package org.minioa.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;
import java.io.Reader;
import java.io.StringReader;
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

public class News {

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

	private String uuid;

	public void setUuid(String data) {
		uuid = data;
	}

	public String getUuid() {
		return uuid;
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

	private List<News> items, panelList;

	public List<News> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	public List<News> getPanelList() {
		if (panelList == null)
			buildPanelList();
		return panelList;
	}

	public News() {
	}

	public News(int i) {
	}

	public News(Map<String, String> data) {
		setProp(data);
	}

	public List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			if(null == getMySession())
				return null;
			dsList = new ArrayList<Integer>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String cate = (String) params.get("cate");
			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("News.key") != null)
					key = mySession.getTempStr().get("News.key").toString();
			}

			String sql = getSession().getNamedQuery("core.news.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and match(keywords) against(:key in boolean mode)";
			if(null!=cate && !"".equals(cate))
				where += " and cate = :cate";
				
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", key);
			if(null!=cate && !"".equals(cate))
				query.setParameter("cate", cate);
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
			items = new ArrayList<News>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new News(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);
			String cate = (String) params.get("cate");
			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("News.key") != null)
					key = mySession.getTempStr().get("News.key").toString();
			}

			String sql = getSession().getNamedQuery("core.news.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.ID_ desc";

			if (!key.equals(""))
				where += " and match(ta.keywords) against(:key in boolean mode)";
			if(null!=cate && !"".equals(cate))
				where += " and ta.cate = :cate";
				
			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			if (!key.equals(""))
				query.setParameter("key", key);
			if(null!=cate && !"".equals(cate))
				query.setParameter("cate", cate);
			
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("uuid", FunctionLib.getString(obj[5]));
				p.put("cate", FunctionLib.getString(obj[6]));
				p.put("title", FunctionLib.getString(obj[7]));
				p.put("ispicnews", FunctionLib.getString(obj[8]));
				p.put("status", FunctionLib.getString(obj[9]));
				p.put("times", FunctionLib.getString(obj[10]));
				p.put("catename", FunctionLib.getString(obj[11]));
				items.add(new News(p));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void buildPanelList() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String cate = (String) params.get("cate");
			if (prop != null)
				return;
			if (null != cate && !"".equals(cate)) {
				panelList = new ArrayList<News>();
				Query query = getSession().getNamedQuery("core.news.catename");
				query.setParameter("cate", cate);
				prop = new HashMap<String, String>();
				prop.put("catename", FunctionLib.getString(query.list().get(0)));
				query = getSession().getNamedQuery("core.news.panellist");
				query.setParameter("cate", cate);
				Iterator<?> it = query.list().iterator();
				Map<String, String> p;
				int i = 0;
				long now = new java.util.Date().getTime();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					p = new HashMap<String, String>();
					i++;
					p.put("i", String.valueOf(i));
					p.put("id", String.valueOf(FunctionLib.getInt(obj[0])));
					p.put("cDate", FunctionLib.getDateString(obj[1]));
					p.put("uuid", FunctionLib.getString(obj[2]));
					p.put("title", FunctionLib.getSubString18(FunctionLib.getString(obj[3])));
					if (now - FunctionLib.getDate(obj[1]).getTime() < 86400000)
						p.put("isNew", "true");
					else
						p.put("isNew", "false");
					panelList.add(new News(p));
				}
				it = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 读取一条记录
	 */
	public void selectRecordById() {
		try {
			if(getMySession()==null)
				return;
			getMySession().getTempStr().put("News.status", "0");
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.news.getrecordbyid");
				query.setParameter("id", id);
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					prop = new HashMap<String, String>();
					prop.put("id", FunctionLib.getString(obj[0]));
					prop.put("cId", FunctionLib.getString(obj[1]));
					prop.put("cDate", FunctionLib.getDateTimeString(obj[2]));
					prop.put("uuid", FunctionLib.getString(obj[5]));
					prop.put("cate", FunctionLib.getString(obj[6]));
					prop.put("title", FunctionLib.getString(obj[7]));
					prop.put("content", FunctionLib.getString(obj[8]));
					prop.put("ispicnews", FunctionLib.getString(obj[9]));
					prop.put("status", FunctionLib.getString(obj[10]));
					prop.put("times", FunctionLib.getString(obj[11]));
					prop.put("cUser", FunctionLib.getString(obj[12]));
					prop.put("cateName", FunctionLib.getString(obj[13]));
					uuid = prop.get("uuid");
					getMySession().getTempStr().put("News.status", prop.get("status"));
				}
				it = null;
				//
				if ("true".equals(params.get("view"))) {
					query = getSession().getNamedQuery("core.news.updatetimesbyid");
					query.setParameter("id", id);
					query.executeUpdate();
				}
			}
			if (null == uuid || "".equals(uuid))
				uuid = java.util.UUID.randomUUID().toString();
			getMySession().getTempStr().put("NewsAttachment.uuid",uuid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void newRecord() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

			Query query = getSession().getNamedQuery("core.news.newrecord");
			query.setParameter("cId", mySession.getUserId());
			query.setParameter("uuid", (String) params.get("uuid"));
			query.setParameter("cate", prop.get("cate"));
			query.setParameter("title", prop.get("title"));
			query.setParameter("content", prop.get("content"));
			query.setParameter("ispicnews", prop.get("ispicnews"));
			query.setParameter("imgurl", prop.get("imgurl"));
			query.setParameter("keywords", getKeyWords(prop.get("title") + "," + prop.get("content")));
			query.executeUpdate();

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);

			if ("true".equals((String) params.get("redirect")))
				FunctionLib.redirect(getMySession().getTemplateName(), "news.jsf");

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
				Query query = getSession().getNamedQuery("core.news.updaterecordbyid");
				query.setParameter("mId", mySession.getUserId());
				query.setParameter("cate", prop.get("cate"));
				query.setParameter("title", prop.get("title"));
				query.setParameter("content", prop.get("content"));
				query.setParameter("ispicnews", prop.get("ispicnews"));
				query.setParameter("imgurl", prop.get("imgurl"));
				query.setParameter("keywords", getKeyWords(prop.get("title") + "," + prop.get("content")));
				query.setParameter("id", id);
				query.executeUpdate();
				query = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
			if ("true".equals((String) params.get("redirect")))
				FunctionLib.redirect(getMySession().getTemplateName(), "news.jsf");
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void approve() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.news.updatestatusbyid");
				query.setParameter("mId", mySession.getUserId());
				query.setParameter("status", (String) params.get("status"));
				query.setParameter("id", id);
				query.executeUpdate();
				query = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
			if ("true".equals((String) params.get("redirect")))
				FunctionLib.redirect(getMySession().getTemplateName(), "news.jsf");
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateTimesById() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.news.updatetimesbyid");
				query.setParameter("times", prop.get("times"));
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

	public void updateStatusById() {
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.news.updatestatusbyid");
				query.setParameter("status_", prop.get("status_"));
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
			String id = getMySession().getTempStr().get("News.id");
			Query query = getSession().getNamedQuery("core.news.deleterecordbyid");
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
			getMySession().getTempStr().put("News.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private String preView;

	public String getPreView() {
		getMySession();
		prop = new HashMap<String, String>();
		prop.put("title", mySession.getTempStr().get("News.title"));
		prop.put("content", mySession.getTempStr().get("News.content"));
		mySession.getTempStr().remove("News.title");
		mySession.getTempStr().remove("News.content");
		return "";
	}

	public void redirect() {
		Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		getMySession();
		mySession.getTempStr().put("News.title", prop.get("title"));
		mySession.getTempStr().put("News.content", prop.get("content"));
		FunctionLib.redirect(mySession.getTemplateName(), "newspreview.jsf?uuid=" + (String) params.get("uuid"));
	}

	public String newsPic;

	public String getNewsPic() {
		try {
			Query query = getSession().getNamedQuery("core.news.newspic.count");
			int count = FunctionLib.getInt(query.list().get(0));
			if (count == 0)
				return null;
			//最多提取5条图片新闻
			if(count > 5)
				count = 5;

			query = getSession().getNamedQuery("core.news.newspic");
			Iterator<?> it = query.list().iterator();
			prop = new HashMap<String, String>();
			StringBuffer text = new StringBuffer();
			StringBuffer js = new StringBuffer();
			String url, title, href;
			url = title = href = "";
			int i = 1;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				url = FunctionLib.getString(obj[3]);
				href = "newsview.jsf?id=" + FunctionLib.getString(obj[0]) + "&uuid=" + FunctionLib.getString(obj[2]);
				title = FunctionLib.getString(obj[1]);
				if (i == 1) {
					text.append("<");
					js.append("<");
				}
				text.append("<div id=\"pic" + i + "\" class=\"normal on\"><a href=\"" + href + "\"><img src=\"" + url + "\" title=\"" + title + "\" alt=\"" + title + "\" width=\"320\" height=\"220\" /></a><h2><a href=\"" + href + "\">" + title + "</a></h2></div>\r\n");
				js.append("<li onclick=\"setFocus(" + i + "," + count + ")\" style=\"overflow:visible;\">" + i + "</li>\r\n");
				i++;
			}
			it = null;
			if (js.toString().length() > 1) {
				prop.put("js", js.toString().substring(1));
				prop.put("text", text.toString().substring(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newsPic;
	}

	public static String getKeyWords(String str) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			Pattern p;
			Matcher m;
			String value;
			p = Pattern.compile("([\u4e00-\u9FA5]+|[^\\x00-\\x80\uFE30-\uFFA0]+)");
			m = p.matcher(str);
			Reader r;
			IKSegmentation ikSeg;
			while (m.find()) {
				value = m.group(0);
				r = new StringReader(value);
				ikSeg = new IKSegmentation(r, true);
				Lexeme lexeme;
				while ((lexeme = ikSeg.next()) != null) {
					sb.append(lexeme.getLexemeText() + " ");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}
}
