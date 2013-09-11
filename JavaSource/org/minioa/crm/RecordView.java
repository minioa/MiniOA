package org.minioa.crm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

import jxl.Workbook;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.HibernateEntityLoader;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;

public class RecordView {
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
	private List<RecordView> items;

	public List<RecordView> getItems() {
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
	/**
	 * 定义构造函数
	 */
	public RecordView() {
	}

	public RecordView(int i) {
	}

	public RecordView(Map<String, String> data) {
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
			if (mySession == null)
				return null;
			dsList = new ArrayList<Integer>();

			String key6 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("RecordView.key6") != null)
					key6 = mySession.getTempStr().get("RecordView.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("RecordView.startDate") != null)
					startDate = mySession.getTempDate().get("RecordView.startDate");
				if (mySession.getTempDate().get("RecordView.endDate") != null)
					endDate = mySession.getTempDate().get("RecordView.endDate");
			}
			String sql = getSession().getNamedQuery("crm.record.records.count").getQueryString();
			String where = " where 1=1";
			if (!key6.equals(""))
				where += " and CID_ = :key6";
			if(startDate!=null && endDate!=null)
				where += " and CDATE_ between :startDate and :endDate";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and CID_ = :cId";
			Query query = getSession().createSQLQuery(sql + where);
			if (!key6.equals(""))
				query.setParameter("key6", key6);
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
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
			items = new ArrayList<RecordView>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new RecordView(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key6= "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("RecordView.key6") != null)
					key6 = mySession.getTempStr().get("RecordView.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("RecordView.startDate") != null)
					startDate = mySession.getTempDate().get("RecordView.startDate");
				if (mySession.getTempDate().get("RecordView.endDate") != null)
					endDate = mySession.getTempDate().get("RecordView.endDate");
			}
			String sql = getSession().getNamedQuery("crm.record.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.ID_ desc";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if(startDate!=null && endDate!=null)
				where += " and ta.CDATE_ between :startDate and :endDate";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = :cId";

			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			if (!key6.equals(""))
				query.setParameter("key6", key6);
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				query.setParameter("cId", getMySession().getUserId());

			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("ID_", FunctionLib.getString(obj[0]));
				p.put("cUser", FunctionLib.getString(obj[1]));
				p.put("CDATE_", FunctionLib.getDateString(obj[2]));
				p.put("mUser", FunctionLib.getString(obj[3]));
				p.put("MDATE_", FunctionLib.getDateString(obj[4]));
				p.put("UUID_", FunctionLib.getString(obj[5]));
				p.put("jiaoyisj", FunctionLib.getDateString(obj[6]));
				p.put("jieshusj", FunctionLib.getDateString(obj[7]));
				p.put("xiangmumc", FunctionLib.getString(obj[8]));
				p.put("peixundx", FunctionLib.getString(obj[9]));
				p.put("xueyuanrs", FunctionLib.getString(obj[10]));
				p.put("zengzhifw", FunctionLib.getString(obj[11]));
				p.put("kehufk", FunctionLib.getString(obj[12]));
				p.put("beizhu", FunctionLib.getString(obj[13]));
				p.put("isarc", FunctionLib.getString(obj[14]));
				p.put("jiaoyije", FunctionLib.getString(obj[15]));
				p.put("kehubm", FunctionLib.getString(obj[16]));
				p.put("gongsimc", FunctionLib.getString(obj[17]));
				p.put("kehuId", FunctionLib.getString(obj[18]));
				p.put("kehuUUID", FunctionLib.getString(obj[19]));
				items.add(new RecordView(p));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
