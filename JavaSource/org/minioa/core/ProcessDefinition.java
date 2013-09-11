package org.minioa.core;

import java.util.List;
import org.minioa.core.FormDao;

public class ProcessDefinition {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-22
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

	private String processName, processImage,processImageThum, processDesc, sqlWhenCreate, sqlWhenDelete, sqlWhenAgree, sqlWhenReject, isPublish, notice;
	private Integer formId, formViewId;

	public void setProcessName(String data) {
		processName = data;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessImage(String data) {
		processImage = data;
	}

	public String getProcessImage() {
		return processImage;
	}
	
	public void setProcessImageThum(String data) {
		processImageThum = data;
	}

	public String getProcessImageThum() {
		return processImageThum;
	}

	public void setProcessDesc(String data) {
		processDesc = data;
	}

	public String getProcessDesc() {
		return processDesc;
	}

	public void setSqlWhenCreate(String data) {
		sqlWhenCreate = data;
	}

	public String getSqlWhenCreate() {
		return sqlWhenCreate;
	}

	public void setSqlWhenDelete(String data) {
		sqlWhenDelete = data;
	}

	public String getSqlWhenDelete() {
		return sqlWhenDelete;
	}

	public void setSqlWhenAgree(String data) {
		sqlWhenAgree = data;
	}

	public String getSqlWhenAgree() {
		return sqlWhenAgree;
	}

	public void setSqlWhenReject(String data) {
		sqlWhenReject = data;
	}

	public String getSqlWhenReject() {
		return sqlWhenReject;
	}

	public void setIsPublish(String data) {
		isPublish = data;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public void setNotice(String data) {
		notice = data;
	}

	public String getNotice() {
		return notice;
	}

	public void setFormId(Integer data) {
		formId = data;
	}

	public Integer getFormId() {
		return formId;
	}
	
	public void setFormViewId(Integer data) {
		formViewId = data;
	}

	public Integer getFormViewId() {
		return formViewId;
	}

	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new FormDao().buildDsList();
		}
		return dsList;
	}

	private List<ProcessDefinition> items;

	public List<ProcessDefinition> getItems() {
		if (items == null)
			items = new ProcessDefinitionDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		ProcessDefinition bean = new ProcessDefinitionDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.processName = bean.getProcessName();
		this.processImageThum = bean.getProcessImageThum();
		this.processImage = bean.getProcessImage();
		this.processDesc = bean.getProcessDesc();
		this.sqlWhenCreate = bean.getSqlWhenCreate();
		this.sqlWhenDelete = bean.getSqlWhenDelete();
		this.sqlWhenAgree = bean.getSqlWhenAgree();
		this.sqlWhenReject = bean.getSqlWhenReject();
		this.notice = bean.getNotice();
		this.isPublish = bean.getIsPublish();
		this.formId = bean.getFormId();
		this.formViewId = bean.getFormViewId();
		return init;
	}

	public ProcessDefinition() {

	}

	public ProcessDefinition(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new ProcessDefinitionDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new ProcessDefinitionDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new ProcessDefinitionDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new ProcessDefinitionDao().deleteRecordById();
	}
	
	public void setTempFormViewId() {
		new ProcessDefinitionDao().setTempFormViewId(this);
	}
}
