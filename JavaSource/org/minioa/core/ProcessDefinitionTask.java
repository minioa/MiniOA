package org.minioa.core;

import java.util.List;
import org.minioa.core.FormDao;

public class ProcessDefinitionTask {
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

	private String taskName, taskCode, taskType, taskDuation, taskApproveType, taskNextStep, sqlWhenCompleted;
	private Integer headerId, formViewId, taskApproverId, taskApproverRoleId, taskApproverJobId;

	public void setTaskName(String data) {
		taskName = data;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskCode(String data) {
		taskCode = data;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskType(String data) {
		taskType = data;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskDuation(String data) {
		taskDuation = data;
	}

	public String getTaskDuation() {
		return taskDuation;
	}

	public void setTaskApproveType(String data) {
		taskApproveType = data;
	}

	public String getTaskApproveType() {
		return taskApproveType;
	}

	public void setTaskApproverId(Integer data) {
		taskApproverId = data;
	}

	public Integer getTaskApproverId() {
		return taskApproverId;
	}

	public void setTaskApproverRoleId(Integer data) {
		taskApproverRoleId = data;
	}

	public Integer getTaskApproverRoleId() {
		return taskApproverRoleId;
	}

	public void setTaskApproverJobId(Integer data) {
		taskApproverJobId = data;
	}

	public Integer getTaskApproverJobId() {
		return taskApproverJobId;
	}

	public void setTaskNextStep(String data) {
		taskNextStep = data;
	}

	public String getTaskNextStep() {
		return taskNextStep;
	}

	public void setSqlWhenCompleted(String data) {
		sqlWhenCompleted = data;
	}

	public String getSqlWhenCompleted() {
		return sqlWhenCompleted;
	}

	public void setHeaderId(Integer data) {
		headerId = data;
	}

	public Integer getHeaderId() {
		return headerId;
	}

	public void setFormViewId(Integer data) {
		formViewId = data;
	}

	public Integer getFormViewId() {
		return formViewId;
	}

	/*提醒方式，邮件提醒、短信提醒、即时通讯工具Spark提醒*/
	public String emailNotice, smsNotice, imNotice;

	public void setEmailNotice(String data) {
		emailNotice = data;
	}

	public String getEmailNotice() {
		return emailNotice;
	}

	public void setSmsNotice(String data) {
		smsNotice = data;
	}

	public String getSmsNotice() {
		return smsNotice;
	}

	public void setImNotice(String data) {
		imNotice = data;
	}

	public String getImNotice() {
		return imNotice;
	}

	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new FormDao().buildDsList();
		}
		return dsList;
	}

	private List<ProcessDefinitionTask> items;

	public List<ProcessDefinitionTask> getItems() {
		if (items == null)
			items = new ProcessDefinitionTaskDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		ProcessDefinitionTask bean = new ProcessDefinitionTaskDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.headerId = bean.getHeaderId();
		this.taskName = bean.getTaskName();
		this.taskApproverId = bean.getTaskApproverId();
		this.taskApproverRoleId = bean.getTaskApproverRoleId();
		this.taskApproverJobId = bean.getTaskApproverJobId();
		this.taskApproveType = bean.getTaskApproveType();
		this.taskCode = bean.getTaskCode();
		this.taskDuation = bean.getTaskDuation();
		this.sqlWhenCompleted = bean.getSqlWhenCompleted();
		this.taskNextStep = bean.getTaskNextStep();
		this.taskType = bean.getTaskType();
		this.formViewId = bean.getFormViewId();
		this.emailNotice = bean.getEmailNotice();
		this.smsNotice = bean.getSmsNotice();
		this.imNotice = bean.getImNotice();
		return init;
	}

	public ProcessDefinitionTask() {

	}

	public ProcessDefinitionTask(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new ProcessDefinitionTaskDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new ProcessDefinitionTaskDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new ProcessDefinitionTaskDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new ProcessDefinitionTaskDao().deleteRecordById();
	}
}
