package org.minioa.crm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class ContactDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24
	 * 姓名xingming、称呼chenghu、职位zhiwei
	 * 年龄nianling、固定电话gudingdh、移动电话yidongdh、兴趣xingqu
	 * QQ、MSN、邮件youjian、个人主页gerenzy、微博weibo、备注beizhu、存档isarc
	 * 
	 * 姓名、昵称nickname、性别、部门bumen、生日shengri（带下拉菜单可选日期）、
	 * 联系等级lianxidj（一般、重要、非常重要）、职位、职责zhize、
	 * 角色作用juesezy（执行者、建议者、决策者、核心决策者）、办公电话、传真、手机、宅电zhaidian、邮件、
	 * QQ、MSN、兴趣、籍贯jiguan、婚否hunfou、毕业院校biyeyx、办公地址dizhi、备注。
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

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	public ContactDao() {
	}

	public ArrayList<Contact> buildItems() {
		ArrayList<Contact> items = new ArrayList<Contact>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String uuid = (String) params.get("uuid");
			if (uuid == null || "".equals(uuid))
				return null;
			items = new ArrayList<Contact>();
			Criteria criteria = getSession().createCriteria(Contact.class);
			criteria.add(Restrictions.eq("UUID_", uuid));
			// 只有管理员才可以读取全部记录
			if (!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				criteria.add(Restrictions.eq("CID_", getMySession().getUserId()));
			criteria.addOrder(Order.desc("xingming"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				Contact bean = (Contact) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Contact selectRecordById() {
		Contact bean = new Contact();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("contactId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Contact selectRecordById(Integer id) {
		Contact bean = new Contact();
		try {
			Criteria criteria = getSession().createCriteria(Contact.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()){
				bean = (Contact) it.next();
				if(bean.getBirthday()==null)
					bean.setBirthday(new java.util.Date());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(Contact bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String uuid = (String) params.get("uuid");
			if (uuid == null || "".equals(uuid))
				return;
			if (bean.getIsarc() == null || "".equals(bean.getIsarc()))
				bean.setIsarc("N");
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			bean.setUUID_(uuid);
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

	public void updateRecordById(Contact bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				if (!getMySession().getHasOp().get("crm.admin")) {
					if ("Y".equals(bean.getIsarc())) {
						getMySession().setMsg("已经存档的记录不允许修改", 2);
						return;
					}
					if (bean.getCID_() != getMySession().getUserId()) {
						getMySession().setMsg("您没有权限修改这条记录", 2);
						return;
					}
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
	
	public void arc(Contact bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
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

	public void unarc(Contact bean) {
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
			String id = getMySession().getTempStr().get("Contact.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Contact.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()) {
					Contact bean = (Contact) it.next();
					if (!getMySession().getHasOp().get("crm.admin")) {
						if ("Y".equals(bean.getIsarc())) {
							getMySession().setMsg("已经存档的记录不允许删除", 2);
							return;
						}
						if (bean.getCID_() != getMySession().userId) {
							getMySession().setMsg("您没有权限删除这条记录", 2);
							return;
						}
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
			getMySession().getTempStr().put("Contact.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
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
				InputStream is = new FileInputStream(fileName);
				jxl.Workbook rwb = Workbook.getWorkbook(is);
				Sheet rs = rwb.getSheet(0);
				int rsColumns = rs.getColumns();
				int rsRows = rs.getRows();
				if (rsRows < 2 || rsColumns < 23) {
					getMySession().setMsg("必须有一行记录，字段数必须有23个字段", 2);
					return;
				}
				// 先检查数据的合法性
				Cell cell;
				String cellStr = "";
				for (int i = 1; i < rsRows; i++) {
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
					cell = rs.getCell(3, i);
					cellStr = cell.getContents();
					if (cellStr != null && !cellStr.equals("")) {
						if (!FunctionLib.isDate(cellStr)){
							getMySession().setMsg("日期【" + cellStr + "】格式不对，请检查！行" + (i + 1), 2);
							return;
						}
					}
				}
				// 正式导入数据
				int m = 0;
				for (int i = 1; i < rsRows; i++) {
					cell = rs.getCell(0, i);
					cellStr = cell.getContents();
					Customer customer = new CustomerDao().selectRecordByCode(cellStr);
					Contact bean = new Contact();
					bean.setIsarc("N");
					bean.setCID_(getMySession().getUserId());
					bean.setCDATE_(new java.util.Date());
					bean.setUUID_(customer.getUUID_());
					bean.setXingming(rs.getCell(2, i).getContents());
					cell = rs.getCell(3, i);
					cellStr = cell.getContents();
					if (cellStr != null && !cellStr.equals(""))
						bean.setBirthday(FunctionLib.df.parse(rs.getCell(3, i).getContents()));
					bean.setChenghu(rs.getCell(4, i).getContents());
					bean.setZhiwei(rs.getCell(5, i).getContents());
					bean.setZhize(rs.getCell(6, i).getContents());
					bean.setBumen(rs.getCell(7, i).getContents());
					bean.setGudingdh(rs.getCell(8, i).getContents());
					bean.setYidongdh(rs.getCell(9, i).getContents());
					bean.setXingqu(rs.getCell(10, i).getContents());
					bean.setQq(rs.getCell(11, i).getContents());
					bean.setMsn(rs.getCell(12, i).getContents());
					bean.setYoujian(rs.getCell(13, i).getContents());
					bean.setNickname(rs.getCell(14, i).getContents());
					bean.setLianxidj(rs.getCell(15, i).getContents());
					bean.setBeizhu(rs.getCell(16, i).getContents());
					bean.setZhaidian(rs.getCell(17, i).getContents());
					bean.setChuanzhen(rs.getCell(18, i).getContents());
					bean.setJiguan(rs.getCell(19, i).getContents());
					bean.setHunfou(rs.getCell(20, i).getContents());
					bean.setBiyeyx(rs.getCell(21, i).getContents());
					bean.setJuesezy(rs.getCell(22, i).getContents());
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
