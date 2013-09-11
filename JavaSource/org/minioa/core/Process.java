package org.minioa.core;

import java.util.List;
import javax.faces.model.SelectItem;
import org.minioa.core.ProcessDao;

public class Process {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-23
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

	private Integer processDefId, instanceId, jobId, formId;

	public void setProcessDefId(Integer data) {
		processDefId = data;
	}

	public Integer getProcessDefId() {
		return processDefId;
	}

	public void setInstanceId(Integer data) {
		instanceId = data;
	}

	public Integer getInstanceId() {
		return instanceId;
	}

	public void setJobId(Integer data) {
		jobId = data;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setFormId(Integer data) {
		formId = data;
	}

	public Integer getFormId() {
		return formId;
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

	private String processDesc, processStatus, processStatusText, processNote;

	public void setProcessDesc(String data) {
		processDesc = data;
	}

	public String getProcessDesc() {
		return processDesc;
	}

	public void setProcessStatus(String data) {
		processStatus = data;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatusText(String data) {
		processStatusText = data;
	}

	public String getProcessStatusText() {
		return processStatusText;
	}
	
	public void setProcessNote(String data) {
		processNote = data;
	}

	public String getProcessNote() {
		return processNote;
	}

	private String processName, processImage, applicant;

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

	public void setApplicant(String data) {
		applicant = data;
	}

	public String getApplicant() {
		return applicant;
	}

	private String formViewPath;

	public void setFormViewPath(String data) {
		formViewPath = data;
	}

	public String getFormViewPath() {
		return formViewPath;
	}

	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new ProcessDao().buildDsList();
		}
		return dsList;
	}

	private List<Process> items;

	public List<Process> getItems() {
		if (items == null)
			items = new ProcessDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Process bean = new ProcessDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.processDefId = bean.getProcessDefId();
		this.instanceId = bean.getInstanceId();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
		this.startDateTime = bean.getStartDateTime();
		this.endDateTime = bean.getEndDateTime();
		this.processDesc = bean.getProcessDesc();
		this.processStatus = bean.getProcessStatus();
		this.processStatusText = bean.getProcessStatusText();
		this.processName = bean.getProcessName();
		this.processImage = bean.getProcessImage();
		this.applicant = bean.getApplicant();
		this.formViewPath = bean.getFormViewPath();
		this.processNote = bean.getProcessNote();
		return init;
	}

	public Process() {

	}

	public Process(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new ProcessDao().buildItems();
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new ProcessDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new ProcessDao().deleteRecordById();
	}

	public void createProcess() {
		new ProcessDao().createProcess();
	}

	public void approve() {
		new ProcessDao().approve();
	}
	
	public void authorize() {
		new ProcessDao().authorize();
	}
}
