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

public class ContactView {
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
	private List<ContactView> items;

	public List<ContactView> getItems() {
		if (items == null)
			buildItems();
		return items;
	}
	
	private List<ContactView> items2;

	public List<ContactView> getItems2() {
		if (items2 == null)
			buildItems2();
		return items2;
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
	public ContactView() {
	}

	public ContactView(int i) {
	}

	public ContactView(Map<String, String> data) {
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

			String key, key2, key3, key6, gongsimc, kehubm, zhiwei, lianxidj;
			key = key2 = key3 = key6 = gongsimc = kehubm = zhiwei = lianxidj ="";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("ContactView.gongsimc") != null)
					gongsimc = mySession.getTempStr().get("ContactView.gongsimc").toString();
				if (mySession.getTempStr().get("ContactView.kehubm") != null)
					kehubm = mySession.getTempStr().get("ContactView.kehubm").toString();
				if (mySession.getTempStr().get("ContactView.zhiwei") != null)
					zhiwei = mySession.getTempStr().get("ContactView.zhiwei").toString();
				if (mySession.getTempStr().get("ContactView.lianxidj") != null)
					lianxidj = mySession.getTempStr().get("ContactView.lianxidj").toString();
				if (mySession.getTempStr().get("ContactView.key") != null)
					key = mySession.getTempStr().get("ContactView.key").toString();
				if (mySession.getTempStr().get("ContactView.key2") != null)
					key2 = mySession.getTempStr().get("ContactView.key2").toString();
				if (mySession.getTempStr().get("ContactView.key3") != null)
					key3 = mySession.getTempStr().get("ContactView.key3").toString();
				if (mySession.getTempStr().get("ContactView.key6") != null)
					key6 = mySession.getTempStr().get("ContactView.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("ContactView.startDate") != null)
					startDate = mySession.getTempDate().get("ContactView.startDate");
				if (mySession.getTempDate().get("ContactView.endDate") != null)
					endDate = mySession.getTempDate().get("ContactView.endDate");
			}
			String sql = getSession().getNamedQuery("crm.contact.records.count").getQueryString();
			String where = " where 1=1";
			if (!gongsimc.equals(""))
				where += " and tb.gongsimc like :gongsimc";
			if (!kehubm.equals(""))
				where += " and tb.kehubm like :kehubm";
			if (!lianxidj.equals(""))
				where += " and ta.lianxidj like :lianxidj";
			if (!zhiwei.equals(""))
				where += " and ta.zhiwei like :zhiwei";
			if (!key.equals(""))
				where += " and (ta.xingming like :key or ta.nickname like :key)";
			if (!key2.equals(""))
				where += " and (ta.yidongdh like :key2 or ta.gudingdh like :key2 or ta.chuanzhen like :key2 or ta.zhaidian like :key2)";
			if (!key3.equals(""))
				where += " and ta.youjian like :key3";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if(startDate!=null && endDate!=null)
				where += " and ta.CDATE_ between :startDate and :endDate";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = :cId";
			Query query = getSession().createSQLQuery(sql + where);
			if (!gongsimc.equals(""))
				query.setParameter("gongsimc", "%" + gongsimc + "%");
			if (!kehubm.equals(""))
				query.setParameter("kehubm", "%" + kehubm + "%");
			if (!zhiwei.equals(""))
				query.setParameter("zhiwei", "%" + zhiwei + "%");
			if (!lianxidj.equals(""))
				query.setParameter("lianxidj", "%" + lianxidj + "%");
			if (!kehubm.equals(""))
				query.setParameter("kehubm", "%" + kehubm + "%");
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");
			if (!key3.equals(""))
				query.setParameter("key3", "%" + key3 + "%");
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
				return;
			getDsList();
			items = new ArrayList<ContactView>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("false".equals((String) params.get("reload"))) {
				int size = 0;
				while (size < mySession.getPageSize()) {
					items.add(new ContactView(size));
					size++;
				}
				return;
			}
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key, key2, key3, key6, gongsimc, kehubm, zhiwei, lianxidj;
			key = key2 = key3 = key6 = gongsimc = kehubm = zhiwei = lianxidj ="";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("ContactView.gongsimc") != null)
					gongsimc = mySession.getTempStr().get("ContactView.gongsimc").toString();
				if (mySession.getTempStr().get("ContactView.kehubm") != null)
					kehubm = mySession.getTempStr().get("ContactView.kehubm").toString();
				if (mySession.getTempStr().get("ContactView.zhiwei") != null)
					zhiwei = mySession.getTempStr().get("ContactView.zhiwei").toString();
				if (mySession.getTempStr().get("ContactView.lianxidj") != null)
					lianxidj = mySession.getTempStr().get("ContactView.lianxidj").toString();
				if (mySession.getTempStr().get("ContactView.key") != null)
					key = mySession.getTempStr().get("ContactView.key").toString();
				if (mySession.getTempStr().get("ContactView.key2") != null)
					key2 = mySession.getTempStr().get("ContactView.key2").toString();
				if (mySession.getTempStr().get("ContactView.key3") != null)
					key3 = mySession.getTempStr().get("ContactView.key3").toString();
				if (mySession.getTempStr().get("ContactView.key6") != null)
					key6 = mySession.getTempStr().get("ContactView.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("ContactView.startDate") != null)
					startDate = mySession.getTempDate().get("ContactView.startDate");
				if (mySession.getTempDate().get("ContactView.endDate") != null)
					endDate = mySession.getTempDate().get("ContactView.endDate");
			}
			String sql = getSession().getNamedQuery("crm.contact.records").getQueryString();
			String where = " where 1=1";
			String other = " order by ta.ID_ desc";
			if (!gongsimc.equals(""))
				where += " and tb.gongsimc like :gongsimc";
			if (!kehubm.equals(""))
				where += " and tb.kehubm like :kehubm";
			if (!lianxidj.equals(""))
				where += " and ta.lianxidj like :lianxidj";
			if (!zhiwei.equals(""))
				where += " and ta.zhiwei like :zhiwei";
			if (!key.equals(""))
				where += " and (ta.xingming like :key or ta.nickname like :key)";
			if (!key2.equals(""))
				where += " and (ta.yidongdh like :key2 or ta.gudingdh like :key2 or ta.chuanzhen like :key2 or ta.zhaidian like :key2)";
			if (!key3.equals(""))
				where += " and ta.youjian like :key3";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if(startDate!=null && endDate!=null)
				where += " and ta.CDATE_ between :startDate and :endDate";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = :cId";

