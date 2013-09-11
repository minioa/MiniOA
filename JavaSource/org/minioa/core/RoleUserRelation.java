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

public class RoleUserRelation {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	private int ID_, CID_;
	private String CDATE, init;
	private java.util.Date CDATE_;

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

	public void setCDATE(String data) {
		CDATE = data;
	}

	public String getCDATE() {
		return CDATE;
	}

	public void setCDATE_(java.util.Date data) {
		CDATE_ = data;
	}

	public java.util.Date getCDATE_() {
		return CDATE_;
	}

	public String getInit() {
		return init;
	}

	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		if(lang == null)
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

	private int roleId, userId;
	private String roleName, userName;

	public void setRoleId(int data) {
		roleId = data;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setUserId(int data) {
		userId = data;
	}

	public int getUserId() {
		return userId;
	}

	public void setRoleName(String data) {
		roleName = data;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setUserName(String data) {
		userName = data;
	}

	public String getUserName() {
		return userName;
	}

	private List<RoleUserRelation> items;

	public List<RoleUserRelation> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	private Map<Integer, Boolean> checkIdsMap = new HashMap<Integer, Boolean>();

	public void setCheckIdsMap(Map<Integer, Boolean> data) {
		checkIdsMap = data;
	}

	public Map<Integer, Boolean> getCheckIdsMap() {
		return checkIdsMap;
	}
	
	public RoleUserRelation() {
	}

	public RoleUserRelation(int id) {
		setID_(id);
	}

	public RoleUserRelation(int id, int cId, String cDate, int roleId, int userId, String rname, String uname) {
		setID_(id);
		setCID_(cId);
		setCDATE(cDate);
		setRoleId(roleId);
		setUserId(userId);
		setRoleName(rname);
		setUserName(uname);
	}

	public void mReset() {
		ID_ = CID_ = 0;
		CDATE = "";
		CDATE_ = null;
		roleId = userId = 0;
		roleName = userName = "";
	}

	public void buildItems() {
		try {
			getMySession();
			items = new ArrayList<RoleUserRelation>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String type = (String) params.get("type");
			String relationId = (String) params.get("relationId");
			if (null == type || null == relationId || "".equals(type) || "".equals(relationId)){
				if("".equals(getMySession().getTempStr().get("RoleUserRelation.relationId")))
					return;
				else
					relationId = getMySession().getTempStr().get("RoleUserRelation.relationId");
			}
			getMySession().getTempStr().put("RoleUserRelation.relationId", relationId);

			String sql = getSession().getNamedQuery("core.roleuserrelation.records").getQueryString();
			String whereSql = " where 1=1";
			if ("user".equals(type))
				whereSql = whereSql + " and userId = :relationId";
			else
				whereSql = whereSql + " and roleId = :relationId";
			Query query = getSession().createSQLQuery(sql + whereSql + " order by tb.roleName,tc.userName");
			query.setParameter("relationId", relationId);
			Iterator<?> it = query.list().iterator();

			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				items.add(new RoleUserRelation(FunctionLib.getInt(obj[0]), FunctionLib.getInt(obj[1]), FunctionLib.getDateString(obj[2]), FunctionLib.getInt(obj[3]), FunctionLib.getInt(obj[4]), FunctionLib.getString(obj[5]), FunctionLib.getString(obj[6])));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void newRecord() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String type = (String) params.get("type");
			String relationId = (String) params.get("relationId");
			if (null == type || null == relationId || "".equals(type) || "".equals(relationId))
				return;

			if (type.equals("role")) {
				if (userName == null || userName.equals("")) {
					String msg = getLang().getProp().get(getMySession().getL()).get("usernamecannotbeempty");
					getMySession().setMsg(msg, Integer.valueOf(0));
					return;
				}
				int userId = new User().getUserIdByUserName(getSession(), userName);
				if (userId == 0) {
					String msg = getLang().getProp().get(getMySession().getL()).get("usernameisnotexists");
					getMySession().setMsg(msg, Integer.valueOf(0));
					return;
				}

				RoleUserRelation bean = new RoleUserRelation();
				bean.setRoleId(Integer.valueOf(relationId));
				bean.setUserId(userId);
				bean.setCID_(getMySession().getUserId());
				bean.setCDATE_(new java.util.Date());
				getSession().save(bean);
				bean = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, Integer.valueOf(0));
			}
			if (type.equals("user")) {
				if (roleName == null || roleName.equals("")) {
					String msg = getLang().getProp().get(getMySession().getL()).get("rolenamecannotbeempty");
					getMySession().setMsg(msg, Integer.valueOf(0));
					return;
				}
				int roleId = new Role().getRoleIdByUserName(getSession(), roleName);
				if (roleId == 0) {
					String msg = getLang().getProp().get(getMySession().getL()).get("rolenameisnotexists");
					getMySession().setMsg(msg, Integer.valueOf(0));
					return;
				}

				RoleUserRelation bean = new RoleUserRelation();
				bean.setRoleId(roleId);
				bean.setUserId(Integer.valueOf(relationId));
				bean.setCID_(getMySession().getUserId());
				bean.setCDATE_(new java.util.Date());
				getSession().save(bean);
				bean = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, Integer.valueOf(0));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
		}
	}

	public void deleteRecords() {
		try {
			checkIdsMap = getMySession().getTempMap().get("RoleUserRelation.checkIdsMap");
			Query query;
			for (Map.Entry<Integer, Boolean> entry : checkIdsMap.entrySet()) {
				if (entry.getValue() == true) {
					query = getSession().getNamedQuery("core.roleuserrelation.deleterecordbyid");
					query.setParameter("id", entry.getKey());
					query.executeUpdate();
				}
			}
			query = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, Integer.valueOf(0));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String type = (String) params.get("type");
			String relationId = (String) params.get("relationId");
			getMySession().getTempStr().put("RoleUserRelation.type", type);
			getMySession().getTempStr().put("RoleUserRelation.relationId", relationId);
			getMySession().getTempMap().put("RoleUserRelation.checkIdsMap", checkIdsMap);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
