package org.minioa.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

import jxl.Workbook;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.*;

public class Log {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 * 
	 * 
	 * 表名 core_log，字段说明 ：tag，标签； refId，相关表的记录id，用于特殊表的日志记录；summary，操作摘要；details，
	 * 详细的操作sql；ip，操作者ip
	 */

	/**
	 * 获取名为Lang的javabean
	 */
	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		if (lang == null)
			FunctionLib.redirect(FunctionLib.getWebAppName());
		return lang;
	}

	/**
	 * 获取名为MySession的javabean，用于获取当前用户的会话数据
	 */
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

	/**
	 * 创建一个数据连接会话
	 */
	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	/**
	 * 初始化一条记录，用于初始化修改记录的页面
	 */
	private String init;

	public String getInit() {
		selectRecordById();
		return init;
	}

	/**
	 * 定义字段Map，字符类型
	 */
	private Map<String, String> prop;

	public void setProp(Map<String, String> data) {
		prop = data;
	}

	public Map<String, String> getProp() {
		if (prop == null)
			prop = new HashMap<String, String>();
		return prop;
	}

	/**
	 * 定义记录列表，用于充当数据表rich:dataTable的数据源
	 */
	private List<Log> items;

	public List<Log> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	/**
	 * 定义构造函数
	 */
	public Log() {
	}

	public Log(int i) {
	}

	public Log(Map<String, String> data) {
		setProp(data);
	}

	/**
	 * 分页列表，仅用于分页
	 */
	public List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			if(null == getMySession())
				return null;
			dsList = new ArrayList<Integer>();

			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Log.key") != null)
					key = mySession.getTempStr().get("Log.key").toString();
			}

			String sql = getSession().getNamedQuery("core.log.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and tag like :key";
			if (!getMySession().getHasOp().get("core.log.edit"))
				where += " and CID_ = :cId";
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!getMySession().getHasOp().get("core.log.edit"))
				query.setParameter("cId", getMySession().getUserId());

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

	/**
	 * 构造记录列表
	 */
	public void buildItems() {
		try {
			if(null == getMySession())
				return ;
			getDsList();
			items = new ArrayList<Log>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new Log(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Log.key") != null)
					key = mySession.getTempStr().get("Log.key").toString();
			}

			String sql = getSession().getNamedQuery("core.log.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.ID_ desc";

			if (!key.equals(""))
				where += " and ta.tag like :key";
			if (!getMySession().getHasOp().get("core.log.edit"))
				where += " and ta.CID_ = :cId";

			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!getMySession().getHasOp().get("core.log.edit"))
				query.setParameter("cId", getMySession().getUserId());

			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("cId", FunctionLib.getString(obj[1]));
				p.put("cDate", FunctionLib.getDateTimeString(obj[2]));
				p.put("tag", FunctionLib.getString(obj[3]));
				p.put("summary", FunctionLib.getString(obj[4]));
				p.put("details", FunctionLib.getString(obj[5]));
				p.put("ip", FunctionLib.getString(obj[6]));
				p.put("cUser", FunctionLib.getString(obj[7]));
				items.add(new Log(p));
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
			if (FunctionLib.isNum(id)) {
				Query query = getSession().getNamedQuery("core.log.getrecordbyid");
				query.setParameter("id", id);
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					prop = new HashMap<String, String>();
					prop.put("id", FunctionLib.getString(obj[0]));
					prop.put("cId", FunctionLib.getString(obj[1]));
					prop.put("cDate", FunctionLib.getDateTimeString(obj[2]));
					prop.put("tag", FunctionLib.getString(obj[3]));
					prop.put("refId", FunctionLib.getString(obj[4]));
					prop.put("summary", FunctionLib.getString(obj[5]));
					prop.put("details", FunctionLib.getString(obj[6]));
					prop.put("ip", FunctionLib.getString(obj[7]));
					prop.put("cUser", FunctionLib.getString(obj[8]));
				}
				it = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("Log.id");
			Query query = getSession().getNamedQuery("core.log.deleterecordbyid");
			query.setParameter("id", id);
			query.executeUpdate();
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);

			msg = getMySession().getDisplayName() + "删除除了一条日志记录";
			FunctionLib.writelog(getSession(), getMySession().getUserId(), getMySession().getIp(), "log", Integer.valueOf(id), msg, query.getQueryString());

			query = null;
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 批量删除efId大于零的日志
	 */
	public void deleteRecords() {
		try {
			Query query = getSession().getNamedQuery("core.log.deleterecords");
			query.executeUpdate();
			query = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);

			msg = getMySession().getDisplayName() + "清空了日志";
			FunctionLib.writelog(getSession(), getMySession().getUserId(), getMySession().getIp(), "log", 1, msg, "");
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 删除记录前确认对话框
	 */
	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Log.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 导出日志
	 */
	public void export() {
		try {
			String dir = FunctionLib.getBaseDir() + "temp" + FunctionLib.getSeparator() + "export" + FunctionLib.getSeparator() + getMySession().getUserId();
			if (FunctionLib.isDirExists(dir)) {
				dir = dir + FunctionLib.getSeparator() + "log.xls";
				File file = new File(dir);
				if (file.exists())
					file.delete();
				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(dir));
				jxl.write.WritableSheet ws = wwb.createSheet("data", 0);
				jxl.write.Label label;

				label = new jxl.write.Label(0, 0, "操作人");
				ws.addCell(label);
				label = new jxl.write.Label(1, 0, "操作ip");
				ws.addCell(label);
				label = new jxl.write.Label(2, 0, "操作时间");
				ws.addCell(label);
				label = new jxl.write.Label(3, 0, "标签");
				ws.addCell(label);
				label = new jxl.write.Label(4, 0, "摘要");
				ws.addCell(label);
				label = new jxl.write.Label(5, 0, "明细");
				ws.addCell(label);

				String key = "";
				if (mySession.getTempStr() != null) {
					if (mySession.getTempStr().get("Log.key") != null)
						key = mySession.getTempStr().get("Log.key").toString();
				}

				String sql = getSession().getNamedQuery("core.log.records").getQueryString();
				String where = " where 1=1";
				String other = " order by ta.ID_ desc";

				if (!key.equals(""))
					where += " and ta.tag like :key";
				if (!getMySession().getHasOp().get("core.log.edit"))
					where += " and ta.CID_ = :cId";

				Query query = getSession().createSQLQuery(sql + where + other);
				if (!key.equals(""))
					query.setParameter("key", "%" + key + "%");
				if (!getMySession().getHasOp().get("core.log.edit"))
					query.setParameter("cId", getMySession().getUserId());

				int i =0;
				Iterator<?> it = query.list().iterator();
				Map<String, String> p;
				while (it.hasNext()) {
					i++;
					Object obj[] = (Object[]) it.next();
					p = new HashMap<String, String>();
					p.put("id", FunctionLib.getString(obj[0]));
					p.put("cId", FunctionLib.getString(obj[1]));
					p.put("cDate", FunctionLib.getDateTimeString(obj[2]));
					p.put("tag", FunctionLib.getString(obj[3]));
					p.put("summary", FunctionLib.getString(obj[4]));
					p.put("details", FunctionLib.getString(obj[5]));
					p.put("ip", FunctionLib.getString(obj[6]));
					p.put("cUser", FunctionLib.getString(obj[7]));
					label = new jxl.write.Label(0, i, p.get("cUser"));
					ws.addCell(label);
					label = new jxl.write.Label(1, i, p.get("ip"));
					ws.addCell(label);
					label = new jxl.write.Label(2, i, p.get("cDate"));
					ws.addCell(label);
					label = new jxl.write.Label(3, i, p.get("tag"));
					ws.addCell(label);
					label = new jxl.write.Label(4, i, p.get("summary"));
					ws.addCell(label);
					label = new jxl.write.Label(5, i, p.get("details"));
					ws.addCell(label);
				}
				it = null;

				wwb.write();
				wwb.close();
				FunctionLib.download(dir, "日志" + FunctionLib.dtf2.format(new java.util.Date()) + ".xls", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