			Query query = getSession().createSQLQuery(sql + where + other);
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			if (!gongsimc.equals(""))
				query.setParameter("gongsimc", "%" + gongsimc + "%");
			if (!kehubm.equals(""))
				query.setParameter("kehubm", "%" + kehubm + "%");
			if (!zhiwei.equals(""))
				query.setParameter("zhiwei", "%" + zhiwei + "%");
			if (!lianxidj.equals(""))
				query.setParameter("lianxidj", "%" + lianxidj + "%");
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");
			if (!key3.equals(""))
				query.setParameter("key3", "%" + key3 + "%");
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
				p.put("kehubm", FunctionLib.getString(obj[0]));
				p.put("gongsimc", FunctionLib.getString(obj[1]));
				p.put("xingming", FunctionLib.getString(obj[2]));
				p.put("birthday", FunctionLib.getDateString(obj[3]));
				p.put("chenghu", FunctionLib.getString(obj[4]));
				p.put("zhiwei", FunctionLib.getString(obj[5]));
				p.put("zhize", FunctionLib.getString(obj[6]));
				p.put("bumen", FunctionLib.getString(obj[7]));
				p.put("gudingdh", FunctionLib.getString(obj[8]));
				p.put("yidongdh", FunctionLib.getString(obj[9]));
				p.put("xingqu", FunctionLib.getString(obj[10]));
				p.put("qq", FunctionLib.getString(obj[11]));
				p.put("msn", FunctionLib.getString(obj[12]));
				p.put("youjian", FunctionLib.getString(obj[13]));
				p.put("nickname", FunctionLib.getString(obj[14]));
				p.put("lianxidj", FunctionLib.getString(obj[15]));
				p.put("beizhu", FunctionLib.getString(obj[16]));
				p.put("zhaidian", FunctionLib.getString(obj[17]));
				p.put("chuanzhen", FunctionLib.getString(obj[18]));
				p.put("jiguan", FunctionLib.getString(obj[19]));
				p.put("hunfou", FunctionLib.getString(obj[20]));
				p.put("biyeyx", FunctionLib.getString(obj[21]));
				p.put("juesezy", FunctionLib.getString(obj[22]));
				p.put("id", FunctionLib.getString(obj[23]));
				p.put("cUser", FunctionLib.getString(obj[24]));
				p.put("CDATE_", FunctionLib.getDateString(obj[25]));
				p.put("mUser", FunctionLib.getString(obj[26]));
				p.put("MDATE_", FunctionLib.getDateString(obj[27]));
				items.add(new ContactView(p));
				checkIdsMap.put(FunctionLib.getInt(obj[23]), false);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void buildItems2() {
		try {

			getDsList();
			items2 = new ArrayList<ContactView>();
			String key, key2, key3, key4;
			key = key2 = key3 = key4 ="";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("ContactView.key") != null)
					key = mySession.getTempStr().get("ContactView.key").toString();
				if (mySession.getTempStr().get("ContactView.key2") != null)
					key2 = mySession.getTempStr().get("ContactView.key2").toString();
				if (mySession.getTempStr().get("ContactView.key3") != null)
					key3 = mySession.getTempStr().get("ContactView.key3").toString();
				if (mySession.getTempStr().get("ContactView.key4") != null)
					key4 = mySession.getTempStr().get("ContactView.key4").toString();
			}
			String sql = getSession().getNamedQuery("crm.contact.records.mail").getQueryString();
			String where = " where ta.youjian !=''";
			String other = " order by ta.ID_ desc";

