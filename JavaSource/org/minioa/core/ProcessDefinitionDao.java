package org.minioa.core;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;

import org.minioa.core.ProcessDefinition;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class ProcessDefinitionDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-22
	 */
	private final String regex = "create|drop|delete|alert|core_prop|core_user|core_role|core_role_user_relation|core_op_role_relation|ofproperty|ofuser";

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

	public ProcessDefinitionDao() {
	}

	public List<Integer> buildDsList() {
		if(null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("ProcessDefinition.key") != null)
					key = mySession.getTempStr().get("ProcessDefinition.key").toString();
			}

			String sql = getSession().getNamedQuery("core.processdefinition.items.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and processName like :key";
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");

			int tc = Integer.valueOf(String.valueOf(query.list().get(0)));
			for (int i = 0; i < tc; i++)
				dsList.add(i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<ProcessDefinition> buildItems() {
		ArrayList<ProcessDefinition> items = new ArrayList<ProcessDefinition>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new ProcessDefinition());
				return items;
			}
			// 设置第一页
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "", key2 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("ProcessDefinition.key") != null)
					key = mySession.getTempStr().get("ProcessDefinition.key").toString();
			}
			items = new ArrayList<ProcessDefinition>();
			Criteria criteria = getSession().createCriteria(ProcessDefinition.class);
			if (!key.equals(""))
				criteria.add(Restrictions.like("processName", key, MatchMode.ANYWHERE));
			criteria.addOrder(Order.desc("processName"));
			criteria.setMaxResults(mySession.getPageSize());
			criteria.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				ProcessDefinition bean = (ProcessDefinition) it.next();
				if (bean.getProcessImage() != null)
					bean.setProcessImage(bean.getProcessImage().replaceAll("\\\\", "/"));
				if (bean.getProcessImageThum() != null)
					bean.setProcessImageThum(bean.getProcessImageThum().replaceAll("\\\\", "/"));
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ProcessDefinition selectRecordById() {
		ProcessDefinition bean = new ProcessDefinition();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("processDefinitionId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public ProcessDefinition selectRecordById(Integer id) {
		ProcessDefinition bean = new ProcessDefinition();
		try {
			Criteria criteria = getSession().createCriteria(ProcessDefinition.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				bean = (ProcessDefinition) it.next();
				if (bean.getProcessImage() != null)
					bean.setProcessImage(bean.getProcessImage().replaceAll("\\\\", "/"));
				if (bean.getProcessImageThum() != null)
					bean.setProcessImageThum(bean.getProcessImageThum().replaceAll("\\\\", "/"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(ProcessDefinition bean) {
		try {
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			// 防止通过sql获取或修改数据库关键表数据
			bean.setSqlWhenCreate(bean.getSqlWhenCreate().toLowerCase().replaceAll(regex, ""));
			bean.setSqlWhenAgree(bean.getSqlWhenAgree().toLowerCase().replaceAll(regex, ""));
			bean.setSqlWhenDelete(bean.getSqlWhenDelete().toLowerCase().replaceAll(regex, ""));
			bean.setSqlWhenReject(bean.getSqlWhenReject().toLowerCase().replaceAll(regex, ""));
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

	public void updateRecordById(ProcessDefinition bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				// 防止通过sql获取或修改数据库关键表数据
				bean.setSqlWhenCreate(bean.getSqlWhenCreate().toLowerCase().replaceAll(regex, ""));
				bean.setSqlWhenAgree(bean.getSqlWhenAgree().toLowerCase().replaceAll(regex, ""));
				bean.setSqlWhenDelete(bean.getSqlWhenDelete().toLowerCase().replaceAll(regex, ""));
				bean.setSqlWhenReject(bean.getSqlWhenReject().toLowerCase().replaceAll(regex, ""));
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("ProcessDefinition.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(ProcessDefinition.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((ProcessDefinition) it.next());
			}
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
			getMySession().getTempStr().put("ProcessDefinition.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public List<SelectItem> si;

	public List<SelectItem> getSi() {
		if (si == null)
			buildSi();
		return si;
	}

	public void buildSi() {
		si = new ArrayList<SelectItem>();
		try {
			Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.processdefinition.si");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				si.add(new SelectItem(FunctionLib.getString(obj[0]), FunctionLib.getString(obj[1])));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void uploadListener(UploadEvent event) {
		String storedir = "upload" + FunctionLib.getSeparator() + "processImages" + FunctionLib.getSeparator();
		if (FunctionLib.isDirExists(FunctionLib.getBaseDir() + storedir)) {
			try {
				File file;
				ProcessDefinition processDef = selectRecordById();
				if (processDef.getProcessImage() != null) {
					processDef.setProcessImage(processDef.getProcessImage().replaceAll("/", "\\\\"));
					file = new File(FunctionLib.getBaseDir() + processDef.getProcessImage());
					if (file.exists())
						file.delete();
				}
				if (processDef.getProcessImageThum() != null) {
					processDef.setProcessImageThum(processDef.getProcessImageThum().replaceAll("/", "\\\\"));
					file = new File(FunctionLib.getBaseDir() + processDef.getProcessImageThum());
					if (file.exists())
						file.delete();
				}

				List<UploadItem> itemList = event.getUploadItems();
				for (int i = 0; i < itemList.size(); i++) {
					UploadItem item = (UploadItem) itemList.get(i);
					String uuid = java.util.UUID.randomUUID().toString();
					String newFileName = uuid + FunctionLib.getFileType(item.getFileName());
					String thumFileName = uuid + "_thum" + FunctionLib.getFileType(item.getFileName());

					file = new File(FunctionLib.getBaseDir() + storedir + newFileName);
					FileOutputStream out = new FileOutputStream(file);
					out.write(item.getData());
					out.close();
					processDef.setProcessImage(storedir + newFileName);
					processDef.setProcessImageThum(storedir + thumFileName);
					getSession().save(processDef);
					// 创建缩略图
					FunctionLib.thumbnail(FunctionLib.getBaseDir() + storedir + newFileName, FunctionLib.getBaseDir() + storedir + thumFileName, 100, 60);
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

	/**
	 * 检查sql语句是否正确，多个sql用;隔开
	 * 
	 * @param sqlStr
	 * @return
	 */
	public boolean checkSql(String sqlStr) {
		boolean check = true;
		try {
			if (null == sqlStr || "".equals(sqlStr))
				return true;
			Query query;
			if (sqlStr != null && !sqlStr.equals("")) {
				String[] sql = sqlStr.split(";");
				for (int i = 0; i < sql.length; i++) {
					if (sql[i] != null && !sql[i].equals("")) {
						query = getSession().createSQLQuery(sql[i].replaceAll(regex, ""));
						if (sqlStr.indexOf(":processid") > -1)
							query.setParameter("processid", 0);
						if (sqlStr.indexOf(":instanceid") > -1)
							query.setParameter("instanceid", 0);
						if (sql[i].startsWith("select"))
							query.list();
						else
							query.executeUpdate();
					}
				}
			}
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}
		return check;
	}
	
	public void setTempFormViewId(ProcessDefinition bean) {
		try {
			getMySession().getTempInt().put("formViewId",bean.getFormId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
