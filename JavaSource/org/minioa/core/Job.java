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

public class Job {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 * orgId单位id,parentId上级部门id,jobName 岗位名称 jobDesc 岗位描述
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
	private String orgName, parentName, jobName, jobDesc;
	private boolean isManager;

	public void setIsManager(boolean data) {
		isManager = data;
	}

	public boolean getIsManager() {
		return isManager;
	}

	public void setJobName(String data) {
		jobName = data;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobDesc(String data) {
		jobDesc = data;
	}

	public String getJobDesc() {
		return jobDesc;
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

	private List<Job> items;

	public List<Job> getItems() {
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

	public Job() {
	}

	public Job(int i) {
		setID_(i);
	}

	public Job(String type, int i, String name) {
		setType(type);
		setID_(i);
		setJobName(name);
	}

	public Job(int org, int parent, int id, String oName, String pName, String name, String desc) {
		setOrgId(org);
		setParentId(parent);
		setID_(id);
		setOrgName(oName);
		setParentName(pName);
		setJobName(name);
		setJobDesc(desc);
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
	public Job(int id, int cId, String cDate, int mId, String mDate, String uuid, int org, int parent, String name, String desc, int seq, boolean manager) {
		setID_(id);
		setCID_(cId);
		setCDATE(cDate);
		setMID_(mId);
		setMDATE(mDate);
		setUUID_(uuid);
		setOrgId(org);
		setParentId(parent);
		setJobName(name);
		setJobDesc(desc);
		setSequence(seq);
		setIsManager(manager);
	}

	/**
	 * 初始化变量
	 */
	public void reset() {
		ID_ = CID_ = MID_ = 0;
		CDATE = MDATE = UUID_ = "";
		CDATE_ = MDATE_ = null;
		orgId = parentId = 0;
		orgName = parentName = jobName = jobDesc = "";
		isManager = false;
	}

	/**
	 * 将全部记录加入列表
	 */
	public void buildItems() {
		try {
			getMySession();
			items = new ArrayList<Job>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				if (null != mySession.getTempInt() && mySession.getTempInt().containsKey("Job.rowcount")) {
					for (int i = 0; i < mySession.getTempInt().get("Job.rowcount"); i++)
						items.add(new Job(i));
					return;
				}
			}

			Query query = getSession().getNamedQuery("core.job.records");
			Iterator<?> it = query.list().iterator();
			int id, cId, mId;
			String cDate, mDate, uuid;
			java.util.Date cDate_, mDate_;
			int org, parent, seq;
			String name, desc;
			boolean manager;
			int rowcount = 0;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = cId = mId = 0;
				cDate = mDate = uuid = "";
				cDate_ = mDate_ = null;
				org = parent = seq = 0;
				name = desc = "";
				manager = false;
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
				if (obj[11] != null)
					manager = FunctionLib.getBoolean(obj[11]);
				items.add(new Job(id, cId, cDate, mId, mDate, uuid, org, parent, name, desc, seq, manager));
				rowcount++;
			}
			it = null;

			mySession.getTempInt().put("Job.rowcount", rowcount);
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
			Query query = getSession().getNamedQuery("core.job.getrecordbyid");
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
					jobName = String.valueOf(obj[8]);
				if (obj[9] != null)
					jobDesc = String.valueOf(obj[9]);
				if (obj[10] != null)
					sequence = Integer.valueOf(String.valueOf(obj[10]));
				if (obj[11] != null)
					isManager = FunctionLib.getBoolean(obj[11]);
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
			if ("".equals(jobName)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("name") + getLang().getProp().get(getMySession().getL()).get("cannotbenull");
				getMySession().setMsg(msg, 2);
				return;
			}
			Job bean = new Job();
			bean.setOrgId(Integer.valueOf(orgId));
			bean.setParentId(Integer.valueOf(parentId));
			bean.setJobName(jobName);
			bean.setJobDesc(jobDesc);
			bean.setSequence(sequence);
			bean.setIsManager(isManager);
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
			if ("".equals(jobName)) {
				String msg = getLang().getProp().get(getMySession().getL()).get("name") + getLang().getProp().get(getMySession().getL()).get("cannotbenull");
				getMySession().setMsg(msg, 2);
				return;
			}
			Query query = getSession().getNamedQuery("core.job.updaterecordbyid");
			query.setParameter("mId", 0);
			query.setParameter("jobName", jobName);
			query.setParameter("jobDesc", jobDesc);
			query.setParameter("sequence", sequence);
			query.setParameter("isManager", isManager);
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

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (!FunctionLib.isNum(id))
				return;
			Query query = getSession().getNamedQuery("core.job.deleterecordbyid");
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
			getMySession().getTempStr().put("Job.move.id", id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Job.id", (String) params.get("id"));
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
	@SuppressWarnings("unchecked")
	public void addNodes(TreeNode<Job> node, int orgId, int parentId, String oName, String pName) {
		try {
			Query query = getSession().getNamedQuery("core.job.getchildren");
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
				@SuppressWarnings("rawtypes")
				TreeNodeImpl nodeImpl = new TreeNodeImpl();
				nodeImpl.setData(new Job(orgId, id, id, oName, pName, name, desc));
				node.addChild(key, nodeImpl);
				key++;
				if (hasChild(orgId, id))
					addNodes(nodeImpl, orgId, id, oName, name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadTree() {
		try {
			rootNode = new TreeNodeImpl();

			Query query = getSession().getNamedQuery("core.org.records");
			Iterator it = query.list().iterator();
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
				TreeNodeImpl nodeImpl = new TreeNodeImpl();
				nodeImpl.setData(new Job(id, 0, 0, name, name, name, desc));
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
			Query query = getSession().getNamedQuery("core.job.haschildren");
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
			Job bean = (Job) tree.getRowData();
			ID_ = bean.getID_();
			selectRecordById(String.valueOf(ID_));
			orgId = bean.getOrgId();
			parentId = bean.getParentId();
			orgName = bean.getOrgName();
			parentName = bean.getParentName();
			if (FunctionLib.isNum(getMySession().getTempStr().get("Job.move.id"))) {
				Query query = getSession().getNamedQuery("core.job.moverecordbyid");
				query.setParameter("mId", 0);
				query.setParameter("orgId", orgId);
				query.setParameter("parentId", ID_);
				query.setParameter("id", getMySession().getTempStr().get("Job.move.id"));
				query.executeUpdate();
				query = null;
				getMySession().getTempStr().put("Job.move.id", "");
				FunctionLib.refresh();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void buildTreeFile() {
		try {
			bf = new StringBuffer();
			rootNode = new TreeNodeImpl<Job>();

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
				addChildren(String.valueOf(i), id, 0, name, name);
				i++;
			}
			it = null;

			String filename = FunctionLib.getBaseDir() + "job.properties";
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

	public void addChildren(String parentKey, int orgId, int parentId, String oName, String pName) {
		try {
			level++;
			Query query = getSession().getNamedQuery("core.job.getchildren");
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
				bf.append(parentKey + "." + i + "=job," + id + "," + FunctionLib.gb23122Unicode(name) + "\r\n");

				if (hasChild(orgId, id))
					addChildren(parentKey + "." + i, orgId, id, oName, name);
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