			if (!key.equals(""))
				where += " and (ta.xingming like :key or ta.nickname like :key)";
			if (!key2.equals(""))
				where += " and (ta.yidongdh like :key2 or ta.gudingdh like :key2 or ta.chuanzhen like :key2 or ta.zhaidian like :key2)";
			if (!key3.equals(""))
				where += " and ta.youjian like :key3";
			if (!key4.equals(""))
				where += " and tb.hangye = :key4";
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = :cId";

			Query query = getSession().createSQLQuery(sql + where + other);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");
			if (!key3.equals(""))
				query.setParameter("key3", "%" + key3 + "%");
			if (!key4.equals(""))
				query.setParameter("key4", key4);
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				query.setParameter("cId", getMySession().getUserId());

			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("gongsimc", FunctionLib.getString(obj[0]));
				p.put("xingming", FunctionLib.getString(obj[1]));
				p.put("id", FunctionLib.getString(obj[2]));
				p.put("youjian", FunctionLib.getString(obj[3]));
				items2.add(new ContactView(p));
				checkIdsMap.put(FunctionLib.getInt(obj[2]), false);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void sendEmail() {
		try {
			String ids = "";
			for(Map.Entry<Integer, Boolean> entry : this.checkIdsMap.entrySet()){
				if(entry.getValue())
			    	  ids = ids + entry.getKey() + ",";
			}
			getMySession().getTempStr().put("crm.mail.ids", ids);
			FunctionLib.redirect("default", "crm/newmail.jsf");
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
	
	public void download()
	{
		try
	    {
			getMySession();
			String storedir  = FunctionLib.getBaseDir() + "temp" + FunctionLib.getSeparator()+ "download" + FunctionLib.getSeparator();
			if(FunctionLib.isDirExists(storedir)){
				File file = new File(storedir+  mySession.getUserId() + ".xls");
				if(file.exists())
					file.delete();
				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(file);
				jxl.write.WritableSheet ws = wwb.createSheet("data", 0);
				jxl.write.Label label;
				label = new jxl.write.Label(0,0, "客户编码");
				ws.addCell(label);
				label = new jxl.write.Label(1,0, "客户名称");
				ws.addCell(label);
				label = new jxl.write.Label(2,0, "姓名");
				ws.addCell(label);
				label = new jxl.write.Label(3,0, "生日");
				ws.addCell(label);
				label = new jxl.write.Label(4,0, "性别");
				ws.addCell(label);
				label = new jxl.write.Label(5,0, "职位");
				ws.addCell(label);
				label = new jxl.write.Label(6,0, "职责");
				ws.addCell(label);
				label = new jxl.write.Label(7,0, "部门");
				ws.addCell(label);
				label = new jxl.write.Label(8,0, "办公电话");
				ws.addCell(label);
				label = new jxl.write.Label(9,0, "手机");
				ws.addCell(label);
				label = new jxl.write.Label(10,0, "兴趣");
				ws.addCell(label);
				label = new jxl.write.Label(11,0, "QQ");
				ws.addCell(label);
				label = new jxl.write.Label(12,0, "MSN");
				ws.addCell(label);
				label = new jxl.write.Label(13,0, "邮箱");
				ws.addCell(label);
				label = new jxl.write.Label(14,0, "昵称");
				ws.addCell(label);	
				label = new jxl.write.Label(15,0, "联系等级");
				ws.addCell(label);	
				label = new jxl.write.Label(16,0, "备注");
				ws.addCell(label);	
				label = new jxl.write.Label(17,0, "宅电");
				ws.addCell(label);	
				label = new jxl.write.Label(18,0, "传真");
				ws.addCell(label);
				label = new jxl.write.Label(19,0, "籍贯");
				ws.addCell(label);
				label = new jxl.write.Label(20,0, "婚否");
				ws.addCell(label);
				label = new jxl.write.Label(21,0, "毕业院校");
				ws.addCell(label);
				label = new jxl.write.Label(22,0, "角色作用");
				ws.addCell(label);	
				String key ="",  key2 = "",  key3 ="";
				if (mySession.getTempStr() != null) {
					if (mySession.getTempStr().get("ContactView.key") != null)
						key = mySession.getTempStr().get("ContactView.key").toString();
					if (mySession.getTempStr().get("ContactView.key2") != null)
						key2 = mySession.getTempStr().get("ContactView.key2").toString();
					if (mySession.getTempStr().get("ContactView.key3") != null)
						key3 = mySession.getTempStr().get("ContactView.key3").toString();
				}
				String sql = getSession().getNamedQuery("crm.contact.records").getQueryString();
				String where = " where 1=1";
				String other = " order by ta.ID_ desc";

				if (!key.equals(""))
					where += " and (ta.xingming like :key or ta.nickname like :key)";
				if (!key2.equals(""))
					where += " and (ta.yidongdh like :key2 or ta.gudingdh like :key2 or ta.chuanzhen like :key2 or ta.zhaidian like :key2)";
				if (!key3.equals(""))
					where += " and ta.youjian like :key3";
				if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
					where += " and ta.CID_ = :cId";

				Query query = getSession().createSQLQuery(sql + where + other);
				query.setMaxResults(mySession.getPageSize());
				query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
				
				if (!key.equals(""))
					query.setParameter("key", "%" + key + "%");
				if (!key2.equals(""))
					query.setParameter("key2", "%" + key2 + "%");
				if (!key3.equals(""))
					query.setParameter("key3", "%" + key3 + "%");
				if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
					query.setParameter("cId", getMySession().getUserId());

				Iterator<?> it = query.list().iterator();
				Map<String, String> p;
				int i = 0;
				while (it.hasNext()) {
					i++;
					Object obj[] = (Object[]) it.next();
					p = new HashMap<String, String>();
					p.put("kehubm", FunctionLib.getString(obj[0]));
					p.put("gongsimc", FunctionLib.getString(obj[1]));
					p.put("xingming", FunctionLib.getString(obj[2]));
					p.put("birthday", FunctionLib.getDateString(obj[3]));
					p.put("chenghu", FunctionLib.getString(obj[4]));
					p.put("zhiwei", FunctionLib.getString(obj[5]));
					p.put("zhize", FunctionLib.getString(obj[6]));
					p.put("bumen", FunctionLib.getString(obj[7]));
					p.put("gudingdh", FunctionLib.getString(obj[8]));
					p.put("yidongdh", FunctionLib.getString(obj[9]));
					p.put("xingqu", FunctionLib.getString(obj[10]));
					p.put("qq", FunctionLib.getString(obj[11]));
					p.put("msn", FunctionLib.getString(obj[12]));
					p.put("youjian", FunctionLib.getString(obj[13]));
					p.put("nickname", FunctionLib.getString(obj[14]));
					p.put("lianxidj", FunctionLib.getString(obj[15]));
					p.put("beizhu", FunctionLib.getString(obj[16]));
					p.put("zhaidian", FunctionLib.getString(obj[17]));
					p.put("chuanzhen", FunctionLib.getString(obj[18]));
					p.put("jiguan", FunctionLib.getString(obj[19]));
					p.put("hunfou", FunctionLib.getString(obj[20]));
					p.put("biyeyx", FunctionLib.getString(obj[21]));
					p.put("juesezy", FunctionLib.getString(obj[22]));
					label = new jxl.write.Label(0,i, p.get("kehubm"));
					ws.addCell(label);
					label = new jxl.write.Label(1,i, p.get("gongsimc"));
					ws.addCell(label);
					label = new jxl.write.Label(2,i, p.get("xingming"));
					ws.addCell(label);
					label = new jxl.write.Label(3,i, p.get("birthday"));
					ws.addCell(label);
					label = new jxl.write.Label(4,i, p.get("chenghu"));
					ws.addCell(label);
					label = new jxl.write.Label(5,i, p.get("zhiwei"));
					ws.addCell(label);
					label = new jxl.write.Label(6,i, p.get("zhize"));
					ws.addCell(label);
					label = new jxl.write.Label(7,i, p.get("bumen"));
					ws.addCell(label);
					label = new jxl.write.Label(8,i, p.get("gudingdh"));
					ws.addCell(label);
					label = new jxl.write.Label(9,i, p.get("yidongdh"));
					ws.addCell(label);
					label = new jxl.write.Label(10,i, p.get("xingqu"));
					ws.addCell(label);
					label = new jxl.write.Label(11,i, p.get("qq"));
					ws.addCell(label);
					label = new jxl.write.Label(12,i, p.get("msn"));
					ws.addCell(label);
					label = new jxl.write.Label(13,i, p.get("youjian"));
					ws.addCell(label);
					label = new jxl.write.Label(14,i, p.get("nickname"));
					ws.addCell(label);
					label = new jxl.write.Label(15,i, p.get("lianxidj"));
					ws.addCell(label);
					label = new jxl.write.Label(16,i, p.get("beizhu"));
					ws.addCell(label);
					label = new jxl.write.Label(17,i, p.get("zhaidian"));
					ws.addCell(label);
					label = new jxl.write.Label(18,i, p.get("chuanzhen"));
					ws.addCell(label);
					label = new jxl.write.Label(19,i, p.get("jiguan"));
					ws.addCell(label);
					label = new jxl.write.Label(20,i, p.get("hunfou"));
					ws.addCell(label);
					label = new jxl.write.Label(21,i, p.get("biyeyx"));
					ws.addCell(label);
					label = new jxl.write.Label(22,i, p.get("juesezy"));
					ws.addCell(label);
				}
				it = null;
	            wwb.write();
				wwb.close();
				FunctionLib.download(storedir+ file.getName(),"联系人资料"+ FunctionLib.dtf2.format(new java.util.Date()) +".xls", true);
			}
	    }
		catch(Exception ex){ex.printStackTrace();}
	}
}
