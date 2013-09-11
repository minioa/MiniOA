package org.minioa.core;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserInfo {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
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
	
	private String userName;

	public void setUserName(String data) {
		userName = data;
	}

	public String getUserName() {
		return userName;
	}

	private String displayName;

	public void setDisplayName(String data) {
		displayName = data;
	}

	public String getDisplayName() {
		return displayName;
	}

	private String email;

	public void setEmail(String data) {
		email = data;
	}

	public String getEmail() {
		return email;
	}

	private String mobilePhone;

	public void setMobilePhone(String data) {
		mobilePhone = data;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	private Integer depaId;

	public void setDepaId(Integer data) {
		depaId = data;
	}

	public Integer getDepaId() {
		return depaId;
	}

	private Integer jobId;

	public void setJobId(Integer data) {
		jobId = data;
	}

	public Integer getJobId() {
		return jobId;
	}

	private Integer jobId2;

	public void setJobId2(Integer data) {
		jobId2 = data;
	}

	public Integer getJobId2() {
		return jobId2;
	}

	public UserInfo selectRecordById(Session s, Integer id) {
		try {
			Criteria criteria = s.createCriteria(UserInfo.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				return (UserInfo) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
