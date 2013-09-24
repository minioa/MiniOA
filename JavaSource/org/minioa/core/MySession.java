package org.minioa.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.HibernateEntityLoader;

public class MySession {

	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		return lang;
	}

	public Application application;

	public Application getApplication() {
		if (application == null)
			application = (Application) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Application");
		return application;
	}

	// 消息
	public String msg;
	public int msgType;

	public void setMsg(String data, int type) {
		msg = data;
		String host = getHost() + "/templates/" + this.getTemplateName() + "/";
		switch (type) {
		case 0:
			msgScript = "<script language=\"javascript\">if(document.getElementById('mpForMsg')) {document.getElementById('mpForMsgContentDiv').style.backgroundImage='url(" + host + "images/warning.png)';document.getElementById('mpForMsg').component.show();}</script>";
			subMsgScript = "<script language=\"javascript\">if(document.getElementById('mpForSubMsg')) {document.getElementById('mpForSubMsgContentDiv').style.backgroundImage='url(" + host + "images/warning.png)';document.getElementById('mpForSubMsg').component.show();}</script>";
			break;
		case 1:
			msgScript = "<script language=\"javascript\">if(document.getElementById('mpForMsg')) {document.getElementById('mpForMsgContentDiv').style.backgroundImage='url(" + host + "images/valid.png)';document.getElementById('mpForMsg').component.show();}</script>";
			subMsgScript = "<script language=\"javascript\">if(document.getElementById('mpForSubMsg')) {document.getElementById('mpForSubMsgContentDiv').style.backgroundImage='url(" + host + "images/valid.png)';document.getElementById('mpForSubMsg').component.show();}</script>";
			break;
		default:
			msgScript = "<script language=\"javascript\">if(document.getElementById('mpForMsg')) {document.getElementById('mpForMsgContentDiv').style.backgroundImage='url(" + host + "images/error.png)';document.getElementById('mpForMsg').component.show();}</script>";
			subMsgScript = "<script language=\"javascript\">if(document.getElementById('mpForSubMsg')) {document.getElementById('mpForSubMsgContentDiv').style.backgroundImage='url(" + host + "images/error.png)';document.getElementById('mpForSubMsg').component.show();}</script>";
		}
	}

	public String getMsg() {
		if ("".equals(msg)) {
			msgScript = "";
			subMsgScript = "";
		}
		return msg;
	}

	// 显示消息的脚本
	public String msgScript;

	public String getMsgScript() {
		msg = "";
		return msgScript;
	}

	// 显示消息的脚本
	public String subMsgScript;

	public String getSubMsgScript() {
		msg = "";
		return subMsgScript;
	}

	private String templateName;

	public void setTemplateName(String data) {
		templateName = data;
	}

	public String getTemplateName() {
		if (null == templateName || "".equals(templateName))
			templateName = "default";
		return templateName;
	}
	
	private String host;

	public void setHost(String data) {
		host = data;
	}

	public String getHost() {
		if (host == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			String httpOrHttps = FunctionLib.GetHttpOrHttps();
			host = httpOrHttps + context.getExternalContext().getRequestHeaderMap().get("host") + "/" + context.getExternalContext().getInitParameter("webAppName");
		}
		return host;
	}

	private String searchKeyWords;

	public void setSearchKeyWords(String data) {
		searchKeyWords = data;
	}

	public String getSearchKeyWords() {
		if (null == searchKeyWords || "".equals(searchKeyWords)) {
			if (null != getLang())
				searchKeyWords = getLang().getProp().get(this.getL()).get("searchkeywords");
		}
		return searchKeyWords;
	}

	/**
	 * User Language
	 */
	private String l;

	public void setL(String data) {
		l = data;
	}

	public String getL() {
		l = "zh-cn";
		return l;
	}

	private Map<String, String> tempStr;

	public void setTempStr(Map<String, String> data) {
		tempStr = data;
	}

	public Map<String, String> getTempStr() {
		if (tempStr == null)
			tempStr = new HashMap<String, String>();
		return tempStr;
	}

	private Map<String, Boolean> tempBoolean;

	public void setTempBoolean(Map<String, Boolean> data) {
		tempBoolean = data;
	}

	public Map<String, Boolean> getTempBoolean() {
		if (tempBoolean == null)
			tempBoolean = new HashMap<String, Boolean>();
		return tempBoolean;
	}

	private Map<String, Integer> tempInt;

	public void setTempInt(Map<String, Integer> data) {
		tempInt = data;
	}

	public Map<String, Integer> getTempInt() {
		if (tempInt == null)
			tempInt = new HashMap<String, Integer>();
		return tempInt;
	}

	private Map<String, java.util.Date> tempDate;

	public void setTempDate(Map<String, java.util.Date> data) {
		tempDate = data;
	}

	public Map<String, java.util.Date> getTempDate() {
		if (tempDate == null)
			tempDate = new HashMap<String, java.util.Date>();
		return tempDate;
	}

	private Map<String, Map<Integer, Boolean>> tempMap;

	public void setTempMap(Map<String, Map<Integer, Boolean>> data) {
		tempMap = data;
	}

	public Map<String, Map<Integer, Boolean>> getTempMap() {
		if (tempMap == null)
			tempMap = new HashMap<String, Map<Integer, Boolean>>();
		return tempMap;
	}

	public String tab;

	public void setTab(String data) {
		tab = data;
	}

	public String getTab() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String tab = (String) params.get("tab");
			if (tab != null && tab.substring(0, 3).equals("tab"))
				return tab;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "tab1";
	}

	public String isLogin;

	public void setIsLogin(String data) {
		isLogin = data;
	}

	public String getIsLogin() {
		if (isLogin == null || !isLogin.equals("true")) {
			if (formUrl == null || formUrl.equals("")) {
				FacesContext context = FacesContext.getCurrentInstance();
				formUrl = context.getExternalContext().getRequestHeaderMap().get("referer");
			}
			String url = getHost() + "/templates/" + this.getTemplateName() + "/login.jsf";
			isLogin = "<script language=\"javascript\">window.parent.location.href = '"+url+"';</script>";
		}
		return isLogin;
	}

	private String formUrl;

	public void setFormUrl(String data) {
		formUrl = data;
	}

	public String getFormUrl() {
		return formUrl;
	}

	public int userId;

	public void setUserId(int data) {
		userId = data;
	}

	public int getUserId() {
		return userId;
	}

	public int jobId;

	public void setJobId(int data) {
		jobId = data;
	}

	public int getJobId() {
		return jobId;
	}

	public String userName;

	public void setUserName(String data) {
		userName = data;
	}

	public String getUserName() {
		return userName;
	}

	public String email;

	public void setEmail(String data) {
		email = data;
	}

	public String getEmail() {
		return email;
	}

	public String displayName;

	public void setDisplayName(String data) {
		displayName = data;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String roleNames;

	public void setRoleNames(String data) {
		roleNames = data;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public String superior;

	public void setSuperior(String data) {
		superior = data;
	}

	public String getSuperior() {
		return superior;
	}

	public String depaName;

	public void setDepaName(String data) {
		depaName = data;
	}

	public String getDepaName() {
		return depaName;
	}

	public Integer depaId;

	public void setDepaId(Integer data) {
		depaId = data;
	}

	public Integer getDepaId() {
		return depaId;
	}

	public String ip;

	public void setIp(String data) {
		ip = data;
	}

	public String getIp() {
		return ip;
	}

	public int pageSize;

	public void setPageSize(int data) {
		pageSize = data;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int rowCount;

	public void setRowCount(int data) {
		rowCount = data;
	}

	public int getRowCount() {
		return rowCount;
	}

	private int pageCount;

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int data) {
		this.pageCount = data;
	}

	private int scrollerPage = 1;

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int data) {
		this.scrollerPage = data;
	}

	@SuppressWarnings("unused")
	private String pageInit;

	public String getPageInit() {

		if (scrollerPage != 1)
			scrollerPage = 1;
		return null;
	}

	public List<SelectItem> getPagesToScroll() {
		if (rowCount % pageSize == 0)
			pageCount = (int) (Math.ceil(rowCount / pageSize));
		else
			pageCount = (int) (Math.ceil(rowCount / pageSize)) + 1;
		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem(1));
		for (int i = 1; i <= pageCount; i++) {
			if (Math.abs(i - scrollerPage) < 10) {
				SelectItem item = new SelectItem(i);
				list.add(item);
			}
		}
		return list;
	}

	private int i, level;
	private StringBuffer sb, sb2;
	private String topMenu, leftMenu;

	public void setTopMenu(String data) {
		topMenu = data;
	}

	public String getTopMenu() {
		if (topMenu == null)
			buildTopMenu();
		return topMenu;
	}

	public void buildTopMenu() {
		try {
			String host = getHost() + "/templates/" + this.getTemplateName();
			i = 0;
			level = 0;
			sb = new StringBuffer();
			sb.append("<div class=\"menu\">\r\n");
			sb.append("<ul>\r\n");
			addNodes(0, host, this.getTemplateName());
			sb.append("</ul>\r\n");
			sb.append("</div>\r\n");
			topMenu = sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setLeftMenu(String data) {
		leftMenu = data;
	}

	public String getLeftMenu() {
		if (leftMenu == null)
			buildLeftMenu();
		return leftMenu;
	}

	public void buildLeftMenu() {
		try {
			String host = getHost() + "/templates/" + this.getTemplateName();
			sb2 = new StringBuffer();
			sb2.append("<div class=\"sidebarmenu\">\r\n");
			addNodes2(0, false, host, this.getTemplateName());
			sb2.append("</div>\r\n");
			leftMenu = sb2.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addNodes(int parentId, String host, String template) {
		try {
			level++;
			boolean hasChildren = false;
			String className = "";
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.topmenu.getchildren.role");
			query.setParameter("parentId", parentId);
			query.setParameter("userId", this.getUserId());
			query.setParameter("template", "%" + template + "%");
			Iterator<?> it = query.list().iterator();
			int id;
			String name, url, target;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = url = target = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					name = String.valueOf(obj[1]);
				if (obj[2] != null)
					url = String.valueOf(obj[2]);
				if (obj[3] != null)
					target = String.valueOf(obj[3]);
				hasChildren = hasChild(id, "topmenu");
				if (i == 0) {
					className = "class=\"current\"";
					i++;
				} else
					className = "";

				if (!"".equals(url))
					url = host + "/" + url;
				else
					url = "#";
				if (!hasChildren) {
					sb.append("<li><a " + className + " href=\"" + url + "\" target=\"" + target + "\">" + name + "</a></li>\r\n");
				} else {
					if (level == 2)
						className = "class=\"sub1\"";
					if (level == 3)
						className = "class=\"sub2\"";
					sb.append("<li><a " + className + " href=\"" + url + "\" target=\"" + target + "\">" + name + "<!--[if IE 7]><!--></a><!--<![endif]-->\r\n");
					sb.append("<!--[if lte IE 6]><table><tr><td><![endif]-->\r\n");
					sb.append("<ul>\r\n");
					className = "";
					addNodes(id, host, template);
					sb.append("</ul>\r\n");
					sb.append("<!--[if lte IE 6]></td></tr></table></a><![endif]-->\r\n");
					sb.append("</li>\r\n");
				}
			}
			level--;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addNodes2(int parentId, boolean isSubmenu, String host, String template) {
		try {
			boolean hasChildren = false;
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.leftmenu.getchildren.role");
			query.setParameter("parentId", parentId);
			query.setParameter("userId", this.getUserId());
			query.setParameter("template", "%" + template + "%");
			Iterator<?> it = query.list().iterator();
			int id;
			String name, url, target;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = url = target = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					name = String.valueOf(obj[1]);
				if (obj[2] != null)
					url = String.valueOf(obj[2]);
				if (obj[3] != null)
					target = String.valueOf(obj[3]);
				hasChildren = hasChild(id, "leftmenu");
				if (!"".equals(url))
					url = host + "/" + url;
				else
					url = "#";
				if (!hasChildren) {
					if (isSubmenu)
						sb2.append("<li><a href=\"" + url + "\" target=\"" + target + "\">" + name + "</a></li>\r\n");
					else
						sb2.append("<a class=\"menuitem_red\" href=\"" + url + "\" target=\"" + target + "\">" + name + "</a>\r\n");
				} else {
					if (isSubmenu)
						sb2.append("<li><a href=\"" + url + "\" target=\"" + target + "\">" + name + "</a></li>\r\n");
					else
						sb2.append("<a class=\"menuitem submenuheader\" href=\"" + url + "\" target=\"" + target + "\">" + name + "</a>\r\n");
					sb2.append("<div class=\"submenu\">\r\n");
					sb2.append("<ul>\r\n");
					addNodes2(id, true, host, template);
					sb2.append("</ul>\r\n");
					sb2.append("</div>\r\n");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean hasChild(int parentId, String menuName) {
		try {
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core." + menuName + ".haschildren");
			query.setParameter("parentId", parentId);
			if ("0".equals(String.valueOf(query.list().get(0))))
				return false;
			else
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private Map<String, Boolean> hasOp;

	public void setHasOp(Map<String, Boolean> data) {
		hasOp = data;
	}

	public Map<String, Boolean> getHasOp() {
		return hasOp;
	}

	public void buildOpList(Session s) {
		if (userId == 0)
			return;
		if (hasOp == null) {
			try {
				hasOp = new HashMap<String, Boolean>();
				Query query = s.getNamedQuery("core.oprolerelation.hasop");
				query.setParameter("userId", userId);
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					if (obj[1] == null)
						hasOp.put(String.valueOf(obj[0]), false);
					else
						hasOp.put(String.valueOf(obj[0]), true);
				}
				it = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public int currentValue;

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int data) {
		currentValue = data;
	}
	
	public int minValue;

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int data) {
		minValue = data;
	}
	
	public int maxValue;

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int data) {
		maxValue = data;
	}
}
