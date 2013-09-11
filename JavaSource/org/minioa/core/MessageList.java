package org.minioa.core;

import java.util.List;
import org.minioa.core.MessageListDao;

public class MessageList {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-1-5
	 */

	private Integer ID_, CID_, MID_;
	private String CDATE, MDATE;
	private java.util.Date CDATE_, MDATE_;
	private String UUID_;

	public void setID_(Integer data) {
		ID_ = data;
	}

	public Integer getID_() {
		return ID_;
	}

	public void setCID_(Integer data) {
		CID_ = data;
	}

	public Integer getCID_() {
		return CID_;
	}

	public void setMID_(Integer data) {
		MID_ = data;
	}

	public Integer getMID_() {
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


	private String userName, displayName, email, mobilePhone, subject, htmlContent, textContent, sended;
	public void setUserName(String data) {
		userName = data;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setDisplayName(String data) {
		displayName = data;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setEmail(String data) {
		email = data;
	}

	public String getEmail() {
		return email;
	}

	public void setMobilePhone(String data) {
		mobilePhone = data;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setSubject(String data) {
		subject = data;
	}

	public String getSubject() {
		return subject;
	}

	public void setHtmlContent(String data) {
		htmlContent = data;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setTextContent(String data) {
		textContent = data;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setSended(String data) {
		sended = data;
	}

	public String getSended() {
		return sended;
	}

	private List<MessageList> items;

	public List<MessageList> getItems() {
		if (items == null)
			items = new MessageListDao().buildItems();
		return items;
	}

	public MessageList() {

	}

	public MessageList(int size) {

	}
}
