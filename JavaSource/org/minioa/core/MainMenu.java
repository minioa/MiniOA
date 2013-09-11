package org.minioa.core;

import java.util.Iterator;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.jboss.seam.ui.*;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

public class MainMenu {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-5-07
	 * 
	 * parentId上级菜单id,menuName 菜单名称, menuUrl菜单网址,menuTarget 菜单目标
	 */
	private int key;
	private int parentId, sequence;
	private String parentName, menuUrl, menuTarget;

	@NotEmpty
	@Length(min = 2, max = 24)
	private String menuName;

	public void setMenuName(String data) {
		menuName = data;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuUrl(String data) {
		menuUrl = data;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuTarget(String data) {
		menuTarget = data;
	}

	public String getMenuTarget() {
		return menuTarget;
	}

	public void setParentName(String data) {
		parentName = data;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentId(int data) {
		parentId = data;
	}

	public int getParentId() {
		return parentId;
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

	private String type;

	public void setType(String data) {
		type = data;
	}

	public String getType() {
		return type;
	}

	public MainMenu() {

	}

	
	public MainMenu(int parent, String pName, String name, String url, String target) {
		setParentId(parent);
		setParentName(pName);
		setMenuName(name);
		setMenuUrl(url);
		setMenuTarget(target);
	}
	/**
	 * 初始化变量
	 */
	public void reset() {
		parentId = 0;
		parentName = menuName = menuUrl = menuTarget = "";
	}
	
	/**
	 * 树形菜单：分用户权限
	 */
	private TreeNode<MainMenu> rootNode = null;

	public TreeNode<MainMenu> getTreeNode() {
		if(getMySession()==null)
			return null;
		if (rootNode == null)
			loadTree();
		return rootNode;
	}

	/*
	 * * Tree Node
	 * 
	 * @param parentCode
	 * 
	 * @param node
	 */
	public void addNodes(TreeNode<MainMenu> node, int parentId, String pName, String template) {
		try {
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.topmenu.getchildren.role");
			query.setParameter("parentId", parentId);
			query.setParameter("userId", getMySession().getUserId());
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
				TreeNodeImpl<MainMenu> nodeImpl = new TreeNodeImpl<MainMenu>();
				nodeImpl.setData(new MainMenu(id, pName, name, url, target));
				node.addChild(key, nodeImpl);
				key++;
				if (hasChild(id))
					addNodes(nodeImpl, id, name, template);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadTree() {
		try {
			rootNode = new TreeNodeImpl<MainMenu>();
			key = 1;
			if (hasChild(0))
				addNodes(rootNode, 0, "", getMySession().getTemplateName());
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
