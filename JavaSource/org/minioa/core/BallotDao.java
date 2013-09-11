package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;

import org.minioa.core.Ballot;

public class BallotDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-10
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

	public BallotDao() {
	}

	public ArrayList<Ballot> buildItems() {
		ArrayList<Ballot> items = new ArrayList<Ballot>();
		try {
			getMySession();
			items = new ArrayList<Ballot>();
			Criteria criteria = getSession().createCriteria(Ballot.class).addOrder(Order.desc("ID_"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				Ballot bean = (Ballot) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Ballot selectRecordById() {
		Ballot bean = new Ballot();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Ballot.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					bean = (Ballot) it.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(Ballot bean) {
		try {
			bean.setCID_(getMySession().getUserId());
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

	public void updateRecordById(Ballot bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				getSession().update(bean);
			}

			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("Ballot.id");
			if (FunctionLib.isNum(id)) {
				/*先删除子表中的记录*/
				Query query = getSession().getNamedQuery("core.ballot.items.deleterecordbyheaderid");
				query.setParameter("headerId", id);
				query.executeUpdate();
				/*再删除主表中的类容*/
				Criteria criteria = getSession().createCriteria(Ballot.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((Ballot) it.next());
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
			getMySession().getTempStr().put("Ballot.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

}
