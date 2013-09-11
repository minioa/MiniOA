package org.minioa.core;

import java.util.List;
import org.minioa.core.FormDao;

public class Form {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-25
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

	private String formName, tableName, notice, opRead, opEdit, enabledLog, enabledAtt, isPublish;

	public void setFormName(String data) {
		formName = data;
	}

	public String getFormName() {
		return formName;
	}

	public void setTableName(String data) {
		tableName = data;
	}

	public String getTableName() {
		return tableName;
	}

	public void setNotice(String data) {
		notice = data;
	}

	public String getNotice() {
		return notice;
	}

	public void setOpRead(String data) {
		opRead = data;
	}

	public String getOpRead() {
		return opRead;
	}
	public void setOpEdit(String data) {
		opEdit = data;
	}

	public String getOpEdit() {
		return opEdit;
	}

	public void setEnabledLog(String data) {
		enabledLog = data;
	}

	public String getEnabledLog() {
		return enabledLog;
	}

	public void setEnabledAtt(String data) {
		enabledAtt = data;
	}

	public String getEnabledAtt() {
		return enabledAtt;
	}

	public void setIsPublish(String data) {
		isPublish = data;
	}

	public String getIsPublish() {
		return isPublish;
	}


	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new FormDao().buildDsList();
		}
		return dsList;
	}

	private List<Form> items;

	public List<Form> getItems() {
		if (items == null)
			items = new FormDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Form bean = new FormDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.formName = bean.getFormName();
		this.tableName = bean.getTableName();
		this.notice = bean.getNotice();
		this.opRead = bean.getOpRead();
		this.opEdit = bean.getOpEdit();
		this.enabledLog = bean.getEnabledLog();
		this.enabledAtt = bean.getEnabledAtt();
		this.isPublish = bean.getIsPublish();
		return init;
	}

	public Form() {

	}

	public Form(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new FormDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new FormDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new FormDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new FormDao().deleteRecordById();
	}
}
