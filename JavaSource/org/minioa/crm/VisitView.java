package org.minioa.crm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.ui.HibernateEntityLoader;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;

public class VisitView {
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
	
	private Map<String, java.util.Date> propDate;

	public void setPropDate(Map<String, java.util.Date> data) {
		propDate = data;
	}

	public Map<String, java.util.Date> getPropDate() {
		if (propDate == null)
			propDate = new HashMap<String, java.util.Date>();
		return propDate;
	}
	/**
	 * 定义记录列表，用于充当数据表rich:dataTable的数据源
	 */
	private List<VisitView> items;

	public List<VisitView> getItems() {
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
	public VisitView() {
	}

	public VisitView(int i) {
	}

	public VisitView(Map<String, String> data, Map<String, java.util.Date> date) {
		setProp(data);
		setPropDate(date);
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
			String gongsimc, kehubm, jiluren,xingdongjh;
			gongsimc = kehubm = jiluren = xingdongjh ="";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("VisitView.gongsimc") != null)
					gongsimc = mySession.getTempStr().get("VisitView.gongsimc").toString();
				if (mySession.getTempStr().get("VisitView.kehubm") != null)
					kehubm = mySession.getTempStr().get("VisitView.kehubm").toString();
				if (mySession.getTempStr().get("VisitView.jiluren") != null)
					jiluren = mySession.getTempStr().get("VisitView.jiluren").toString();
				if (mySession.getTempStr().get("VisitView.xingdongjh") != null)
					xingdongjh = mySession.getTempStr().get("VisitView.xingdongjh").toString();
				if (mySession.getTempStr().get("VisitView.key6") != null)
					key6 = mySession.getTempStr().get("VisitView.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			java.util.Date lxrq = null, lxrqend = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("VisitView.startDate") != null)
					startDate = mySession.getTempDate().get("VisitView.startDate");
				if (mySession.getTempDate().get("VisitView.endDate") != null)
					endDate = mySession.getTempDate().get("VisitView.endDate");
				if (mySession.getTempDate().get("VisitView.lxrq") != null)
					lxrq = mySession.getTempDate().get("VisitView.lxrq");
				if (mySession.getTempDate().get("VisitView.lxrqend") != null)
					lxrqend = mySession.getTempDate().get("VisitView.lxrqend");
			}
			String sql = getSession().getNamedQuery("crm.visit.records.count").getQueryString();
			String where = " where 1=1";
			if (!gongsimc.equals(""))
				where += " and tb.gongsimc like :gongsimc";
			if (!kehubm.equals(""))
				where += " and tb.kehubm like :kehubm";
			if (!jiluren.equals(""))
				where += " and ta.jiluren like :jiluren";
			if (!xingdongjh.equals(""))
				where += " and ta.xingdongjh like :xingdongjh";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if(startDate!=null && endDate!=null)
				where += " and ta.xingdongrq between :startDate and :endDate";
			if(lxrq!=null && lxrqend!=null)
				where += " and ta.lianxirq between :lxrq and :lxrqend";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = :cId";
			Query query = getSession().createSQLQuery(sql + where);
			if (!gongsimc.equals(""))
				where += " and tb.gongsimc like :gongsimc";
			if (!kehubm.equals(""))
				where += " and tb.kehubm like :kehubm";
			if (!jiluren.equals(""))
				where += " and ta.jiluren like :jiluren";
			if (!xingdongjh.equals(""))
				where += " and ta.xingdongjh like :xingdongjh";
			
			if (!key6.equals(""))
				query.setParameter("key6", key6);
			if (!gongsimc.equals(""))
				query.setParameter("gongsimc", "%" + gongsimc + "%");
			if (!jiluren.equals(""))
				query.setParameter("jiluren", "%" + jiluren + "%");
			if (!xingdongjh.equals(""))
				query.setParameter("xingdongjh", "%" + xingdongjh + "%");
			if (!kehubm.equals(""))
				query.setParameter("kehubm", "%" + kehubm + "%");
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			if(lxrq!=null && lxrqend!=null){
				query.setParameter("lxrq", lxrq);
				query.setParameter("lxrqend", lxrqend);
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
				return;
			getDsList();
			items = new ArrayList<VisitView>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new VisitView(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key6= "";
			String gongsimc, kehubm, jiluren,xingdongjh;
			gongsimc = kehubm = jiluren = xingdongjh ="";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("VisitView.gongsimc") != null)
					gongsimc = mySession.getTempStr().get("VisitView.gongsimc").toString();
				if (mySession.getTempStr().get("VisitView.kehubm") != null)
					kehubm = mySession.getTempStr().get("VisitView.kehubm").toString();
				if (mySession.getTempStr().get("VisitView.jiluren") != null)
					jiluren = mySession.getTempStr().get("VisitView.jiluren").toString();
				if (mySession.getTempStr().get("VisitView.xingdongjh") != null)
					xingdongjh = mySession.getTempStr().get("VisitView.xingdongjh").toString();
				if (mySession.getTempStr().get("VisitView.key6") != null)
					key6 = mySession.getTempStr().get("VisitView.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			java.util.Date lxrq = null, lxrqend = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("VisitView.startDate") != null)
					startDate = mySession.getTempDate().get("VisitView.startDate");
				if (mySession.getTempDate().get("VisitView.endDate") != null)
					endDate = mySession.getTempDate().get("VisitView.endDate");
				if (mySession.getTempDate().get("VisitView.lxrq") != null)
					lxrq = mySession.getTempDate().get("VisitView.lxrq");
				if (mySession.getTempDate().get("VisitView.lxrqend") != null)
					lxrqend = mySession.getTempDate().get("VisitView.lxrqend");
			}
			String sql = getSession().getNamedQuery("crm.visit.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.ID_ desc";
			if (!gongsimc.equals(""))
				where += " and tb.gongsimc like :gongsimc";
			if (!kehubm.equals(""))
				where += " and tb.kehubm like :kehubm";
			if (!jiluren.equals(""))
				where += " and ta.jiluren like :jiluren";
			if (!xingdongjh.equals(""))
				where += " and ta.xingdongjh like :xingdongjh";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if(startDate!=null && endDate!=null)
				where += " and ta.xingdongrq between :startDate and :endDate";
			if(lxrq!=null && lxrqend!=null)
				where += " and ta.lianxirq between :lxrq and :lxrqend";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = :cId";

			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			if (!gongsimc.equals(""))
				where += " and tb.gongsimc like :gongsimc";
			if (!kehubm.equals(""))
				where += " and tb.kehubm like :kehubm";
			if (!jiluren.equals(""))
				where += " and ta.jiluren like :jiluren";
			if (!xingdongjh.equals(""))
				where += " and ta.xingdongjh like :xingdongjh";
			if (!gongsimc.equals(""))
				query.setParameter("gongsimc", "%" + gongsimc + "%");
			if (!jiluren.equals(""))
				query.setParameter("jiluren", "%" + jiluren + "%");
			if (!xingdongjh.equals(""))
				query.setParameter("xingdongjh", "%" + xingdongjh + "%");
			if (!kehubm.equals(""))
				query.setParameter("kehubm", "%" + kehubm + "%");
			if (!key6.equals(""))
				query.setParameter("key6", key6);
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			if(lxrq!=null && lxrqend!=null){
				query.setParameter("lxrq", lxrq);
				query.setParameter("lxrqend", lxrqend);
			}
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				query.setParameter("cId", getMySession().getUserId());
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			Map<String, java.util.Date> pDate;
			String now = FunctionLib.df.format(new java.util.Date());
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				pDate = new HashMap<String, java.util.Date>();
				p.put("ID_", FunctionLib.getString(obj[0]));
				p.put("cUser", FunctionLib.getString(obj[1]));
				p.put("CDATE_", FunctionLib.getDateString(obj[2]));
				p.put("mUser", FunctionLib.getString(obj[3]));
				p.put("MDATE_", FunctionLib.getDateString(obj[4]));
				p.put("UUID_", FunctionLib.getString(obj[5]));
				pDate.put("lianxirq", FunctionLib.getDate(obj[6]));
				p.put("jiluren", FunctionLib.getString(obj[7]));
				p.put("lianxinr", FunctionLib.getString(obj[8]));
				p.put("xingdongjh", FunctionLib.getString(obj[9]));
				p.put("xingdongrq", FunctionLib.getDateString(obj[10]));
				p.put("zhuguanpf", FunctionLib.getString(obj[11]));
				p.put("isarc", FunctionLib.getString(obj[12]));
				p.put("kehubm", FunctionLib.getString(obj[13]));
				p.put("gongsimc", FunctionLib.getString(obj[14]));
				p.put("kehuId", FunctionLib.getString(obj[15]));
				p.put("kehuUUID", FunctionLib.getString(obj[16]));
				pDate.put("now", FunctionLib.df.parse(now));
				items.add(new VisitView(p, pDate));
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
