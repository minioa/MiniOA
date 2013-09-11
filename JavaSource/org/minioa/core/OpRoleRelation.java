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

public class OpRoleRelation {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
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

	private int ID_,CID_;

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
	private int opId, roleId;
	private String opName, opDesc;
	private java.util.Date CDATE_;
	public void setCDATE_(java.util.Date data) {
		CDATE_ = data;
	}

	public java.util.Date getCDATE_() {
		return CDATE_;
	}
	
	public void setOpId(int data) {
		opId = data;
	}

	public int getOpId() {
		return opId;
	}

	public void setRoleId(int data) {
		roleId = data;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setOpName(String data) {
		opName = data;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpDesc(String data) {
		opDesc = data;
	}

	public String getOpDesc() {
		return opDesc;
	}

	private List<OpRoleRelation> items;

	public List<OpRoleRelation> getItems() {
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

	public OpRoleRelation() {
	}

	public OpRoleRelation(int opId, String oname, String odesc, int roleId) {
		setOpId(opId);
		setOpName(oname);
		setOpDesc(odesc);
		setRoleId(roleId);
	}

	public void buildItems() {
		try {
			checkIdsMap.clear();
			items = new ArrayList<OpRoleRelation>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String relationId = (String) params.get("relationId");
			if (!FunctionLib.isNum(relationId))
				return;
			Query query = getSession().getNamedQuery("core.oprolerelation.records");
			query.setParameter("relationId", relationId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				if (FunctionLib.getInt(obj[5]) > 0)
					checkIdsMap.put(FunctionLib.getInt(obj[0]), true);
				else
					checkIdsMap.put(FunctionLib.getInt(obj[0]), false);
				items.add(new OpRoleRelation(FunctionLib.getInt(obj[0]), FunctionLib.getString(obj[3]), FunctionLib.getString(obj[4]), FunctionLib.getInt(obj[5])));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateRecords() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String relationId = (String) params.get("relationId");
			if (FunctionLib.isNum(relationId)) {
				roleId = Integer.valueOf(relationId);
				Query query;
				for (Map.Entry<Integer, Boolean> entry : checkIdsMap.entrySet()) {
					if (!entry.getValue()) {
						query = getSession().getNamedQuery("core.oprolerelation.deleterecordbyid");
						query.setParameter("opId", entry.getKey());
						query.setParameter("roleId", roleId);
						query.executeUpdate();
					} else {
						query = getSession().getNamedQuery("core.oprolerelation.isrecordexistbyid");
						query.setParameter("opId", entry.getKey());
						query.setParameter("roleId", roleId);
						if (Integer.valueOf(String.valueOf(query.list().get(0))) == 0) {
							OpRoleRelation bean = new OpRoleRelation();
							bean.setCID_(getMySession().getUserId());
							bean.setCDATE_(new java.util.Date());
							bean.setOpId(entry.getKey());
							bean.setRoleId(roleId);
							getSession().save(bean);
						}
					}
				}
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
