package org.minioa.crm;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.minioa.core.FormDao;

public class Mail {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-4-2
	 * 收件人recipient 收件地址address 主题subjetc 内容message
	 */
	private int ID_, CID_, MID_;
	private String CDATE, MDATE;
	private java.util.Date CDATE_, MDATE_;
	private String UUID_;

	public void setID_(int data) {
		ID_ = data;
	}

	public int getID_() {
		return ID_;
	}

	public void setCID_(int data) {
		CID_ = data;
	}

	public int getCID_() {
		return CID_;
	}

	public void setMID_(int data) {
		MID_ = data;
	}

	public int getMID_() {
		return MID_;
	}

	public void setCDATE(String data) {
		CDATE = data;
	}

	public String getCDATE() {
		return CDATE;
	}

	public void setMDATE(String data) {
		MDATE = data;
	}

	public String getMDATE() {
		return MDATE;
	}

	public void setCDATE_(java.util.Date data) {
		CDATE_ = data;
	}

	public java.util.Date getCDATE_() {
		return CDATE_;
	}

	public void setMDATE_(java.util.Date data) {
		MDATE_ = data;
	}

	public java.util.Date getMDATE_() {
		return MDATE_;
	}

	public void setUUID_(String data) {
		UUID_ = data;
	}

	public String getUUID_() {
		return UUID_;
	}

	private String recipient, address, subject, message, att, gongsimc, sended;
	
	public void setRecipient(String data) {
		recipient = data;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setAddress(String data) {
		address = data;
	}

	public String getAddress() {
		return address;
	}

	public void setSubject(String data) {
		subject = data;
	}

	public String getSubject() {
		return subject;
	}

	public void setMessage(String data) {
		message = data;
	}

	public String getMessage() {
		return message;
	}
	
	public void setAtt(String data) {
		att = data;
	}

	public String getAtt() {
		return att;
	}
	public void setGongsimc(String data) {
		gongsimc = data;
	}

	public String getGongsimc() {
		return gongsimc;
	}
	
	public void setSended(String data) {
		sended = data;
	}

	public String getSended() {
		return sended;
	}
	
	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new MailDao().buildDsList();
		}
		return dsList;
	}

	private List<Mail> items;

	public List<Mail> getItems() {
		if (items == null)
			items = new MailDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Mail bean = new MailDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.recipient = bean.getRecipient();
		this.address = bean.getAddress();
		this.subject = bean.getSubject();
		this.message = bean.getMessage();
		this.att =  bean.getAtt();
		this.gongsimc = bean.getGongsimc();
		this.sended = bean.getSended();
		return init;
	}

	public Mail() {

	}

	public Mail(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new MailDao().buildItems();
	}


	/**
	 * 立即发送
	 */
	public void sendMail() {
		new MailDao().sendMail(this);
	}
	
	
	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new MailDao().deleteRecordById();
	}
}
