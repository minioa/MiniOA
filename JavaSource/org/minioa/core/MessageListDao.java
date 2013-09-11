package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;

import org.minioa.core.MessageList;

public class MessageListDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-1-5
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

	public MessageListDao() {
	}

	public ArrayList<MessageList> buildItems() {
		ArrayList<MessageList> items = new ArrayList<MessageList>();
		try {
			items = new ArrayList<MessageList>();
			Criteria criteria = getSession().createCriteria(MessageList.class);
			criteria.addOrder(Order.asc("ID_"));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				MessageList bean = (MessageList) it.next();
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public void deleteRecordById(int id) {
		try {
			Criteria criteria = getSession().createCriteria(MessageList.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				getSession().delete((MessageList) it.next());

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}
}
