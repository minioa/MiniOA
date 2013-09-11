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
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import jxl.Cell;
import jxl.Sheet;

public class CustomerDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24
	 * 公司名称gongsimc，经营范围，行业（银行、证券、保险、企业）hangye，规模guimo， 法人代表kehubm，城市city，
	 * 地址dizhi，邮编youbian，电话dianhua，传真chuanzhen，邮件youjian，网址wangzhi
	 * ，备注beizhu，存档isarc
	 * 客户编码（建议最好帮忙设定个规则）kehubm、客户全称gongsimc、省份shengfen、区市city、行业、
	 * 规模、年营业额nianyingye、地址、第二地址dizhi2、网址、邮编、电话、传真、邮箱、 预留两个自定义zidingyi
	 * zidingyi2、备注， kehuly 客户来源：网站搜索、朋友介绍、广告、公司资源分配
	 * 
	 * 
	 */
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
	
	private Map<Integer, Boolean> checkIdsMap = new HashMap<Integer, Boolean>();

	public void setCheckIdsMap(Map<Integer, Boolean> data) {
		checkIdsMap = data;
	}

	public Map<Integer, Boolean> getCheckIdsMap() {
		return checkIdsMap;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}
	
	public CustomerDao() {
	}

	public List<Integer> buildDsList() {
		if(null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String key = "", key2 = "", key3 = "", key4 = "", keyPro = "", keyCity = "", key6 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Customer.key") != null)
					key = mySession.getTempStr().get("Customer.key").toString();
				if (mySession.getTempStr().get("Customer.key2") != null)
					key2 = mySession.getTempStr().get("Customer.key2").toString();
				if (mySession.getTempStr().get("Customer.key3") != null)
					key3 = mySession.getTempStr().get("Customer.key3").toString();
				if (mySession.getTempStr().get("Customer.key4") != null)
					key4 = mySession.getTempStr().get("Customer.key4").toString();
				if (mySession.getTempStr().get("Customer.keyPro") != null)
					keyPro = mySession.getTempStr().get("Customer.keyPro").toString();
				if (mySession.getTempStr().get("Customer.keyCity") != null)
					keyCity = mySession.getTempStr().get("Customer.keyCity").toString();
				if (mySession.getTempStr().get("Customer.key6") != null)
					key6 = mySession.getTempStr().get("Customer.key6").toString();
			}
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("Customer.startDate") != null)
					startDate = mySession.getTempDate().get("Customer.startDate");
				if (mySession.getTempDate().get("Customer.endDate") != null)
					endDate = mySession.getTempDate().get("Customer.endDate");
			}
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String type = (String) params.get("type");

			String sql = getSession().getNamedQuery("crm.customer.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and ta.gongsimc like :key";
			if (!key2.equals(""))
				where += " and ta.hangye like :key2";
			if (!key3.equals(""))
				where += " and ta.kehulb = :key3";
			if (!key4.equals(""))
				where += " and ta.kehubm like :key4";
			if (!keyPro.equals(""))
				where += " and ta.shengfen = :keyPro";
			if (!keyCity.equals(""))
				where += " and ta.city = :keyCity";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if (type != null && !"".equals(type))
				where += " and ta.kehulb = :kehulb";
			if(startDate!=null && endDate!=null)
				where += " and ta.CDATE_ between :startDate and :endDate";
			// 只有管理员才可以读取全部记录
			if (!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = " + getMySession().getUserId();
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");
			if (!key3.equals(""))
				query.setParameter("key3", key3);
			if (!key4.equals(""))
				query.setParameter("key4", "%" + key4 + "%");
			if (!keyPro.equals(""))
				query.setParameter("keyPro", keyPro);
			if (!keyCity.equals(""))
				query.setParameter("keyCity", keyCity);
			if (!key6.equals(""))
				query.setParameter("key6", key6);
			if (type != null && !"".equals(type))
				query.setParameter("kehulb", type);
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			int tc = Integer.valueOf(String.valueOf(query.list().get(0)));
			for (int i = 0; i < tc; i++)
				dsList.add(i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<Customer> buildItems() {
		ArrayList<Customer> items = new ArrayList<Customer>();
		checkIdsMap = new HashMap<Integer, Boolean>();
		try {
			if(null == getMySession())
				return null;

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new Customer());
				return items;
			}
			// 设置第一页
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String type = (String) params.get("type");

			String key = "", key2 = "", key3 = "", key4 = "", keyPro = "", keyCity = "", key6="", order = " CDATE_", asc = " asc";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Customer.key") != null)
					key = mySession.getTempStr().get("Customer.key").toString();
				if (mySession.getTempStr().get("Customer.key2") != null)
					key2 = mySession.getTempStr().get("Customer.key2").toString();
				if (mySession.getTempStr().get("Customer.key3") != null)
					key3 = mySession.getTempStr().get("Customer.key3").toString();
				if (mySession.getTempStr().get("Customer.key4") != null)
					key4 = mySession.getTempStr().get("Customer.key4").toString();
				if (mySession.getTempStr().get("Customer.keyPro") != null)
					keyPro = mySession.getTempStr().get("Customer.keyPro").toString();
				if (mySession.getTempStr().get("Customer.keyCity") != null)
					keyCity = mySession.getTempStr().get("Customer.keyCity").toString();
				if (mySession.getTempStr().get("Customer.key6") != null)
					key6 = mySession.getTempStr().get("Customer.key6").toString();
				if (mySession.getTempStr().get("Customer.order") != null)
					order = mySession.getTempStr().get("Customer.order").toString();
				if (mySession.getTempStr().get("Customer.asc") != null)
					asc = mySession.getTempStr().get("Customer.asc").toString();
			}
			java.util.Date startDate = null, endDate = null;
			if (mySession.getTempDate() != null) {
				if (mySession.getTempDate().get("Customer.startDate") != null)
					startDate = mySession.getTempDate().get("Customer.startDate");
				if (mySession.getTempDate().get("Customer.endDate") != null)
					endDate = mySession.getTempDate().get("Customer.endDate");
			}
			items = new ArrayList<Customer>();
			String sql = getSession().getNamedQuery("crm.customer.records").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and ta.gongsimc like :key";
			if (!key2.equals(""))
				where += " and ta.hangye like :key2";
			if (!key3.equals(""))
				where += " and ta.kehulb = :key3";
			if (!key4.equals(""))
				where += " and ta.kehubm like :key4";
			if (!keyPro.equals(""))
				where += " and ta.shengfen = :keyPro";
			if (!keyCity.equals(""))
				where += " and ta.city = :keyCity";
			if (!key6.equals(""))
				where += " and ta.CID_ = :key6";
			if (type != null && !"".equals(type))
				where += " and ta.kehulb = :kehulb";
			if(startDate!=null && endDate!=null)
				where += " and ta.CDATE_ between :startDate and :endDate";
			// 只有管理员才可以读取全部记录
			if (!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and ta.CID_ = " + getMySession().getUserId();
			Query query = getSession().createSQLQuery(sql + where + " order by " + order + " " + asc);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");
			if (!key3.equals(""))
				query.setParameter("key3", key3);
			if (!key4.equals(""))
				query.setParameter("key4", "%" + key4 + "%");
			if (!keyPro.equals(""))
				query.setParameter("keyPro", keyPro);
			if (!keyCity.equals(""))
				query.setParameter("keyCity", keyCity);
			if (!key6.equals(""))
				query.setParameter("key6", key6);
			if (type != null && !"".equals(type))
				query.setParameter("kehulb", type);
			if(startDate!=null && endDate!=null){
				query.setParameter("startDate", startDate);
				query.setParameter("endDate", endDate);
			}
			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("ID_", FunctionLib.getString(obj[0]));
				p.put("CID_", FunctionLib.getString(obj[1]));
				p.put("CDATE_", FunctionLib.getDateString(obj[2]));
				p.put("MID_", FunctionLib.getString(obj[3]));
				p.put("MDATE_", FunctionLib.getDateString(obj[4]));
				p.put("UUID_", FunctionLib.getString(obj[5]));
				p.put("gongsimc", FunctionLib.getString(obj[6]));
				p.put("shengfen", FunctionLib.getString(obj[7]));
				p.put("hangye", FunctionLib.getString(obj[8]));
				p.put("guimo", FunctionLib.getString(obj[9]));
				p.put("kehubm", FunctionLib.getString(obj[10]));
				p.put("city", FunctionLib.getString(obj[11]));
				p.put("dizhi", FunctionLib.getString(obj[12]));
				p.put("youbian", FunctionLib.getString(obj[13]));
				p.put("dianhua", FunctionLib.getString(obj[14]));
				p.put("chuanzhen", FunctionLib.getString(obj[15]));
				p.put("youjian", FunctionLib.getString(obj[16]));
				p.put("wangzhi", FunctionLib.getString(obj[17]));
				p.put("beizhu", FunctionLib.getString(obj[18]));
				p.put("dizhi2", FunctionLib.getString(obj[19]));
				p.put("zidingyi", FunctionLib.getString(obj[20]));
				p.put("zidingyi2", FunctionLib.getString(obj[21]));
				p.put("kehulb", FunctionLib.getString(obj[22]));
				p.put("nianyingye", FunctionLib.getString(obj[23]));
				p.put("isarc", FunctionLib.getString(obj[24]));
				p.put("cUser", FunctionLib.getString(obj[25]));
				p.put("kehuly", FunctionLib.getString(obj[26]));
				items.add(new Customer(p));
				checkIdsMap.put(FunctionLib.getInt(obj[0]), false);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Customer selectRecordById() {
		Customer bean = new Customer();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("customerId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Customer selectRecordById(Integer id) {
		Customer bean = new Customer();
		try {
			Criteria criteria = getSession().createCriteria(Customer.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Customer) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}
	
	public Customer selectRecordByCode(String code) {
		Customer bean = new Customer();
		try {
			Criteria criteria = getSession().createCriteria(Customer.class).add(Restrictions.eq("kehubm", code));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Customer) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Customer selectRecordByUUID(String uuid) {
		Customer bean = new Customer();
		try {
			Criteria criteria = getSession().createCriteria(Customer.class).add(Restrictions.eq("UUID_", uuid));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Customer) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(Customer bean) {
		try {
			if (bean.getIsarc() == null || "".equals(bean.getIsarc()))
				bean.setIsarc("N");
			//
			Query query = getSession().getNamedQuery("crm.customer.isexists");
			query.setParameter("kehubm", bean.getKehubm());
			if(FunctionLib.getInt(query.list().get(0)) > 0){
				getMySession().setMsg("客户编码【"+ bean.getKehubm() +"】已经存在，请重新选择", 2);
				return;
			}
			
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			bean.setUUID_(java.util.UUID.randomUUID().toString());
			getSession().save(bean);
			getSession().flush();
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(Customer bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				if (!getMySession().getHasOp().get("crm.admin")) {
					if ("Y".equals(bean.getIsarc())) {
						getMySession().setMsg("已经存档的记录不允许修改", 2);
						return;
					}
					if (bean.getCID_() != getMySession().userId) {
						getMySession().setMsg("您没有权限修改这条记录", 2);
						return;
					}
				}
				Query query = getSession().getNamedQuery("crm.customer.isexists2");
				query.setParameter("kehubm", bean.getKehubm());
				query.setParameter("id", bean.getID_());
				if(FunctionLib.getInt(query.list().get(0)) > 0){
					getMySession().setMsg("客户编码【"+ bean.getKehubm() +"】已经存在，请重新选择", 2);
					return;
				}
				
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
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
	
	/**
	 * 重新分配客户
	 */
	public void updateCId() {
		try {
			getMySession();
			String cId = "0";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Customer.man") != null)
					cId = mySession.getTempStr().get("Customer.man").toString();
			}
			if(cId =="" || cId =="0"){
				getMySession().setMsg("您至少选择一位客户经理作为要分配的对象", 2);
				return ;
			}
			int i =0;
			Query query;
			for (Map.Entry<Integer, Boolean> entry : checkIdsMap.entrySet()) {
				if (entry.getValue()) {
					query = getSession().getNamedQuery("crm.customer.updatecid");
					query.setParameter("id", entry.getKey());
					query.setParameter("cId", cId);
					query.executeUpdate();
					query = getSession().getNamedQuery("crm.visit.updatecid");
					query.setParameter("id", entry.getKey());
					query.setParameter("cId", cId);
					query.executeUpdate();
					query = getSession().getNamedQuery("crm.record.updatecid");
					query.setParameter("id", entry.getKey());
					query.setParameter("cId", cId);
					query.executeUpdate();
					query = getSession().getNamedQuery("crm.contact.updatecid");
					query.setParameter("id", entry.getKey());
					query.setParameter("cId", cId);
					query.executeUpdate();
					query = getSession().getNamedQuery("crm.customer.attachment.updatecid");
					query.setParameter("id", entry.getKey());
					query.setParameter("cId", cId);
					query.executeUpdate();
					i++;
				}
			}
			getMySession().setMsg("已经将"+ i +"个客户分配给了'" + FunctionLib.getUserDisplayNameByUserId(getSession(), Integer.valueOf(cId)) + "'", 1);
		} catch (Exception ex) {
			getMySession().setMsg("分配客户时遇到错误，请检查日志", 2);
			ex.printStackTrace();
		}
	}

	public void arc(Customer bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				if (!getMySession().getHasOp().get("crm.admin")) {
					if ("Y".equals(bean.getIsarc())) {
						getMySession().setMsg("已经存档的记录不允许修改", 2);
						return;
					}
					if (bean.getCID_() != getMySession().userId) {
						getMySession().setMsg("您没有权限修改这条记录", 2);
						return;
					}
				}
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				bean.setIsarc("Y");
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

	public void unarc(Customer bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				bean.setIsarc("N");
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
			String id = getMySession().getTempStr().get("Customer.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Customer.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()) {
					Customer bean = (Customer) it.next();
					if (!getMySession().getHasOp().get("crm.admin")) {
						if ("Y".equals(bean.getIsarc())) {
							getMySession().setMsg("已经存档的记录不允许删除", 2);
							return;
						}
						if (bean.getCID_() != getMySession().getUserId()) {
							getMySession().setMsg("您没有权限删除这条记录", 2);
							return;
						}
					}
					//判断是否有附件
					Query query = getSession().getNamedQuery("crm.customer.hassubitems");
					query.setParameter("uuid", bean.getUUID_());
					if(FunctionLib.getInt(query.list().get(0))==1){
						getMySession().setMsg("此条记录下还包括子记录，不能删除！", 2);
						return;
					}
					getSession().delete(bean);
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

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Customer.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void download() {
		try {
			getMySession();
			String storedir = FunctionLib.getBaseDir() + "temp" + FunctionLib.getSeparator() + "download" + FunctionLib.getSeparator();
			if (FunctionLib.isDirExists(storedir)) {
				File file = new File(storedir + mySession.getUserId() + ".xls");
				if (file.exists())
					file.delete();
				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(file);
				jxl.write.WritableSheet ws = wwb.createSheet("data", 0);
				jxl.write.Label label;
				jxl.write.Number number;
				jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##");
				jxl.write.WritableCellFormat wcNf = new jxl.write.WritableCellFormat(nf);

				label = new jxl.write.Label(0, 0, "客户编码");
				ws.addCell(label);
				label = new jxl.write.Label(1, 0, "客户全称");
				ws.addCell(label);
				label = new jxl.write.Label(2, 0, "客户类型");
				ws.addCell(label);
				label = new jxl.write.Label(3, 0, "省份");
				ws.addCell(label);
				label = new jxl.write.Label(4, 0, "区市");
				ws.addCell(label);
				label = new jxl.write.Label(5, 0, "行业");
				ws.addCell(label);
				label = new jxl.write.Label(6, 0, "规模");
				ws.addCell(label);
				label = new jxl.write.Label(7, 0, "年营业额");
				ws.addCell(label);
				label = new jxl.write.Label(8, 0, "地址");
				ws.addCell(label);
				label = new jxl.write.Label(9, 0, "第二地址");
				ws.addCell(label);
				label = new jxl.write.Label(10, 0, "网址");
				ws.addCell(label);
				label = new jxl.write.Label(11, 0, "邮编");
				ws.addCell(label);
				label = new jxl.write.Label(12, 0, "电话");
				ws.addCell(label);
				label = new jxl.write.Label(13, 0, "传真");
				ws.addCell(label);
				label = new jxl.write.Label(14, 0, "邮箱");
				ws.addCell(label);
				label = new jxl.write.Label(15, 0, "自定义");
				ws.addCell(label);
				label = new jxl.write.Label(16, 0, "自定义2");
				ws.addCell(label);
				label = new jxl.write.Label(17, 0, "备注");
				ws.addCell(label);
				label = new jxl.write.Label(18, 0, "客户来源");
				ws.addCell(label);
				label = new jxl.write.Label(19, 0, "客户经理");
				ws.addCell(label);
				Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
				String type = (String) params.get("type");
				String key = "", key2 = "", key3 = "", key4 = "", keyPro="", keyCity = "", key6="", order = " CDATE_", asc = " asc";
				if (mySession.getTempStr() != null) {
					if (mySession.getTempStr().get("Customer.key") != null)
						key = mySession.getTempStr().get("Customer.key").toString();
					if (mySession.getTempStr().get("Customer.key2") != null)
						key2 = mySession.getTempStr().get("Customer.key2").toString();
					if (mySession.getTempStr().get("Customer.key3") != null)
						key3 = mySession.getTempStr().get("Customer.key3").toString();
					if (mySession.getTempStr().get("Customer.key4") != null)
						key4 = mySession.getTempStr().get("Customer.key4").toString();
					if (mySession.getTempStr().get("Customer.keyPro") != null)
						keyPro = mySession.getTempStr().get("Customer.keyPro").toString();
					if (mySession.getTempStr().get("Customer.keyCity") != null)
						keyCity = mySession.getTempStr().get("Customer.keyCity").toString();
					if (mySession.getTempStr().get("Customer.key6") != null)
						key6 = mySession.getTempStr().get("Customer.key6").toString();
					if (mySession.getTempStr().get("Customer.order") != null)
						order = mySession.getTempStr().get("Customer.order").toString();
					if (mySession.getTempStr().get("Customer.asc") != null)
						asc = mySession.getTempStr().get("Customer.asc").toString();
				}
				java.util.Date startDate = null, endDate = null;
				if (mySession.getTempDate() != null) {
					if (mySession.getTempDate().get("Customer.startDate") != null)
						startDate = mySession.getTempDate().get("Customer.startDate");
					if (mySession.getTempDate().get("Customer.endDate") != null)
						endDate = mySession.getTempDate().get("Customer.endDate");
				}

				String sql = getSession().getNamedQuery("crm.customer.records").getQueryString();
				String where = " where 1=1";
				if (!key.equals(""))
					where += " and ta.gongsimc like :key";
				if (!key2.equals(""))
					where += " and ta.hangye like :key2";
				if (!key3.equals(""))
					where += " and ta.kehulb = :key3";
				if (!key4.equals(""))
					where += " and ta.kehubm like :key4";
				if (!keyPro.equals(""))
					where += " and ta.shengfen = :keyPro";
				if (!keyCity.equals(""))
					where += " and ta.shengfen = :keyCity";
				if (!key6.equals(""))
					where += " and ta.CID_ = :key6";
				if (type != null && !"".equals(type))
					where += " and ta.kehulb = :kehulb";
				if(startDate!=null && endDate!=null)
					where += " and ta.CDATE_ between :startDate and :endDate";
				// 只有管理员才可以读取全部记录
				if (!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
					where += " and ta.CID_ = " + getMySession().getUserId();
				Query query = getSession().createSQLQuery(sql + where + " order by " + order + " " + asc);
				if (!key.equals(""))
					query.setParameter("key", "%" + key + "%");
				if (!key2.equals(""))
					query.setParameter("key2", "%" + key2 + "%");
				if (!key3.equals(""))
					query.setParameter("key3", key3);
				if (!key4.equals(""))
					query.setParameter("key4", "%" + key4 + "%");
				if (!keyCity.equals(""))
					query.setParameter("keyCity", keyCity);
				if (!keyPro.equals(""))
					query.setParameter("keyPro", keyPro);
				if (!key6.equals(""))
					query.setParameter("key6", key6);
				if (type != null && !"".equals(type))
					query.setParameter("kehulb", type);
				if(startDate!=null && endDate!=null){
					query.setParameter("startDate", startDate);
					query.setParameter("endDate", endDate);
				}
				Iterator<?> it = query.list().iterator();
				int i = 0;
				while (it.hasNext()) {
					i++;
					Object obj[] = (Object[]) it.next();
					label = new jxl.write.Label(0, i, FunctionLib.getString(obj[10]));
					ws.addCell(label);
					label = new jxl.write.Label(1, i, FunctionLib.getString(obj[6]));
					ws.addCell(label);
					label = new jxl.write.Label(2, i, FunctionLib.getString(obj[22]));
					ws.addCell(label);
					label = new jxl.write.Label(3, i, FunctionLib.getString(obj[7]));
					ws.addCell(label);
					label = new jxl.write.Label(4, i, FunctionLib.getString(obj[11]));
					ws.addCell(label);
					label = new jxl.write.Label(5, i, FunctionLib.getString(obj[8]));
					ws.addCell(label);
					label = new jxl.write.Label(6, i, FunctionLib.getString(obj[9]));
					ws.addCell(label);
					number = new jxl.write.Number(7, i, FunctionLib.getDouble(obj[27]));
					ws.addCell(number);
					label = new jxl.write.Label(8, i, FunctionLib.getString(obj[12]));
					ws.addCell(label);
					label = new jxl.write.Label(9, i, FunctionLib.getString(obj[19]));
					ws.addCell(label);
					label = new jxl.write.Label(10, i, FunctionLib.getString(obj[17]));
					ws.addCell(label);
					label = new jxl.write.Label(11, i, FunctionLib.getString(obj[13]));
					ws.addCell(label);
					label = new jxl.write.Label(12, i, FunctionLib.getString(obj[14]));
					ws.addCell(label);
					label = new jxl.write.Label(13, i, FunctionLib.getString(obj[15]));
					ws.addCell(label);
					label = new jxl.write.Label(14, i, FunctionLib.getString(obj[16]));
					ws.addCell(label);
					label = new jxl.write.Label(15, i, FunctionLib.getString(obj[20]));
					ws.addCell(label);
					label = new jxl.write.Label(16, i, FunctionLib.getString(obj[21]));
					ws.addCell(label);
					label = new jxl.write.Label(17, i, FunctionLib.getString(obj[18]));
					ws.addCell(label);
					label = new jxl.write.Label(18, i, FunctionLib.getString(obj[26]));
					ws.addCell(label);
					label = new jxl.write.Label(19, i, FunctionLib.getString(obj[25]));
					ws.addCell(label);
				}
				it = null;
				wwb.write();
				wwb.close();
				FunctionLib.download(storedir + file.getName(), "客户资料" + FunctionLib.dtf2.format(new java.util.Date()) + ".xls", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void uploadListener(UploadEvent event) {
		try {
			getMySession();
			String storedir = FunctionLib.getBaseDir() + "temp" + FunctionLib.getSeparator() + "upload" + FunctionLib.getSeparator();
			if (FunctionLib.isDirExists(storedir)) {
				String fileName = storedir + mySession.getUserId() + ".xls";
				File f = new File(fileName);
				if (f.exists())
					f.delete();

				List<UploadItem> itemList = event.getUploadItems();
				for (int i = 0; i < itemList.size(); i++) {
					UploadItem item = (UploadItem) itemList.get(i);
					File file = new File(fileName);
					FileOutputStream out = new FileOutputStream(file);
					out.write(item.getData());
					out.close();
				}
				// 准备导入数据
				f = new File(fileName);
				if (!f.exists())
					return;
				//
				boolean isOk = true;
				InputStream is = new FileInputStream(fileName);
				jxl.Workbook rwb = Workbook.getWorkbook(is);
				Sheet rs = rwb.getSheet(0);
				int rsColumns = rs.getColumns();
				int rsRows = rs.getRows();
				if (rsRows < 2 || rsColumns < 19) {
					getMySession().setMsg("必须有一行记录，字段数必须有19个字段", 2);
					return;
				}
				Cell cell;
				// 先检查数据的合法性
				String cellStr = "";
				for (int i = 1; i < rsRows; i++) {
					for (int j = 0; j < 11; j++) {
						cell = rs.getCell(0, i);
						cellStr = cell.getContents();
						Customer bean = new CustomerDao().selectRecordByCode(cellStr);
						if (bean.getKehubm() == null || "".equals(bean.getKehubm())) {
							getMySession().setMsg("客户编码【" + cellStr + "】不存在，请检查！行" + (i + 1), 2);
							return;
						}
						Query query = getSession().getNamedQuery("crm.customer.isexists");
						query.setParameter("kehubm", bean.getKehubm());
						if(FunctionLib.getInt(query.list().get(0)) > 0){
							getMySession().setMsg("客户编码【"+ bean.getKehubm() +"】已经存在，请重新选择", 2);
							return;
						}
						
						cell = rs.getCell(j, i);
						cellStr = cell.getContents();
						if (j == 7) {
							if (cellStr != null && !cellStr.equals("")) {
								if (!FunctionLib.isNum(cellStr))
									isOk = false;
							}
						}
					}
				}
				if (!isOk) {
					getMySession().setMsg("年营业额格式不对，必须是数值", 2);
					return;
				}
				// 正式导入数据
				int m = 0;
				for (int i = 1; i < rsRows; i++) {
					Customer bean = new Customer();
					bean.setIsarc("N");
					bean.setCID_(getMySession().getUserId());
					bean.setCDATE_(new java.util.Date());
					bean.setUUID_(java.util.UUID.randomUUID().toString());
					bean.setKehubm(rs.getCell(0, i).getContents());
					bean.setGongsimc(rs.getCell(1, i).getContents());
					bean.setKehulb(rs.getCell(2, i).getContents());
					bean.setShengfen(rs.getCell(3, i).getContents());
					bean.setCity(rs.getCell(4, i).getContents());
					bean.setHangye(rs.getCell(5, i).getContents());
					bean.setGuimo(rs.getCell(6, i).getContents());
					bean.setNianyingye(FunctionLib.getInt(rs.getCell(7, i).getContents()));
					bean.setDizhi(rs.getCell(8, i).getContents());
					bean.setDizhi2(rs.getCell(9, i).getContents());
					bean.setWangzhi(rs.getCell(10, i).getContents());
					bean.setYoubian(rs.getCell(11, i).getContents());
					bean.setDianhua(rs.getCell(12, i).getContents());
					bean.setChuanzhen(rs.getCell(13, i).getContents());
					bean.setYoujian(rs.getCell(14, i).getContents());
					bean.setZidingyi(rs.getCell(15, i).getContents());
					bean.setZidingyi2(rs.getCell(16, i).getContents());
					bean.setBeizhu(rs.getCell(17, i).getContents());
					bean.setKehuly(rs.getCell(18, i).getContents());
					getSession().save(bean);
					getSession().flush();
					m++;
				}
				getMySession().setMsg("导入完成，共新增" + m + "条记录", 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			getMySession().setMsg("导入数据失败，请检查", 2);
		}
	}
}
