package org.minioa.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.jboss.seam.ui.*;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

public class LeftMenu {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 *
	 * parentId上级菜单id,menuName 菜单名称, menuUrl菜单网址,menuTarget 菜单目标
	 */
	private int key;
	private int ID_, CID_, MID_;
	private String CDATE, MDATE;
	private java.util.Date CDATE_, MDATE_;
	private String UUID_, init;
	public static SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

	public String getInit() {
		selectRecordById();
		return init;
	}

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

	public void setSequence(int data) {
		sequence = data;
	}

	public int getSequence() {
		return sequence;
	}
	
	private String templates;
	
	public void setTemplates(String data) {
		templates = data;
	}

	public String getTemplates() {
		return templates;
	}
	
	private Map<String, Boolean> menuTemplate = new HashMap<String, Boolean>();

	public void setMenuTemplate(Map<String, Boolean> data) {
		menuTemplate = data;
	}

	public Map<String, Boolean> getMenuTemplate() {
		return menuTemplate;
	}

	private List<LeftMenu> items;

	public List<LeftMenu> getItems() {
		if (items == null)
			buildItems();
		return items;
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

	private String type;

	public void setType(String data) {
		type = data;
	}

	public String getType() {
		return type;
	}

	public LeftMenu() {
		
	}

	public LeftMenu(int i) {
		setID_(i);
	}

	public LeftMenu(String type, int i, String name) {
		setType(type);
		setID_(i);
		setMenuName(name);
	}

	public LeftMenu(int parent, int id, String pName, String name, String url, String target) {
		setParentId(parent);
		setID_(id);
		setParentName(pName);
		setMenuName(name);
		setMenuUrl(url);
		setMenuTarget(target);
	}

	public LeftMenu(int id, int cId, String cDate, int mId, String mDate, String uuid, int parent, String name, String url, String target, int seq) {
		setID_(id);
		setCID_(cId);
		setCDATE(cDate);
		setMID_(mId);
		setMDATE(mDate);
		setUUID_(uuid);
		setParentId(parent);
		setMenuName(name);
		setMenuUrl(url);
		setMenuTarget(target);
		setSequence(seq);
	}

	/**
	 * 初始化变量
	 */
	public void reset() {
		ID_ = CID_ = MID_ = 0;
		CDATE = MDATE = UUID_ = "";
		CDATE_ = MDATE_ = null;
		parentId = 0;
		parentName = menuName = menuUrl = menuTarget = "";
	}

	/**
	 * 将全部记录加入列表
	 */
	public void buildItems() {
		try {
			getMySession();
			items = new ArrayList<LeftMenu>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				if (null != mySession.getTempInt() && mySession.getTempInt().containsKey("LeftMenu.rowcount")) {
					for (int i = 0; i < mySession.getTempInt().get("LeftMenu.rowcount"); i++)
						items.add(new LeftMenu(i));
					return;
				}
			}

			Query query = getSession().getNamedQuery("core.leftmenu.records");
			Iterator<?> it = query.list().iterator();
			int id, cId, mId;
			String cDate, mDate, uuid;
			java.util.Date cDate_, mDate_;
			int parent, seq;
			String name, url, target;
			int rowcount = 0;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = cId = mId = 0;
				cDate = mDate = uuid = "";
				cDate_ = mDate_ = null;
				parent = seq = 0;
				name = url = target = "";
				// 读取obj数据时，一定要确保obj不能为null
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					cId = Integer.valueOf(String.valueOf(obj[1]));
				if (obj[2] != null) {
					java.sql.Timestamp t = (java.sql.Timestamp) obj[2];
					cDate_ = new java.util.Date(t.getTime());
					cDate = dtf.format(cDate_);
				}
				if (obj[3] != null)
					mId = Integer.valueOf(String.valueOf(obj[3]));
				if (obj[4] != null) {
					java.sql.Timestamp t = (java.sql.Timestamp) obj[4];
					mDate_ = new java.util.Date(t.getTime());
					mDate = dtf.format(mDate_);
				}
				if (obj[5] != null)
					uuid = String.valueOf(obj[5]);
				if (obj[6] != null)
					parent = Integer.valueOf(String.valueOf(obj[6]));
				if (obj[7] != null)
					name = String.valueOf(obj[7]);
				if (obj[8] != null)
					url = String.valueOf(obj[8]);
				if (obj[9] != null)
					target = String.valueOf(obj[9]);
				if (obj[10] != null)
					seq = Integer.valueOf(String.valueOf(obj[10]));
				items.add(new LeftMenu(id, cId, cDate, mId, mDate, uuid, parent, name, url, target, seq));
				rowcount++;
			}
			it = null;

			mySession.getTempInt().put("LeftMenu.rowcount", rowcount);
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
			selectRecordById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectRecordById(String id) {
		try {
			Query query = getSession().getNamedQuery("core.leftmenu.getrecordbyid");
			query.setParameter("id", id);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				this.reset();
				Object obj[] = (Object[]) it.next();
				if (obj[0] != null)
					ID_ = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					CID_ = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[2] != null) {
					java.sql.Timestamp t = (java.sql.Timestamp) obj[2];
					CDATE_ = new java.util.Date(t.getTime());
					CDATE = dtf.format(CDATE_);
				}
				if (obj[3] != null)
					MID_ = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[4] != null) {
					java.sql.Timestamp t = (java.sql.Timestamp) obj[4];
					MDATE_ = new java.util.Date(t.getTime());
					MDATE = dtf.format(MDATE_);
				}
				if (obj[5] != null)
					UUID_ = String.valueOf(obj[5]);
				if (obj[6] != null)
					parentId = Integer.valueOf(String.valueOf(obj[6]));
				if (obj[7] != null)
					menuName = String.valueOf(obj[7]);
				if (obj[8] != null)
					menuUrl = String.valueOf(obj[8]);
				if (obj[9] != null)
					menuTarget = String.valueOf(obj[9]);
				if (obj[10] != null)
					sequence = Integer.valueOf(String.valueOf(obj[10]));
				if (obj[11] != null)
					templates = String.valueOf(obj[11]);
				//
				menuTemplate = new HashMap<String, Boolean>();
				if(templates.indexOf("default")>-1)
					menuTemplate.put("default", true);
				else
					menuTemplate.put("default", false);
				if(templates.indexOf("web")>-1)
					menuTemplate.put("web", true);
				else
					menuTemplate.put("web", false);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 新增一条记录，注意这里没有使用到insert语句，这是hibernate的特点
	 */
	public void newRecord() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String parentId = (String) params.get("parentId");
			if (!FunctionLib.isNum(parentId))
				return;
			if ("".equals(menuName)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("name") + getLang().getProp().get(getMySession().getL()).get("cannotbenull");
				getMySession().setMsg(msg, 2);
				return;
			}
			LeftMenu bean = new LeftMenu();
			bean.setParentId(Integer.valueOf(parentId));
			bean.setMenuName(menuName);
			bean.setMenuUrl(menuUrl);
			bean.setMenuTarget(menuTarget);
			bean.setSequence(sequence);
			bean.setCID_(0);
			bean.setCDATE_(new java.util.Date());
			templates = "";
			for (Map.Entry<String, Boolean> entry : menuTemplate.entrySet()) {
				if (entry.getValue()) {
					if("".equals(templates))
						templates = entry.getKey();
					else
						templates = templates + entry.getKey();
				}
			}
			bean.setTemplates(templates);
			getSession().save(bean);
			bean = null;

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);

		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 更新一条记录
	 */
	public void updateRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String parentId = (String) params.get("parentId");
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(parentId) || !FunctionLib.isNum(id))
				return;
			if ("".equals(menuName)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("name") + getLang().getProp().get(getMySession().getL()).get("cannotbenull");
				getMySession().setMsg(msg, 2);
				return;
			}
			Query query = getSession().getNamedQuery("core.leftmenu.updaterecordbyid");
			query.setParameter("mId", 0);
			query.setParameter("menuName", menuName);
			query.setParameter("menuUrl", menuUrl);
			query.setParameter("menuTarget", menuTarget);
			query.setParameter("sequence", sequence);
			query.setParameter("id", id);
			
			templates = "";
			for (Map.Entry<String, Boolean> entry : menuTemplate.entrySet()) {
				if (entry.getValue()) {
					if("".equals(templates))
						templates = entry.getKey();
					else
						templates = templates + entry.getKey();
				}
			}
			query.setParameter("templates", templates);
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
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(id))
				return;
			Query query = getSession().getNamedQuery("core.leftmenu.deleterecordbyid");
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

	public void moveRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String parentId = (String) params.get("parentId");
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(parentId) || !FunctionLib.isNum(id))
				return;
			getMySession().getTempStr().put("LeftMenu.move.id", id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("LeftMenu.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	private TreeNode rootNode = null;

	@SuppressWarnings("rawtypes")
	public TreeNode getTreeNode() {
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
	public void addNodes(TreeNode<LeftMenu> node, int parentId, String pName) {
		try {
			Query query = getSession().getNamedQuery("core.leftmenu.getchildren");
			query.setParameter("parentId", parentId);
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

				TreeNodeImpl<LeftMenu> nodeImpl = new TreeNodeImpl<LeftMenu>();
				nodeImpl.setData(new LeftMenu(id, id, pName, name, url, target));
				node.addChild(key, nodeImpl);
				key++;
				if (hasChild(id))
					addNodes(nodeImpl, id, name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadTree() {
		try {
			String msg = getLang().getProp().get(getMySession().getL()).get("leftmenu");
			rootNode = new TreeNodeImpl();
			key = 1;
			if (hasChild(0))
				addNodes(rootNode, 0, msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean hasChild(int parentId) {
		try {
			Query query = getSession().getNamedQuery("core.leftmenu.haschildren");
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

	public void processSelection(NodeSelectedEvent event) {
		try {
			HtmlTree tree = (HtmlTree) event.getComponent();
			LeftMenu bean = (LeftMenu) tree.getRowData();
			ID_ = bean.getID_();
			selectRecordById(String.valueOf(ID_));
			parentId = bean.getParentId();
			menuName = bean.getMenuName();
			parentName = bean.getParentName();
			if (FunctionLib.isNum(getMySession().getTempStr().get("LeftMenu.move.id"))) {
				Query query = getSession().getNamedQuery("core.leftmenu.moverecordbyid");
				query.setParameter("mId", 0);
				query.setParameter("parentId", ID_);
				query.setParameter("id", getMySession().getTempStr().get("LeftMenu.move.id"));
				query.executeUpdate();
				query = null;
				getMySession().getTempStr().put("LeftMenu.move.id", "");
				FunctionLib.refresh();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
