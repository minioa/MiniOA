package org.minioa.core;

import java.util.List;
import javax.faces.model.SelectItem;
import org.minioa.core.TaskDao;

public class Task {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-23
	 */

	private int ID_, CID_, MID_;
	private String CDATE, MDATE;
	private java.util.Date CDATE_, MDATE_;
	private String UUID_, MUser;

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
	
	public void setMUser(String data) {
		MUser = data;
	}

	public String getMUser() {
		return MUser;
	}

	private Integer processId, taskDefId, approverId, taskFrom;

	public void setProcessId(Integer data) {
		processId = data;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setTaskDefId(Integer data) {
		taskDefId = data;
	}

	public Integer getTaskDefId() {
		return taskDefId;
	}

	public void setApproverId(Integer data) {
		approverId = data;
	}

	public Integer getApproverId() {
		return approverId;
	}
	
	public void setTaskFrom(Integer data) {
		taskFrom = data;
	}

	public Integer getTaskFrom() {
		return taskFrom;
	}

	private java.util.Date startDate, endDate;

	private String startDateTime, endDateTime;

	public void setStartDate(java.util.Date data) {
		startDate = data;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setEndDate(java.util.Date data) {
		endDate = data;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setStartDateTime(String data) {
		startDateTime = data;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setEndDateTime(String data) {
		endDateTime = data;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	private java.util.Date duDate;
	private String duDateTime;

	public void setDuDate(java.util.Date data) {
		duDate = data;
	}

	public java.util.Date getDuDate() {
		return duDate;
	}

	public void setDuDateTime(String data) {
		duDateTime = data;
	}

	public String getDuDateTime() {
		return duDateTime;
	}

	private String taskStatus, taskStatusText, note, taskName, taskApproveType, taskNextStep;

	public void setTaskStatus(String data) {
		taskStatus = data;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatusText(String data) {
		taskStatusText = data;
	}

	public String getTaskStatusText() {
		return taskStatusText;
	}

	public void setNote(String data) {
		note = data;
	}

	public String getNote() {
		return note;
	}

	public void setTaskName(String data) {
		taskName = data;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskApproveType(String data) {
		taskApproveType = data;
	}

	public String getTaskApproveType() {
		return taskApproveType;
	}

	public void setTaskNextStep(String data) {
		taskNextStep = data;
	}

	public String getTaskNextStep() {
		return taskNextStep;
	}

	private Integer applicantId;

	public void setApplicantId(Integer data) {
		applicantId = data;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	private String applicant, approver, agent;

	public void setApplicant(String data) {
		applicant = data;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApprover(String data) {
		approver = data;
	}

	public String getApprover() {
		return approver;
	}

	public void setAgent(String data) {
		agent = data;
	}

	public String getAgent() {
		return agent;
	}


	private boolean btnAgree, btnReject, btnWithdraw, btnTakeBack, btnComplete, btnConfirm, hasOp;

	public void setBtnAgree(boolean data) {
		btnAgree = data;
	}

	public boolean getBtnAgree() {
		return btnAgree;
	}

	public void setBtnReject(boolean data) {
		btnReject = data;
	}

	public boolean getBtnReject() {
		return btnReject;
	}

	public void setBtnWithdraw(boolean data) {
		btnWithdraw = data;
	}

	public boolean getBtnWithdraw() {
		return btnWithdraw;
	}

	public void setBtnTakeBack(boolean data) {
		btnTakeBack = data;
	}

	public boolean getBtnTakeBack() {
		return btnTakeBack;
	}
	
	public void setBtnComplete(boolean data) {
		btnComplete = data;
	}

	public boolean getBtnComplete() {
		return btnComplete;
	}
	
	public void setBtnConfirm(boolean data) {
		btnConfirm = data;
	}

	public boolean getBtnConfirm() {
		return btnConfirm;
	}

	public void setHasOp(boolean data) {
		hasOp = data;
	}

	public boolean getHasOp() {
		return hasOp;
	}

	private Integer processVersion;

	public void setProcessVersion(Integer data) {
		processVersion = data;
	}

	public Integer getProcessVersion() {
		return processVersion;
	}

	private Integer processDefId;

	public void setProcessDefId(Integer data) {
		processDefId = data;
	}

	public Integer getProcessDefId() {
		return processDefId;
	}

	private Integer instanceId;

	public void setInstanceId(Integer data) {
		instanceId = data;
	}

	public Integer getInstanceId() {
		return instanceId;
	}

	private Integer formId;

	public void setFormId(Integer data) {
		formId = data;
	}

	public Integer getFormId() {
		return formId;
	}

	public String processName;

	public void setProcessName(String data) {
		processName = data;
	}

	public String getProcessName() {
		return processName;
	}
	
	public String wfPage;

	public void setWfPage(String data) {
		wfPage = data;
	}

	public String getWfPage() {
		return wfPage;
	}
	
	public String signameImage;

	public void setSignameImage(String data) {
		signameImage = data;
	}

	public String getSignameImage() {
		return signameImage;
	}

	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new TaskDao().buildDsList();
		}
		return dsList;
	}

	private List<Task> items;

	public List<Task> getItems() {
		if (items == null)
			items = new TaskDao().buildItems();
		return items;
	}

	private List<Task> itemsRunning;

	public List<Task> getItemsRunning() {
		if (itemsRunning == null)
			itemsRunning = new TaskDao().buildItemsRunning();
		return itemsRunning;
	}
	
	private List<Task> itemsCompleted;

	public List<Task> getItemsCompleted() {
		if (itemsCompleted == null)
			itemsCompleted = new TaskDao().buildItemsCompleted();
		return itemsCompleted;
	}

	private String init;

	public String getInit() {
		Task bean = new TaskDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.processId = bean.getProcessId();
		this.taskDefId = bean.getTaskDefId();
		this.taskFrom = bean.getTaskFrom();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
		this.startDateTime = bean.getStartDateTime();
		this.endDateTime = bean.getEndDateTime();
		this.taskStatus = bean.getTaskStatus();
		this.taskStatusText = bean.getTaskStatusText();
		this.approverId = bean.getApproverId();
		this.taskName = bean.getTaskName();
		this.taskApproveType = bean.getTaskApproveType();
		this.taskNextStep = bean.getTaskNextStep();
		this.applicant = bean.getApplicant();
		this.approver = bean.getApprover();
		this.agent = bean.getAgent();
		this.duDate = bean.getDuDate();
		this.duDateTime = bean.getDuDateTime();
		this.processVersion = bean.getProcessVersion();
		this.applicantId = bean.getApplicantId();
		this.wfPage = bean.getWfPage();
		this.signameImage = bean.getSignameImage();
		return init;
	}

	public Task() {

	}

	public Task(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new TaskDao().buildItems();
	}

	public void buildItemsRunning() {
		items = new TaskDao().buildItemsRunning();
	}
	
	public void buildItemsCompleted() {
		items = new TaskDao().buildItemsCompleted();
	}
	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new TaskDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new TaskDao().deleteRecordById();
	}

}
