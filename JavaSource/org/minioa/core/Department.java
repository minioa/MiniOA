package org.minioa.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

public class Department {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 * orgId单位id,parentId上级部门id,depaName 部门名称 depaDesc 部门描述
	 */
	private int key, level;
	private StringBuffer bf;
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

	private int orgId, parentId, sequence;
	private String orgName, parentName, depaName, depaDesc;

	public void setDepaName(String data) {
		depaName = data;
	}

	public String getDepaName() {
		return depaName;
	}

	public void setDepaDesc(String data) {
		depaDesc = data;
	}

	public String getDepaDesc() {
		return depaDesc;
	}

	public void setOrgName(String data) {
		orgName = data;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setParentName(String data) {
		parentName = data;
	}

	public String getParentName() {
		return parentName;
	}

	public void setOrgId(int data) {
		orgId = data;
	}

	public int getOrgId() {
		return orgId;
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

	private List<Department> items;

	public List<Department> getItems() {
		if (items == null)
			buildItems();
		return items;
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

	public Department() {
	}

	public Department(int i) {
		setID_(i);
	}

	public Department(String type, int i, String name) {
		setType(type);
		setID_(i);
		setDepaName(name);
	}

	public Department(int org, int parent, int id, String oName, String pName, String name, String desc) {
		setOrgId(org);
		setParentId(parent);
		setID_(id);
		setOrgName(oName);
		setParentName(pName);
		setDepaName(name);
		setDepaDesc(desc);
	}

	/**
	 * 构造函数，用于创建items
	 * 
	 * @param id
	 * @param cId
	 * @param cDate
	 * @param mId
	 * @param mDate
	 * @param uuid
	 * @param name
	 * @param desc
	 */
	public Department(int id, int cId, String cDate, int mId, String mDate, String uuid, int org, int parent, String name, String desc, int seq) {
		setID_(id);
		setCID_(cId);
		setCDATE(cDate);
		setMID_(mId);
		setMDATE(mDate);
		setUUID_(uuid);
		setOrgId(org);
		setParentId(parent);
		setDepaName(name);
		setDepaDesc(desc);
		setSequence(seq);
	}

	/**
	 * 初始化变量
	 */
	public void reset() {
		ID_ = CID_ = MID_ = 0;
		CDATE = MDATE = UUID_ = "";
		CDATE_ = MDATE_ = null;
		orgId = parentId = 0;
		orgName = parentName = depaName = depaDesc = "";
	}

	/**
	 * 将全部记录加入列表
	 */
	public void buildItems() {
		try {
			getMySession();
			items = new ArrayList<Department>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				if (null != mySession.getTempInt() && mySession.getTempInt().containsKey("Department.rowcount")) {
					for (int i = 0; i < mySession.getTempInt().get("Department.rowcount"); i++)
						items.add(new Department(i));
					return;
				}
			}

			Query query = getSession().getNamedQuery("core.department.records");
			Iterator<?> it = query.list().iterator();
			int id, cId, mId;
			String cDate, mDate, uuid;
			java.util.Date cDate_, mDate_;
			int org, parent, seq;
			String name, desc;
			int rowcount = 0;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = cId = mId = 0;
				cDate = mDate = uuid = "";
				cDate_ = mDate_ = null;
				org = parent = seq = 0;
				name = desc = "";
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
					org = Integer.valueOf(String.valueOf(obj[6]));
				if (obj[7] != null)
					parent = Integer.valueOf(String.valueOf(obj[7]));
				if (obj[8] != null)
					name = String.valueOf(obj[8]);
				if (obj[9] != null)
					desc = String.valueOf(obj[9]);
				if (obj[10] != null)
					seq = Integer.valueOf(String.valueOf(obj[10]));
				items.add(new Department(id, cId, cDate, mId, mDate, uuid, org, parent, name, desc, seq));
				rowcount++;
			}
			it = null;

			mySession.getTempInt().put("Department.rowcount", rowcount);
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
			Query query = getSession().getNamedQuery("core.department.getrecordbyid");
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
					orgId = Integer.valueOf(String.valueOf(obj[6]));
				if (obj[7] != null)
					parentId = Integer.valueOf(String.valueOf(obj[7]));
				if (obj[8] != null)
					depaName = String.valueOf(obj[8]);
				if (obj[9] != null)
					depaDesc = String.valueOf(obj[9]);
				if (obj[10] != null)
					sequence = Integer.valueOf(String.valueOf(obj[10]));
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
			String orgId = (String) params.get("orgId");
			String parentId = (String) params.get("parentId");
			if (!FunctionLib.isNum(orgId) || !FunctionLib.isNum(parentId))
				return;
			if ("".equals(depaName)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("name") + getLang().getProp().get(getMySession().getL()).get("cannotbenull");
				getMySession().setMsg(msg, 2);
				return;
			}
			Department bean = new Department();
			bean.setOrgId(Integer.valueOf(orgId));
			bean.setParentId(Integer.valueOf(parentId));
			bean.setDepaName(depaName);
			bean.setDepaDesc(depaDesc);
			bean.setSequence(sequence);
			bean.setCID_(0);
			bean.setCDATE_(new java.util.Date());
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
			String orgId = (String) params.get("orgId");
			String parentId = (String) params.get("parentId");
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(orgId) || !FunctionLib.isNum(parentId) || !FunctionLib.isNum(id))
				return;
			if ("".equals(depaName)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("name") + getLang().getProp().get(getMySession().getL()).get("cannotbenull");
				getMySession().setMsg(msg, 2);
				return;
			}
			Query query = getSession().getNamedQuery("core.department.updaterecordbyid");
			query.setParameter("mId", 0);
			query.setParameter("depaName", depaName);
			query.setParameter("depaDesc", depaDesc);
			query.setParameter("sequence", sequence);
			query.setParameter("id", id);
			query.executeUpdate();
			query = null;

			query = getSession().getNamedQuery("core.department.of.update");
			query.setParameter("id", id);
			query.executeUpdate();

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

			Query query = getSession().getNamedQuery("core.department.of.delete");
			query.setParameter("id", id);
			query.executeUpdate();

			query = getSession().getNamedQuery("core.department.deleterecordbyid");
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
			String orgId = (String) params.get("orgId");
			String parentId = (String) params.get("parentId");
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(orgId) || !FunctionLib.isNum(parentId) || !FunctionLib.isNum(id))
				return;
			getMySession().getTempStr().put("Department.move.id", id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Department.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	private TreeNode<Department> rootNode = null;

	public TreeNode<Department> getTreeNode() {
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

	public void addNodes(TreeNode<Department> node, int orgId, int parentId, String oName, String pName) {
		try {
			Query query = getSession().getNamedQuery("core.department.getchildren");
			query.setParameter("orgId", orgId);
			query.setParameter("parentId", parentId);
			Iterator<?> it = query.list().iterator();
			int id;
			String name, desc;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = desc = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					name = String.valueOf(obj[1]);
				if (obj[2] != null)
					desc = String.valueOf(obj[2]);
				TreeNodeImpl<Department> nodeImpl = new TreeNodeImpl<Department>();
				nodeImpl.setData(new Department(orgId, id, id, oName, pName, name, desc));
				node.addChild(key, nodeImpl);
				key++;
				if (hasChild(orgId, id))
					addNodes(nodeImpl, orgId, id, oName, name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadTree() {
		try {
			rootNode = new TreeNodeImpl<Department>();

			Query query = getSession().getNamedQuery("core.org.records");
			Iterator<?> it = query.list().iterator();
			int id;
			String name, desc;
			key = 1;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = desc = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[6] != null)
					name = String.valueOf(obj[6]);
				if (obj[7] != null)
					desc = String.valueOf(obj[7]);
				TreeNodeImpl<Department> nodeImpl = new TreeNodeImpl<Department>();
				nodeImpl.setData(new Department(id, 0, 0, name, name, name, desc));
				rootNode.addChild(key, nodeImpl);
				key++;
				addNodes(nodeImpl, id, 0, name, name);

			}
			it = null;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean hasChild(int orgId, int parentId) {
		try {
			Query query = getSession().getNamedQuery("core.department.haschildren");
			query.setParameter("orgId", orgId);
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
			Department bean = (Department) tree.getRowData();
			ID_ = bean.getID_();
			selectRecordById(String.valueOf(ID_));
			orgId = bean.getOrgId();
			parentId = bean.getParentId();
			orgName = bean.getOrgName();
			parentName = bean.getParentName();
			if (FunctionLib.isNum(getMySession().getTempStr().get("Department.move.id"))) {
				Query query = getSession().getNamedQuery("core.department.moverecordbyid");
				query.setParameter("mId", 0);
				query.setParameter("orgId", orgId);
				query.setParameter("parentId", ID_);
				query.setParameter("id", getMySession().getTempStr().get("Department.move.id"));
				query.executeUpdate();
				query = null;
				getMySession().getTempStr().put("Department.move.id", "");

				query = getSession().createSQLQuery("CALL core_of_update_group(:id)");
				query.setParameter("id", getMySession().getTempStr().get("Department.move.id"));
				query.executeUpdate();

				FunctionLib.refresh();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void buildTreeFile() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String type = (String) params.get("type");

			String filename = FunctionLib.getBaseDir();
			if ("departmentTree".equals(type)) {
				filename = filename + "department.properties";
			} else {
				filename = filename + "user.properties";
			}

			bf = new StringBuffer();
			rootNode = new TreeNodeImpl<Department>();

			Query query = getSession().getNamedQuery("core.org.records");
			Iterator<?> it = query.list().iterator();
			int id;
			String name;
			level = 1;
			int i = 1;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[6] != null)
					name = String.valueOf(obj[6]);
				bf.append(i + "=org," + id + "," + FunctionLib.gb23122Unicode(name) + "\r\n");
				addChildren(String.valueOf(i), id, 0, name, name, type);
				i++;
			}
			it = null;

			File f = new File(filename);
			if (f.exists())
				f.delete();
			FileWriter fstream = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(bf.toString());
			out.close();
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void addChildren(String parentKey, int orgId, int parentId, String oName, String pName, String type) {
		try {
			level++;
			Query query = getSession().getNamedQuery("core.department.getchildren");
			query.setParameter("orgId", orgId);
			query.setParameter("parentId", parentId);
			Iterator<?> it = query.list().iterator();
			int id;
			String name;
			int i = 1;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					name = String.valueOf(obj[1]);
				bf.append(parentKey + "." + i + "=depa," + id + "," + FunctionLib.gb23122Unicode(name) + "\r\n");
				if ("userTree".equals(type))
					addChildrenUsers(parentKey + "." + i, id, name, name);

				if (hasChild(orgId, id))
					addChildren(parentKey + "." + i, orgId, id, oName, name, type);
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addChildrenUsers(String parentKey, int depaId, String oName, String pName) {
		try {
			level++;
			Query query = getSession().getNamedQuery("core.department.getusers");
			query.setParameter("depaId", depaId);
			Iterator<?> it = query.list().iterator();
			int id;
			String name;
			int i = 1;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = 0;
				name = "";
				if (obj[0] != null)
					id = Integer.valueOf(String.valueOf(obj[0]));
				if (obj[1] != null)
					name = String.valueOf(obj[1]);
				bf.append(parentKey + "." + i + "=user," + id + "," + FunctionLib.gb23122Unicode(name) + "\r\n");
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
