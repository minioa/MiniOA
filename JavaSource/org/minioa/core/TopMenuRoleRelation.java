package org.minioa.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

public class TopMenuRoleRelation {
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

	private int ID_, CID_;

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

	private int key;
	private int menuId, roleId;
	private String menuName;
	private java.util.Date CDATE_;

	public void setCDATE_(java.util.Date data) {
		CDATE_ = data;
	}

	public java.util.Date getCDATE_() {
		return CDATE_;
	}

	public void setMenuId(int data) {
		menuId = data;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setRoleId(int data) {
		roleId = data;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setMenuName(String data) {
		menuName = data;
	}

	public String getMenuName() {
		return menuName;
	}

	private Map<Integer, Boolean> checkIdsMap = new HashMap<Integer, Boolean>();;

	public void setCheckIdsMap(Map<Integer, Boolean> data) {
		checkIdsMap = data;
	}

	public Map<Integer, Boolean> getCheckIdsMap() {
		return checkIdsMap;
	}

	public TopMenuRoleRelation() {
	}

	public TopMenuRoleRelation(int menuId, String mName, int roleId) {
		setMenuId(menuId);
		setMenuName(mName);
		setRoleId(roleId);
	}

	public void updateRecords() {
		try {
			// if(!getMySession().getHasOp().get("010502"))
			// return;

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String relationId = (String) params.get("relationId");
			if (FunctionLib.isNum(relationId)) {
				roleId = Integer.valueOf(relationId);
				Query query;
				for (Map.Entry<Integer, Boolean> entry : checkIdsMap.entrySet()) {
					if (!entry.getValue()) {
						query = getSession().getNamedQuery("core.topmenurolerelation.deleterecordbyid");
						query.setParameter("menuId", entry.getKey());
						query.setParameter("roleId", roleId);
						query.executeUpdate();
					} else {
						query = getSession().getNamedQuery("core.topmenurolerelation.isrecordexistbyid");
						query.setParameter("menuId", entry.getKey());
						query.setParameter("roleId", roleId);
						if (Integer.valueOf(String.valueOf(query.list().get(0))) == 0) {
							TopMenuRoleRelation bean = new TopMenuRoleRelation();
							bean.setID_(getMySession().getUserId());
							bean.setCDATE_(new java.util.Date());
							bean.setMenuId(entry.getKey());
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

	private TreeNode<TopMenuRoleRelation> rootNode = null;

	public TreeNode<TopMenuRoleRelation> getTreeNode() {
		if (rootNode == null)
			loadTree();
		return rootNode;
	}

	@SuppressWarnings("unchecked")
	public void addNodes(TreeNode<TopMenuRoleRelation> node, String relationId,int parentId, String pName) {
		try {
			Query query = getSession().getNamedQuery("core.topmenurolerelation.getchildren");
			query.setParameter("parentId", parentId);
			query.setParameter("relationId", relationId);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();				
				if (FunctionLib.getInt(obj[2]) > 0)
					checkIdsMap.put(FunctionLib.getInt(obj[0]), true);
				else
					checkIdsMap.put(FunctionLib.getInt(obj[0]), false);
				
				@SuppressWarnings("rawtypes")
				TreeNodeImpl nodeImpl = new TreeNodeImpl();
				nodeImpl.setData(new TopMenuRoleRelation(FunctionLib.getInt(obj[0]), FunctionLib.getString(obj[1]), FunctionLib.getInt(obj[2])));
				node.addChild(key, nodeImpl);
				key++;
				if (hasChild(FunctionLib.getInt(obj[0])))
					addNodes(nodeImpl, relationId, FunctionLib.getInt(obj[0]), FunctionLib.getString(obj[1]));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadTree() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String relationId = (String) params.get("relationId");
			
			String msg = getLang().getProp().get(getMySession().getL()).get("topmenu");
			rootNode = new TreeNodeImpl<TopMenuRoleRelation>();
			key = 1;
			if (hasChild(0))
				addNodes(rootNode, relationId, 0, msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean hasChild(int parentId) {
		try {
			Query query = getSession().getNamedQuery("core.topmenu.haschildren");
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
}
