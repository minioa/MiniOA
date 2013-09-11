package org.minioa.core;

import java.util.List;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.minioa.core.BallotDao;

public class Ballot {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
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

	@NotEmpty
	@Length(min = 2, max = 64)
	private String title;

	public void setTitle(String data) {
		title = data;
	}

	public String getTitle() {
		return title;
	}

	private Integer status;

	public void setStatus(Integer data) {
		status = data;
	}

	public Integer getStatus() {
		return status;
	}

	private List<Ballot> items;

	public List<Ballot> getItems() {
		if (items == null)
			items = new BallotDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Ballot bean = new BallotDao().selectRecordById();
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.title = bean.getTitle();
		this.status = bean.getStatus();
		return init;
	}

	public Ballot() {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new BallotDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new BallotDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new BallotDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new BallotDao().deleteRecordById();
	}
}
