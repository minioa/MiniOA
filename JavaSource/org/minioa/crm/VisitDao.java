package org.minioa.crm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;

public class VisitDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24
	 * 联系日期lianxirq 记录人jiluren 联系内容lianxinr 下一步行动计划xingdongjh 行动日期xingdongrq 主管批复zhuguanpf
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

	public VisitDao() {
	}

	public ArrayList<Visit> buildItems() {
		ArrayList<Visit> items = new ArrayList<Visit>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String uuid = (String) params.get("uuid");
			if (uuid == null || "".equals(uuid))
				return null;

			items = new ArrayList<Visit>();
			Criteria criteria = getSession().createCriteria(Visit.class);
			criteria.add(Restrictions.eq("UUID_", uuid));
			//只有管理员才可以读取全部记录
			if(!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				criteria.add(Restrictions.eq("CID_", getMySession().getUserId()));
			criteria.addOrder(Order.desc("lianxirq"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				Visit bean = (Visit) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Visit selectRecordById() {
		Visit bean = new Visit();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean = selectRecordById(Integer.valueOf(id));
			} else {
				id = (String) params.get("recordId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Visit selectRecordById(Integer id) {
		Visit bean = new Visit();
		try {
			Criteria criteria = getSession().createCriteria(Visit.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (Visit) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(Visit bean) {
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
			//再添加一条记录
			if(!"".equals(bean.getXingdongjh()) &&  null != bean.getXingdongrq()){
				Visit b = new Visit();
				b.setCID_(getMySession().getUserId());
				b.setCDATE_(new java.util.Date());
				b.setUUID_(uuid);
				b.setIsarc("N");
				b.setLianxirq(bean.getXingdongrq());
				b.setLianxinr(bean.getXingdongjh());
				b.setJiluren(bean.getJiluren());
				b.setXingdongjh("");
				b.setXingdongrq(null);
				getSession().save(b);
				getSession().flush();
			}
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(Visit bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			String pifu = (String) params.get("pifu");
			if (FunctionLib.isNum(id)) {
				if(!getMySession().getHasOp().get("crm.admin")){
					if("Y".equals(bean.getIsarc())){
						getMySession().setMsg("已经存档的记录不允许修改", 2);
						return ;
					}
					if(bean.getCID_()!=getMySession().userId){
						getMySession().setMsg("您没有权限修改这条记录", 2);
						return ;
					}
				}
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
				
				//再添加一条记录
				if(!"".equals(bean.getXingdongjh()) &&  null != bean.getXingdongrq()){
					Visit b = new Visit();
					if("true".equals(pifu))
						b.setCID_(bean.getCID_());
					else
						b.setCID_(getMySession().getUserId());
					b.setCDATE_(new java.util.Date());
					b.setUUID_(bean.getUUID_());
					b.setIsarc("N");
					b.setJiluren(bean.getJiluren());
					b.setLianxirq(bean.getXingdongrq());
					b.setLianxinr(bean.getXingdongjh());
					b.setXingdongjh("");
					b.setXingdongrq(null);
					b.setZhuguanpf("");
					getSession().save(b);
					getSession().flush();
				}
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void arc(Visit bean) {
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

	public void unarc(Visit bean) {
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
			String id = getMySession().getTempStr().get("Visit.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Visit.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext()){
					Visit bean = (Visit)it.next();
					if(!getMySession().getHasOp().get("crm.admin")){
						if("Y".equals(bean.getIsarc())){
							getMySession().setMsg("已经存档的记录不允许删除", 2);
							return ;
						}
						if(bean.getCID_()!=getMySession().getUserId()){
							getMySession().setMsg("您没有权限删除这条记录", 2);
							return ;
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
			getMySession().getTempStr().put("Visit.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
