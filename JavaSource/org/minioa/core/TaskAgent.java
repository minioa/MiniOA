package org.minioa.core;

import java.util.List;
import javax.faces.model.SelectItem;
import org.minioa.core.FormDao;

public class TaskAgent {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-23
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

	private Integer taskDefId, agentId, taskId;

	private java.util.Date startDate, endDate;

	private String startDateTime, endDateTime;

	public void setTaskDefId(Integer data) {
		taskDefId = data;
	}

	public Integer getTaskDefId() {
		return taskDefId;
	}

	public void setAgentId(Integer data) {
		agentId = data;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setTaskId(Integer data) {
		taskId = data;
	}

	public Integer getTaskId() {
		return taskId;
	}

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

	private String processName;

	public void setProcessName(String data) {
		processName = data;
	}

	public String getProcessName() {
		return processName;
	}

	private String taskName;

	public void setTaskName(String data) {
		taskName = data;
	}

	public String getTaskName() {
		return taskName;
	}

	private String agent;

	public void setAgent(String data) {
		agent = data;
	}

	public String getAgent() {
		return agent;
	}

	private List<TaskAgent> items;

	public List<TaskAgent> getItems() {
		if (items == null)
			items = new TaskAgentDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		TaskAgent bean = new TaskAgentDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.taskDefId = bean.getTaskDefId();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
		this.agentId = bean.getAgentId();
		this.processName = bean.getTaskName();
		this.taskName = bean.getTaskName();
		this.agent = bean.getAgent();
		this.startDateTime = bean.getStartDateTime();
		this.endDateTime = bean.getEndDateTime();
		this.taskId = bean.getTaskId();
		return init;
	}

	public TaskAgent() {

	}

	public TaskAgent(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new TaskAgentDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new TaskAgentDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new TaskAgentDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new TaskAgentDao().deleteRecordById();
	}

	public List<SelectItem> si;

	public List<SelectItem> getSi() {
		return new TaskAgentDao().buildSi();
	}
}
