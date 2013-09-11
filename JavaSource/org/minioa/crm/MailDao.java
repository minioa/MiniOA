package org.minioa.crm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FunctionLib;
import org.minioa.core.Lang;
import org.minioa.core.MySession;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class MailDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-4-2 收件人recipient 收件地址address
	 * 主题subjetc 内容message
	 */

	public MySession mySession;

	public MySession getMySession() {
		if (mySession == null)
			mySession = (MySession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MySession");
		if (null == mySession)
			return null;
		if (!"true".equals(mySession.getIsLogin()))
			return null;
		return mySession;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	private String uuid;

	public void setUuid(String data) {
		uuid = data;
	}

	public String getUuid() {
		if (uuid == null) {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			uuid = (String) params.get("uuid");
			if (uuid == null || "".equals(uuid)) {
				getMySession();
				if (mySession.getTempStr() != null) {
					if (mySession.getTempStr().get("crm.mail.uuid") != null)
						uuid = mySession.getTempStr().get("crm.mail.uuid").toString();
				}
				if (uuid == null || "".equals(uuid))
					uuid = java.util.UUID.randomUUID().toString();
			}
			getMySession().getTempStr().put("crm.mail.uuid", uuid);
		}
		return uuid;
	}

	public MailDao() {
	}

	public List<Integer> buildDsList() {
		if (null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			String key = "", key2 = "", key3 = "", key4 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Mail.key") != null)
					key = mySession.getTempStr().get("Mail.key").toString();
				if (mySession.getTempStr().get("Mail.key2") != null)
					key2 = mySession.getTempStr().get("Mail.key2").toString();
				if (mySession.getTempStr().get("Mail.key3") != null)
					key3 = mySession.getTempStr().get("Mail.key3").toString();
				if (mySession.getTempStr().get("Mail.key4") != null)
					key4 = mySession.getTempStr().get("Mail.key4").toString();
			}
			String sql = getSession().getNamedQuery("crm.mail.records.count").getQueryString();
			String where = " where 1=1";
			if (!key.equals(""))
				where += " and recipient like :key";
			if (!key2.equals(""))
				where += " and address like :key2";
			if (!key3.equals(""))
				where += " and subject like :key3";
			if (!key4.equals(""))
				where += " and message like :key4";
			// 只有管理员才可以读取全部记录
			if (!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				where += " and CID_ = " + getMySession().getUserId();
			Query query = getSession().createSQLQuery(sql + where);
			if (!key.equals(""))
				query.setParameter("key", "%" + key + "%");
			if (!key2.equals(""))
				query.setParameter("key2", "%" + key2 + "%");
			if (!key3.equals(""))
				query.setParameter("key3", "%" + key3 + "%");
			if (!key4.equals(""))
				query.setParameter("key4", "%" + key4 + "%");

			int tc = Integer.valueOf(String.valueOf(query.list().get(0)));
			for (int i = 0; i < tc; i++)
				dsList.add(i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<Mail> buildItems() {
		ArrayList<Mail> items = new ArrayList<Mail>();
		try {
			if (null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new Mail());
				return items;
			}
			// 设置第一页
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);

			String key = "", key2 = "", key3 = "", key4 = "";
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("Mail.key") != null)
					key = mySession.getTempStr().get("Mail.key").toString();
				if (mySession.getTempStr().get("Mail.key2") != null)
					key2 = mySession.getTempStr().get("Mail.key2").toString();
				if (mySession.getTempStr().get("Mail.key3") != null)
					key3 = mySession.getTempStr().get("Mail.key3").toString();
				if (mySession.getTempStr().get("Mail.key4") != null)
					key4 = mySession.getTempStr().get("Mail.key4").toString();
			}
			items = new ArrayList<Mail>();
			Criteria criteria = getSession().createCriteria(Mail.class);
			if (!key.equals(""))
				criteria.add(Restrictions.like("recipient", key, MatchMode.ANYWHERE));
			if (!key2.equals(""))
				criteria.add(Restrictions.like("address", key2, MatchMode.ANYWHERE));
			if (!key3.equals(""))
				criteria.add(Restrictions.like("subject", key2, MatchMode.ANYWHERE));
			if (!key4.equals(""))
				criteria.add(Restrictions.like("message", key4, MatchMode.ANYWHERE));

			// 只有管理员才可以读取全部记录
			if (!getMySession().getHasOp().get("crm.admin") && !getMySession().getHasOp().get("crm.data.all"))
				criteria.add(Restrictions.eq("CID_", getMySession().getUserId()));
			criteria.addOrder(Order.desc("CDATE_"));
			criteria.setMaxResults(mySession.getPageSize());
			criteria.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());

			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				Mail bean = (Mail) it.next();
				bean.setCDATE(FunctionLib.dtf.format(bean.getCDATE_()));
				getMySession().getTempStr().put("crm.mail.uuid", bean.getUUID_());
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public Mail selectRecordById() {
		Mail bean = new Mail();
		try {
			getMySession().getTempStr().put("crm.mail.uuid", "");
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id))
				bean = selectRecordById(Integer.valueOf(id));
			else {
				id = (String) params.get("mailId");
				if (FunctionLib.isNum(id))
					bean = selectRecordById(Integer.valueOf(id));
			}
			getMySession();
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("crm.mail.ids") != null && bean.getAddress() == null) {
					bean = new Mail();
					String ids = getMySession().getTempStr().get("crm.mail.ids");
					String[] arr = ids.split(",");
					String recipient = "", address = "";
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] != null && !"".equals(arr[i])) {
							Contact tact = new ContactDao().selectRecordById(Integer.valueOf(arr[i]));
							if (FunctionLib.isEmail(tact.getYoujian())) {
								recipient = recipient + tact.getXingming() + ", ";
								address = address + tact.getYoujian() + ", ";
							}
						}
					}
					bean.setRecipient(recipient);
					bean.setAddress(address);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public Mail selectRecordById(Integer id) {
		Mail bean = new Mail();
		try {
			Criteria criteria = getSession().createCriteria(Mail.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				bean = (Mail) it.next();
				getMySession().getTempStr().put("crm.mail.uuid", bean.getUUID_());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	/***
	 * 将邮件加入队列
	 * 
	 * @param bean
	 */
	public void sendMail(Mail bean) {
		try {
			getMySession();
			if (mySession.getTempStr() != null) {
				if (mySession.getTempStr().get("crm.mail.ids") != null) {
					String ids = getMySession().getTempStr().get("crm.mail.ids");
					String[] arr = ids.split(",");
					int n = 0;
					mySession.setMinValue(0);
					mySession.setMaxValue(arr.length);
					mySession.setCurrentValue(1);
					for (int i = 0; i < arr.length; i++) {
						mySession.setCurrentValue(i + 1);
						if (arr[i] != null && !"".equals(arr[i])) {
							Contact tact = new ContactDao().selectRecordById(Integer.valueOf(arr[i]));
							Customer customer = new CustomerDao().selectRecordByUUID(tact.getUUID_());
							if (FunctionLib.isEmail(tact.getYoujian())) {
								bean.setCID_(getMySession().getUserId());
								bean.setCDATE_(new java.util.Date());
								bean.setUUID_(this.getUuid());
								bean.setAddress(tact.getYoujian());
								bean.setRecipient(tact.getXingming());
								bean.setGongsimc(customer.getGongsimc());
								bean.setSended("N");
								getSession().save(bean);
								getSession().flush();
								getSession().clear();
								n++;
							}
						}
					}
					getMySession().setMsg("已将" + n + "封邮件加入队列，稍后系统将会择机发送！", 1);
					getMySession().getTempStr().put("crm.mail.ids", "");
				}
			}
		} catch (Exception ex) {
			getMySession().setMsg("将邮件加入队列失败", 2);
			ex.printStackTrace();
		}
		mySession.setCurrentValue(0);
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("Mail.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(Mail.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				Mail bean = null;
				while (it.hasNext()) {
					bean = (Mail) it.next();
					// 先删除附件
					new MailAttachment().deleteRecordsByUUID();
				}
				if (bean != null)
					getSession().delete(bean);
			}
			getMySession().setMsg("已删除一封邮件", 1);
		} catch (Exception ex) {
			getMySession().setMsg("删除邮件时遇到错误", 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("Mail.id", (String) params.get("id"));
		} catch (Exception ex) {
			getMySession().setMsg("构造删除对话框时遇到错误", 2);
			ex.printStackTrace();
		}
	}

	public Integer sendMail(InternetAddress to, String subject, String message, String uuid) throws javax.mail.MessagingException {
		try {
			final Properties props = new Properties();
			props.put("mail.smtp.host", FunctionLib.systemProps.get("mail.smtp.host"));
			props.put("mail.smtp.port", FunctionLib.systemProps.get("mail.smtp.port"));
			if ("Y".equals(FunctionLib.systemProps.get("mail.smtp.auth"))) {
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.user", FunctionLib.systemProps.get("mail.smtp.user"));
				props.put("mail.smtp.password", FunctionLib.systemProps.get("mail.smtp.password"));
			} else
				props.put("mail.smtp.auth", "false");
			SMTPAuthenticator auth = new SMTPAuthenticator();
			javax.mail.Session session = javax.mail.Session.getInstance(props, auth);
			session.setDebug(false);
			javax.mail.Message msg = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();
			InternetAddress from = new InternetAddress();
			from.setAddress(FunctionLib.systemProps.get("mail.smtp.address"));
			from.setPersonal(FunctionLib.systemProps.get("mail.smtp.displayname"), "gb2312");
			msg.setFrom(from);
			msg.setRecipient(javax.mail.Message.RecipientType.TO, to);
			msg.setSubject(subject);
			java.util.Date date = new java.util.Date();
			msg.setSentDate(date);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html;charset=gb2312");
			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();

			Query query = getSession().getNamedQuery("crm.mail.attachment.records");
			query.setParameter("uuid", uuid);
			Iterator<?> it = query.list().iterator();
			Map<String, String> p;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				p = new HashMap<String, String>();
				p.put("id", FunctionLib.getString(obj[0]));
				p.put("filename", FunctionLib.getString(obj[6]));
				p.put("filetype", FunctionLib.getString(obj[7]));
				p.put("filesize", FunctionLib.getString(obj[8]));
				p.put("oldname", FunctionLib.getString(obj[9]));
				p.put("uuid", uuid);
				messageBodyPart = new MimeBodyPart();
				if (obj[0] != null && obj[1] != null) {
					File f = new File(FunctionLib.getBaseDir() + p.get("filename"));
					DataSource source = new FileDataSource(f);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(MimeUtility.encodeText(p.get("oldname")));
					multipart.addBodyPart(messageBodyPart);
				}
			}
			it = null;
			msg.setContent(multipart);
			msg.saveChanges();
			Transport.send(msg);
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
}

class SMTPAuthenticator extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		Properties props = new Properties();
		return new PasswordAuthentication(FunctionLib.systemProps.get("mail.smtp.user"), FunctionLib.systemProps.get("mail.smtp.password"));
	}
}