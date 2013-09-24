package org.minioa.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;
import org.jivesoftware.util.Blowfish;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class User {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	private int ID_, CID_, MID_;
	private String CDATE, MDATE;
	private java.util.Date CDATE_, MDATE_;
	private String UUID_;

	public void setID_(int data) {
		ID_ = data;
	}

	public int getID_() {
		return ID_;
	}

	public void setCID_(int data) {
		CID_ = data;
	}

	public int getCID_() {
		return CID_;
	}

	public void setMID_(int data) {
		MID_ = data;
	}

	public int getMID_() {
		return MID_;
	}

	public void setCDATE(String data) {
		CDATE = data;
	}

	public String getCDATE() {
		return CDATE;
	}

	public void setMDATE(String data) {
		MDATE = data;
	}

	public String getMDATE() {
		return MDATE;
	}

	public void setCDATE_(java.util.Date data) {
		CDATE_ = data;
	}

	public java.util.Date getCDATE_() {
		return CDATE_;
	}

	public void setMDATE_(java.util.Date data) {
		MDATE_ = data;
	}

	public java.util.Date getMDATE_() {
		return MDATE_;
	}

	public void setUUID_(String data) {
		UUID_ = data;
	}

	public String getUUID_() {
		return UUID_;
	}

	private String displayName;

	public void setDisplayName(String data) {
		displayName = data;
	}

	public String getDisplayName() {
		return displayName;
	}

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

	private String initProfile;

	public String getInitProfile() {
		selectUserProfile();
		return initProfile;
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

	private List<User> items;

	public List<User> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	private String type;

	public void setType(String data) {
		type = data;
	}

	public String getType() {
		return type;
	}

	public User() {
		FunctionLib.getPasswordKey();
	}

	public User(int i) {
	}

	public User(Map<String, String> data) {
		setProp(data);
	}

	public User(String type, int i, String name) {
		setType(type);
		setID_(i);
		setDisplayName(name);
	}

	public List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			if(null == getMySession())
				return null;
			dsList = new ArrayList<Integer>();

			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("User.key") != null)
					key = mySession.getTempStr().get("User.key").toString();
				if (mySession.getTempStr().get("User.key2") != null)
					key2 = mySession.getTempStr().get("User.key2").toString();
			}

			String sql = getSession().getNamedQuery("core.user.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and ta.userName like :key";
			if (!key2.equals(""))
				where += " and ta.displayName like :key2";
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");

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
			items = new ArrayList<User>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new User(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("User.key") != null)
					key = mySession.getTempStr().get("User.key").toString();
				if (mySession.getTempStr().get("User.key2") != null)
					key2 = mySession.getTempStr().get("User.key2").toString();
			}

			String sql = getSession().getNamedQuery("core.user.records").getQueryString();
			String where = " where 1=1";
			String other = " order by convert(ta.displayName using gbk) asc";

			if (!key.equals(""))
				where += " and ta.userName like :key";
			if (!key2.equals(""))
				where += " and ta.displayName like :key2";
			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");

			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("depaId", FunctionLib.getString(obj[6]));
				p.put("jobId", FunctionLib.getString(obj[7]));
				p.put("jobId2", FunctionLib.getString(obj[8]));
				p.put("userName", FunctionLib.getString(obj[9]));
				p.put("email", FunctionLib.getString(obj[10]));
				p.put("phone", FunctionLib.getString(obj[11]));
				p.put("mobilePhone", FunctionLib.getString(obj[12]));
				p.put("gender", FunctionLib.getString(obj[13]));
				p.put("displayName", FunctionLib.getString(obj[14]));
				p.put("isLock", FunctionLib.getString(obj[15]));
				p.put("depaName", FunctionLib.getString(obj[16]));
				items.add(new User(p));
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
			if (FunctionLib.isNum(id))
				selectRecordById(Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectRecordById(int id) {
		try {
			String signameImage;
			Query query = getSession().getNamedQuery("core.user.getrecordbyid");
			query.setParameter("id", id);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				prop = new HashMap<String, String>();
				prop.put("id", FunctionLib.getString(obj[0]));
				prop.put("depaId", FunctionLib.getString(obj[6]));
				prop.put("jobId", FunctionLib.getString(obj[7]));
				prop.put("jobId2", FunctionLib.getString(obj[8]));
				prop.put("userName", FunctionLib.getString(obj[9]));
				prop.put("email", FunctionLib.getString(obj[10]));
				prop.put("phone", FunctionLib.getString(obj[11]));
				prop.put("mobilePhone", FunctionLib.getString(obj[12]));
				prop.put("gender", FunctionLib.getString(obj[13]));
				prop.put("displayName", FunctionLib.getString(obj[14]));
				prop.put("isLock", FunctionLib.getString(obj[15]));
				prop.put("password", FunctionLib.getString(obj[19]));
				signameImage = FunctionLib.getString(obj[20]);
				if(signameImage!=null && signameImage.length() > 0)
					signameImage = signameImage.replaceAll("\\\\", "/");
				else
					signameImage = "";
				prop.put("signameImage", signameImage);
				
				
				getMySession().getTempInt().put("DepartmentTree.id", FunctionLib.getInt(obj[6]));
				getMySession().getTempStr().put("DepartmentTree.depaName", FunctionLib.getString(obj[16]));
				getMySession().getTempInt().put("JobTree.id", FunctionLib.getInt(obj[7]));
				getMySession().getTempStr().put("JobTree.jobName", FunctionLib.getString(obj[17]));
				getMySession().getTempInt().put("JobTree.id2", FunctionLib.getInt(obj[8]));
				getMySession().getTempStr().put("JobTree.jobName2", FunctionLib.getString(obj[18]));
			}
			it = null;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectUserProfile() {
		try {
			Query query = getSession().getNamedQuery("core.user.getrecordbyid");
			query.setParameter("id", getMySession().getUserId());
			Iterator<?> it = query.list().iterator();
			String signameImage;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				prop = new HashMap<String, String>();
				prop.put("id", FunctionLib.getString(obj[0]));
				prop.put("depaId", FunctionLib.getString(obj[6]));
				prop.put("jobId", FunctionLib.getString(obj[7]));
				prop.put("jobId2", FunctionLib.getString(obj[8]));
				prop.put("userName", FunctionLib.getString(obj[9]));
				prop.put("email", FunctionLib.getString(obj[10]));
				prop.put("phone", FunctionLib.getString(obj[11]));
				prop.put("mobilePhone", FunctionLib.getString(obj[12]));
				prop.put("gender", FunctionLib.getString(obj[13]));
				prop.put("displayName", FunctionLib.getString(obj[14]));
				prop.put("isLock", FunctionLib.getString(obj[15]));
				prop.put("password", FunctionLib.getString(obj[19]));
				signameImage = FunctionLib.getString(obj[20]);
				if(signameImage!=null && signameImage.length() > 0)
					signameImage = signameImage.replaceAll("\\\\", "/");
				else
					signameImage = "";
				prop.put("signameImage", signameImage);
				String userName = prop.get("userName");
				String password = prop.get("password");
				password = new Blowfish(FunctionLib.passwordKey).decryptString(password);
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
				String referer = context.getExternalContext().getRequestHeaderMap().get("referer");
				String httpOrHttps = FunctionLib.GetHttpOrHttps();
				String url = FunctionLib.getWebAppName();
				if ("".equals(url))
					url = httpOrHttps + FunctionLib.getRequestHeaderMap("host") + "/autologin.jsf?url=";
				else
					url = httpOrHttps + FunctionLib.getRequestHeaderMap("host") + "/" + url + "/autologin.jsf?url=";
				prop.put("url", url + new Blowfish(FunctionLib.passwordKey).encryptString(userName + ";" + password + ";" + FunctionLib.getIp() + ";" + getMySession().getTemplateName()));

				getMySession().getTempInt().put("DepartmentTree.id", FunctionLib.getInt(obj[6]));
				getMySession().getTempStr().put("DepartmentTree.depaName", FunctionLib.getString(obj[16]));
				getMySession().getTempInt().put("JobTree.id", FunctionLib.getInt(obj[7]));
				getMySession().getTempStr().put("JobTree.jobName", FunctionLib.getString(obj[17]));
				getMySession().getTempInt().put("JobTree.id2", FunctionLib.getInt(obj[8]));
				getMySession().getTempStr().put("JobTree.jobName2", FunctionLib.getString(obj[18]));
			}
			it = null;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getUserPassword(String userName) {
		try {
			Query query = getSession().getNamedQuery("core.user.getpassword.byusername");
			query.setParameter("userName", userName);
			String password = String.valueOf(query.list().get(0));
			if (!"".equals(password))
				return new Blowfish(FunctionLib.passwordKey).decryptString(password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "0x1";
	}

	public void newRecord() {
		try {
			getMySession();
			if (!FunctionLib.isEmail(prop.get("email"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("emailcheckerror");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if ("".equals(prop.get("userName"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("noempty");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (isUserExists(prop.get("userName"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("usernamehasbeanexists");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (null == mySession.getTempInt().get("DepartmentTree.id") || null == mySession.getTempInt().get("JobTree.id")) {
				return;
			}
			if (mySession.getTempInt().get("DepartmentTree.id") == 0)
			{
				getMySession().setMsg("必须选择一个部门", 2);
				return ;
			}
			if ("".equals(prop.get("password")))
			{
				getMySession().setMsg("登录密码不能空！", 2);
				return ;
			}
			String enpasswd = new Blowfish(FunctionLib.passwordKey).encryptString(prop.get("password"));
			Query query = getSession().getNamedQuery("core.user.newrecord");
			query.setParameter("cId", 0);
			query.setParameter("depaId", mySession.getTempInt().get("DepartmentTree.id"));
			query.setParameter("jobId", mySession.getTempInt().get("JobTree.id"));
			query.setParameter("jobId2", mySession.getTempInt().get("JobTree.id2"));
			query.setParameter("userName", prop.get("userName"));
			query.setParameter("email", prop.get("email"));
			query.setParameter("phone", prop.get("phone"));
			query.setParameter("mobilePhone", prop.get("mobilePhone"));
			query.setParameter("displayName", prop.get("displayName"));
			query.setParameter("password", enpasswd);
			query.setParameter("gender", prop.get("gender"));
			query.setParameter("isLock", prop.get("isLock"));
			query.executeUpdate();

			query = getSession().getNamedQuery("core.user.of.update");
			query.setParameter("userName", prop.get("userName"));
			query.setParameter("password", enpasswd);
			query.executeUpdate();

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public boolean isUserExists(String userName) {
		try {
			if (Integer.valueOf(FunctionLib.exeSql(getSession(), "core.user.isrecordexistbyname", "userName", userName, "float")) == 0)
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public boolean isUserExists(String userName, String id) {
		try {
			if (Integer.valueOf(FunctionLib.exeSql(getSession(), "core.user.isrecordexistbyname.byid", "userName", userName, "id", id, "float")) == 0)
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

			if (!FunctionLib.isEmail(prop.get("email"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("emailcheckerror");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if ("".equals(prop.get("userName"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("noempty");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (isUserExists(prop.get("userName"), id)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("usernamehasbeanexists");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (null == mySession.getTempInt().get("DepartmentTree.id") || null == mySession.getTempInt().get("JobTree.id")) {
				return;
			}
			if (mySession.getTempInt().get("DepartmentTree.id") == 0)
			{
				getMySession().setMsg("必须选择一个部门", 2);
				return ;
			}
			Query query = getSession().getNamedQuery("core.user.updaterecordbyid");
			query.setParameter("mId", 0);
			query.setParameter("depaId", mySession.getTempInt().get("DepartmentTree.id"));
			query.setParameter("jobId", mySession.getTempInt().get("JobTree.id"));
			query.setParameter("jobId2", mySession.getTempInt().get("JobTree.id2"));
			query.setParameter("userName", prop.get("userName"));
			query.setParameter("email", prop.get("email"));
			query.setParameter("phone", prop.get("phone"));
			query.setParameter("mobilePhone", prop.get("mobilePhone"));
			query.setParameter("displayName", prop.get("displayName"));
			query.setParameter("gender", prop.get("gender"));
			query.setParameter("isLock", prop.get("isLock"));
			query.setParameter("id", id);
			query.executeUpdate();
			query = null;

			selectRecordById(Integer.valueOf(id));
			query = getSession().getNamedQuery("core.user.of.update");
			query.setParameter("userName", prop.get("userName"));
			query.setParameter("password", prop.get("password"));
			query.executeUpdate();

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);

		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateProfile() {
		try {
			getMySession();
			if (!FunctionLib.isEmail(prop.get("email"))) {
				String msg = getLang().getProp().get(getMySession().getL()).get("emailcheckerror");
				getMySession().setMsg(msg, Integer.valueOf(0));
				return;
			}
			if (null == mySession.getTempInt().get("DepartmentTree.id") || null == mySession.getTempInt().get("JobTree.id"))
				return;
			if (mySession.getTempInt().get("DepartmentTree.id") == 0)
			{
				getMySession().setMsg("必须选择一个部门", 2);
				return ;
			}
					
			Query query = getSession().getNamedQuery("core.user.updateprofile");
			query.setParameter("mId", 0);
			query.setParameter("depaId", mySession.getTempInt().get("DepartmentTree.id"));
			query.setParameter("jobId", mySession.getTempInt().get("JobTree.id"));
			query.setParameter("jobId2", mySession.getTempInt().get("JobTree.id2"));
			query.setParameter("email", prop.get("email"));
			query.setParameter("phone", prop.get("phone"));
			query.setParameter("mobilePhone", prop.get("mobilePhone"));
			query.setParameter("displayName", prop.get("displayName"));
			query.setParameter("gender", prop.get("gender"));
			query.setParameter("id", mySession.getUserId());
			query.executeUpdate();
			query = null;

			selectRecordById(mySession.getUserId());
			query = getSession().getNamedQuery("core.user.of.update");
			query.setParameter("userName", prop.get("userName"));
			query.setParameter("password", prop.get("password"));
			query.executeUpdate();

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updatePassword() {
		try {
			String oldpassword = prop.get("password");
			String newpassword = prop.get("password2");
			String confirmpassword = prop.get("password3");
			String password = getUserPassword(getMySession().getUserName());
			if (password.equals(oldpassword)) {
				if (!newpassword.equals("") && newpassword.equals(confirmpassword)) {
					String enpasswd = new Blowfish(FunctionLib.passwordKey).encryptString(newpassword);
					Query query = getSession().getNamedQuery("core.user.updatepassword");
					query.setParameter("password", enpasswd);
					query.setParameter("id", getMySession().getUserId());
					query.setParameter("mId", getMySession().getUserId());
					query.executeUpdate();
					query = null;

					selectRecordById(getMySession().getUserId());
					query = getSession().getNamedQuery("core.user.of.update");
					query.setParameter("userName", prop.get("userName"));
					query.setParameter("password", enpasswd);
					query.executeUpdate();

					String msg = getLang().getProp().get(getMySession().getL()).get("yourpasswordhasbeenupdate");
					getMySession().setMsg(msg, 1);
				} else {
					String msg = getLang().getProp().get(getMySession().getL()).get("confirmpasswordnotequalsnewpassword");
					getMySession().setMsg(msg, 2);
				}
			} else {
				String msg = getLang().getProp().get(getMySession().getL()).get("oldpasswordincorrect");
				getMySession().setMsg(msg, 2);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void initPassword() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(id))
				return;
			String defaultPassword = "123456";
			//String defaultPassword = FunctionLib.systemProps.get("defaultPassword");
			String enpasswd = new Blowfish(FunctionLib.passwordKey).encryptString(defaultPassword);
			Query query = getSession().getNamedQuery("core.user.updatepassword");
			query.setParameter("password", enpasswd);
			query.setParameter("id", id);
			query.setParameter("mId", getMySession().getUserId());
			query.executeUpdate();
			query = null;

			selectRecordById(Integer.valueOf(id));
			query = getSession().getNamedQuery("core.user.of.update");
			query.setParameter("userName", prop.get("userName"));
			query.setParameter("password", enpasswd);
			query.executeUpdate();

			getMySession().setMsg("已将"+ prop.get("userName") +"的密码初始化成" + defaultPassword, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
	
	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("User.id");

			Query query = getSession().getNamedQuery("core.user.of.delete");
			query.setParameter("id", id);
			query.executeUpdate();

			query = getSession().getNamedQuery("core.user.deleterecordbyid");
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
			getMySession().getTempStr().put("User.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void login() {
		try {
			String name = prop.get("userName");
			String pwd = prop.get("password");
			
			Application app = (Application) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Application");
			if ("Y".equals(app.getProp().get("validateCode"))) {
				String validateCode = prop.get("validateCode");
				String key = (String) (((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("key"));
				if ("".equals(validateCode)) {
					getMySession().setMsg("请输入验证码！", Integer.valueOf(2));
					return;
				}
				if (!key.equals(validateCode)) {
					getMySession().setMsg("验证码输入错误！", Integer.valueOf(2));
					return;
				}
			}

			if ("".equals(name) || "".equals(pwd)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("usernameorpasswordnoempty");
				getMySession().setMsg(msg, 2);
				return;
			}
			String password = getUserPassword(name);
			if (pwd.equals(password)) {
				String ip = FunctionLib.getIp();
				Query query = getSession().getNamedQuery("core.user.getrecordbyusername");
				query.setParameter("userName", name);
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					if ("Y".equals(FunctionLib.getString(obj[15]))) {
						String msg = getLang().getProp().get(getMySession().getL()).get("userhasbeenlocked");
						getMySession().setMsg(msg, 2);
						return;
					}
					getMySession().setUserId(FunctionLib.getInt(obj[0]));
					getMySession().setDepaId(FunctionLib.getInt(obj[6]));
					getMySession().setDepaName(FunctionLib.getString(obj[16]));
					getMySession().setEmail(FunctionLib.getString(obj[9]));
					getMySession().setDisplayName(FunctionLib.getString(obj[14]));
					getMySession().setIp(ip);
					getMySession().setJobId(FunctionLib.getInt(obj[7]));
					getMySession().buildOpList(getSession());
					getMySession().setTemplateName(prop.get("template"));
					getMySession().buildTopMenu();
					getMySession().buildLeftMenu();
				}
				it = null;
				getMySession().setUserName(name);
				getMySession().setIsLogin("true");

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
				String httpOrHttps = FunctionLib.GetHttpOrHttps();
				String url = FunctionLib.getWebAppName() + "/templates/" + getMySession().getTemplateName() + "/index.html";
				if ("".equals(url))
					url = httpOrHttps + FunctionLib.getRequestHeaderMap("host") + "/";
				else
					url = httpOrHttps + FunctionLib.getRequestHeaderMap("host") + "/" + url;
				
				response.sendRedirect(url);
				
				FunctionLib.sendOfMessage(app.getProp().get("openfireUsername"), name + " login, the ip is " + ip);

				String msg = getMySession().getDisplayName() + "登录到系统";
				FunctionLib.writelog(getSession(), getMySession().getUserId(), getMySession().getIp(), "login", 0, msg, "");

				System.out.println(name + " login at time " + FunctionLib.dtf.format(new java.util.Date()));
			} else {
				System.out.println(name + " attempt to login at time " + FunctionLib.dtf.format(new java.util.Date()));
				String msg = getLang().getProp().get(getMySession().getL()).get("usernameorpasswordincorrect");
				getMySession().setMsg(msg, 2);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private String autoLogin;

	public String getAutoLogin() {
		try {
			String url;
			Application app = (Application) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Application");
			if (!"true".equals(getMySession().getIsLogin())) {
				Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
				url = (String) params.get("url");
				url = new Blowfish(FunctionLib.passwordKey).decryptString(url);
				String[] arr = url.split(";");
				if (arr.length == 4) {
					String name = arr[0];
					String pwd = arr[1];
					String template = arr[3];
					String ip = FunctionLib.getIp();
					if (ip.equals(arr[2])) {
						String password = getUserPassword(name);
						if (pwd.equals(password)) {
							Query query = getSession().getNamedQuery("core.user.getrecordbyusername");
							query.setParameter("userName", name);
							Iterator<?> it = query.list().iterator();
							while (it.hasNext()) {
								Object obj[] = (Object[]) it.next();
								if ("Y".equals(FunctionLib.getString(obj[15])))
									return "";
								getMySession().setUserId(FunctionLib.getInt(obj[0]));
								getMySession().setDepaId(FunctionLib.getInt(obj[6]));
								getMySession().setDepaName(FunctionLib.getString(obj[16]));
								getMySession().setEmail(FunctionLib.getString(obj[9]));
								getMySession().setDisplayName(FunctionLib.getString(obj[14]));
								getMySession().setIp(FunctionLib.getIp());
								getMySession().setJobId(FunctionLib.getInt(obj[7]));
								getMySession().buildOpList(getSession());
								getMySession().setTemplateName(template);
								getMySession().buildTopMenu();
								getMySession().buildLeftMenu();
							}
							it = null;
							getMySession().setUserName(name);
							getMySession().setIsLogin("true");
							System.out.println(name + " auto login at time " + FunctionLib.dtf.format(new java.util.Date()) + ", ip is " + ip);

							FunctionLib.sendOfMessage(app.getProp().get("openfireUsername"), name + " auto login, the ip is " + ip);

							String msg = getMySession().getDisplayName() + "自动登录到系统";
							FunctionLib.writelog(getSession(), getMySession().getUserId(), getMySession().getIp(), "login", 0, msg, "");
						} else
							System.out.println(name + " attempt to auto login at time " + FunctionLib.dtf.format(new java.util.Date()) + ", ip is " + ip);
					} else
						System.out.println(name + ", auto login at time " + FunctionLib.dtf.format(new java.util.Date()) + ", ip is incorrect");
				}
			}
			url = FunctionLib.getWebAppName() + "/templates/" + getMySession().getTemplateName() + "/index.html";
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			// 返回http://或https://
			String httpOrHttps = FunctionLib.GetHttpOrHttps();
			if ("".equals(url))
				url = httpOrHttps + FunctionLib.getRequestHeaderMap("host") + "/";
			else
				url = httpOrHttps + FunctionLib.getRequestHeaderMap("host") + "/" + url;

			response.sendRedirect(url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public void logout() {
		try {
			String username = getMySession().getDisplayName();
			Application app = (Application) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Application");
			
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

			Query query = getSession().getNamedQuery("core.user.session.delete");
			query.setParameter("sessionId", request.getSession().getId());
			query.executeUpdate();

			String msg = getMySession().getDisplayName() + "安全退出系统";
			FunctionLib.writelog(getSession(), getMySession().getUserId(), getMySession().getIp(), "logout", 0, msg, "");

			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.invalidate();
			if (getMySession() != null)
				FunctionLib.redirect(getMySession().getTemplateName(), "index.html");
			FunctionLib.sendOfMessage(app.getProp().get("openfireUsername"), username + " log out!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getUserIdByUserName(Session s, String userName) {
		try {
			Query query = s.getNamedQuery("core.user.getid.byusername");
			query.setParameter("userName", userName);
			return FunctionLib.getInt(query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public String getUserInfoByUserName(Session s, String userName, String fieldName) {
		try {
			Query query = s.getNamedQuery("core.user.get" + fieldName + ".byusername");
			query.setParameter("userName", userName);
			return FunctionLib.getString(query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public void createUserList() {
		try {			
			String s = FunctionLib.getSeparator();
			String storedir = FunctionLib.getBaseDir() + "WEB-INF" + s + "classes" + s + "org" + s + "minioa" + s + "core" + s + "suggestionbox" + s;
			StringBuffer str = new StringBuffer();
			Query query = getSession().getNamedQuery("core.user.getuserlistwithdepa");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				str.append("\t<userentity>\r\n");
				str.append("\t\t<id>" + FunctionLib.getString(obj[0]) + "</id>\r\n");
				str.append("\t\t<name>" + FunctionLib.getString(obj[1]) + "</name>\r\n");
				str.append("\t\t<displayName>" + FunctionLib.getString(obj[2]) + "</displayName>\r\n");
				str.append("\t\t<depaName>" + FunctionLib.getString(obj[3]) + "</depaName>\r\n");
				str.append("\t</userentity>\r\n");
			}
			File oFile = new File(storedir + "userentitys.xml");
			//System.out.println(storedir + "userentitys.xml");
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(oFile), "UTF8"));
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
			writer.write("<userentitys>\r\n");
			writer.write(str.toString());
			writer.write("</userentitys>\r\n");
			writer.close();
			getMySession().setMsg("已创建userentitys.xml", 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void uploadListener(UploadEvent event) {
		String storedir = "upload" + FunctionLib.getSeparator() + "signame" + FunctionLib.getSeparator();
		if (FunctionLib.isDirExists(FunctionLib.getBaseDir() + storedir)) {
			try {
				Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
				String id = (String) params.get("id");
				if (FunctionLib.isNum(id))
					selectRecordById(Integer.valueOf(id));
				if(prop == null)
					return;
				String signameImage = prop.get("signameImage");
				if(signameImage!=null && signameImage.length() > 10){
					signameImage = signameImage.replaceAll("/", "\\\\");
					File file;
					file = new File(FunctionLib.getBaseDir() + signameImage);
					if (file.exists())
						file.delete();
				}
				
				List<UploadItem> itemList = event.getUploadItems();
				for (int i = 0; i < itemList.size(); i++) {
					UploadItem item = (UploadItem) itemList.get(i);
					String uuid = java.util.UUID.randomUUID().toString();
					String newFileName = uuid + FunctionLib.getFileType(item.getFileName());
					File file = new File(FunctionLib.getBaseDir() + storedir + newFileName);
					FileOutputStream out = new FileOutputStream(file);
					out.write(item.getData());
					out.close();

					String sql = "update core_user set signameImage = :signameImage where ID_ = :id";
					Query query = getSession().createSQLQuery(sql);
					query.setParameter("signameImage",storedir + newFileName);
					query.setParameter("id",id);
					query.executeUpdate();
				}
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			} catch (Exception ex) {
				String msg = getLang().getProp().get(getMySession().getL()).get("faield");
				getMySession().setMsg(msg, 2);
				ex.printStackTrace();
			}
		}
	}
}
