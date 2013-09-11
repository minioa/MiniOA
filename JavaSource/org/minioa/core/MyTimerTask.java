package org.minioa.core;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TimerTask;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.Message.MessageEncodings;
import org.smslib.Service.ServiceStatus;
import org.smslib.modem.SerialModemGateway;

public class MyTimerTask extends TimerTask {
	// 短信Service
	private static Service service;
	// Hibernate Session
	private static Session session;
	// Openfire 即时通讯服务
	private static ConnectionConfiguration xmppConfig;

	private static XMPPConnection xmppConn;

	public static XMPPConnection getXmppConn() {
		return xmppConn;
	}

	public void xmppOpen() {
		try {
			if (xmppConn == null || !xmppConn.isConnected()) {
				xmppConn = new XMPPConnection(xmppConfig);
				xmppConn.connect();
				xmppConn.login("system@" + xmppConn.getServiceName(), "123456");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Session getSession() {
		if (session == null) {
			Configuration configuration = new Configuration().configure("hibernate.timer.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
		}
		return session;
	}

	private static Map<String, String> prop;

	public static void setProp(Map<String, String> data) {
		prop = data;
	}

	public static Map<String, String> getProp() {
		if (prop == null) {
			prop = new HashMap<String, String>();
			Query query = session.getNamedQuery("core.prop.items");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				prop.put(FunctionLib.getString(obj[0]), FunctionLib.getString(obj[1]));
			}
			it = null;
		}
		return prop;
	}

	private static boolean isLock;
	
	public void run() {
		try {
			/* 处理过期任务提醒 */
			getSession();
			if ((xmppConn == null || !xmppConn.isConnected()) && "Y".equals(getProp().get("enableOpenfire"))) {
				xmppConfig = new ConnectionConfiguration(getProp().get("openfireHost"), Integer.valueOf(getProp().get("openfirePort")), "Work");
				xmppConn = new XMPPConnection(xmppConfig);
				xmppConn.connect();
				xmppConn.login(getProp().get("openfireUsername") + "@" + xmppConn.getServiceName(), getProp().get("openfirePassword"));
			}
			Transaction tx = session.beginTransaction();
			StringBuffer ids = new StringBuffer();
			String id,  displayName, email, mobilePhone;
			String subject, htmlContent, textContent;

			/* 处理消息队列 */
			Query query = getSession().createSQLQuery("select ID_,displayname,email,mobilePhone,subject,htmlContent,textContent from core_message_list where ifnull(sended,0) = 0");
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = displayName = email = mobilePhone = subject = htmlContent = textContent = "";
				id = FunctionLib.getString(obj[0]);
				displayName = FunctionLib.getString(obj[1]);
				email = FunctionLib.getString(obj[2]);
				mobilePhone = FunctionLib.getString(obj[3]);
				subject = FunctionLib.getString(obj[4]);
				htmlContent = FunctionLib.getString(obj[5]);
				textContent = FunctionLib.getString(obj[6]);
				// 发送邮件
				//System.out.println("email:" + email);
				if (FunctionLib.isEmail(email))
					sendMail(displayName, email, subject, htmlContent);
				// 发送短信
				// if (!"".equals(mobilePhone))
				// sendShortMessage(mobilePhone, textContent);
				// 发送即时消息
				// if (!"".equals(userName))
				// sendOfMessage(userName, textContent);
				ids.append(id + ",");
			}
			// 删除已处理消息
			tx = session.beginTransaction();
			query = getSession().createSQLQuery("delete from core_message_list where ID_ in (0," + ids.toString() + "0)");
			query.executeUpdate();
			tx.commit();
			
			//客户关系管理，邮件群发发送
			//if(isLock!=true)
			//	crmSendMail();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param username
	 * @param emailAddress
	 * @param subject
	 * @param message
	 * @return
	 */
	public static int sendMail(String username, String emailAddress, String subject, String message) {
		try {
			InternetAddress[] iaTo;
			InternetAddress iaFrom;
			iaTo = new InternetAddress[1];
			iaTo[0] = new InternetAddress();
			iaTo[0].setPersonal(username);
			iaTo[0].setAddress(emailAddress);

			iaFrom = new InternetAddress();
			iaFrom.setPersonal(getProp().get("mail.smtp.displayname"));
			iaFrom.setAddress(getProp().get("mail.smtp.address"));
			
			Properties props = new Properties();
			props.put("mail.smtp.host", getProp().get("mail.smtp.host"));
			props.put("mail.smtp.port", getProp().get("mail.smtp.port"));
			if("Y".endsWith(getProp().get("mail.smtp.auth")))
				props.put("mail.smtp.auth", true);
			MyAuthenticator myAuth = new MyAuthenticator(getProp().get("mail.smtp.user"), getProp().get("mail.smtp.password"));
			javax.mail.Session mailSession = javax.mail.Session.getInstance(props, myAuth);
			mailSession.setDebug(false);
			
			javax.mail.Message msg = new javax.mail.internet.MimeMessage(mailSession);
			Multipart multipart = new MimeMultipart();
			msg.setFrom(iaFrom);
			msg.setRecipients(javax.mail.Message.RecipientType.TO, iaTo);
			msg.setSubject(subject);
			msg.setSentDate(new java.util.Date());
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html;charset=gb2312");
			multipart.addBodyPart(messageBodyPart);
			msg.setContent(multipart);
			msg.saveChanges();
			Transport.send(msg);
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 发送短信
	 * 
	 * @param mobilePhone
	 * @param message
	 */
	public static void sendShortMessage(String mobilePhone, String message) {
		try {
			if (service.getServiceStatus() != ServiceStatus.STARTED)
				service = Service.getInstance();
			if (service.getServiceStatus() == ServiceStatus.STARTED) {
				SerialModemGateway gateway = new SerialModemGateway("SMS", getProp().get("sms.comport"), Integer.valueOf(getProp().get("sms.baudrate")), getProp().get("sms.manufacturer"), getProp().get("sms.model"));
				gateway.setInbound(false);
				gateway.setOutbound(true);
				gateway.setSimPin("0000");
				service.addGateway(gateway);
				service.startService();
				OutboundMessage outMsg = new OutboundMessage(mobilePhone, message);
				outMsg.setEncoding(MessageEncodings.ENCUCS2);
				service.sendMessage(outMsg);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 发送即时消息
	 * 
	 * @param username
	 * @param messageText
	 */
	public static void sendOfMessage(String username, String messageText) {
		try {
			if (xmppConn != null && xmppConn.isConnected()) {
				MessageListener messageListener = new MessageListener() {
					@Override
					public void processMessage(Chat arg0, Message arg1) {
						;
					}
				};
				Chat chat = getXmppConn().getChatManager().createChat(username + "@" + getXmppConn().getServiceName(), messageListener);
				Message msg = new Message();
				msg.setBody(messageText);
				chat.sendMessage(msg);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static int crmSendMail(){
		try {
			if(FunctionLib.systemProps==null)
				return 0;
			isLock = true;
			Query query = getSession().createSQLQuery("SELECT ID_,UUID_, recipient, address, subject, message, gongsimc FROM crm_mail where sended='N'");
			Iterator<?> it = query.list().iterator();
			
			String ids = "0";
			InternetAddress to;
			
			String id, uuid, xingming, youjian, subject,message,gongsimc;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				id = FunctionLib.getString(obj[0]);
				uuid = FunctionLib.getString(obj[1]);
				xingming = FunctionLib.getString(obj[2]);
				youjian = FunctionLib.getString(obj[3]);
				subject = FunctionLib.getString(obj[4]);
				message = FunctionLib.getString(obj[5]);
				gongsimc = FunctionLib.getString(obj[6]);
				to = new InternetAddress();
				to.setAddress(youjian);
				to.setPersonal(xingming, "gb2312");
				
				int result = crmSendMail(to, subject, message.replaceAll("username", gongsimc + ":" + xingming), uuid);
				if(result == 0)
					ids = ids + "," + id;
			}
			//
			Transaction tx = session.beginTransaction();
			String[] arr = ids.split(",");
			for(int i=1; i < arr.length; i++){
				query = getSession().createSQLQuery("update crm_mail set sended = 'Y' where ID_ = :id");
				query.setParameter("id", arr[i]);
				query.executeUpdate();
			}
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		isLock = false;
		return 0;
	}
	
	public static int crmSendMail(InternetAddress to, String subject, String message, String uuid) throws javax.mail.MessagingException {
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

			Query query = getSession().createSQLQuery("select ta.ID_,ta.CID_,ta.CDATE_,ta.MID_,ta.MDATE_,ta.UUID_, ta.filename, ta.filetype, ta.filesize,ta.oldname from crm_mail_attachment ta where ta.UUID_ = :uuid");
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
class MyAuthenticator extends javax.mail.Authenticator {
	private String strUser;
	private String strPwd;

	public MyAuthenticator(String user, String password) {
		this.strUser = user;
		this.strPwd = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(strUser, strPwd);
	}
}
