package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.jboss.seam.ui.HibernateEntityLoader;
import org.minioa.core.FormViewDao;

public class FormView {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-07
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

	private Integer formId;

	public void setFormId(Integer data) {
		formId = data;
	}

	public Integer getFormId() {
		return formId;
	}

	private String viewName;

	public void setViewName(String data) {
		viewName = data;
	}

	public String getViewName() {
		return viewName;
	}

	private String displayProcessBtn;

	public void setDisplayProcessBtn(String data) {
		displayProcessBtn = data;
	}

	public String getDisplayProcessBtn() {
		return displayProcessBtn;
	}

	private String displayNewBtn;

	public void setDisplayNewBtn(String data) {
		displayNewBtn = data;
	}

	public String getDisplayNewBtn() {
		return displayNewBtn;
	}

	private String displayEditBtn;

	public void setDisplayEditBtn(String data) {
		displayEditBtn = data;
	}

	public String getDisplayEditBtn() {
		return displayEditBtn;
	}

	private String displayDelBtn;

	public void setDisplayDelBtn(String data) {
		displayDelBtn = data;
	}

	public String getDisplayDelBtn() {
		return displayDelBtn;
	}
	
	private String displayDownloadBtn;

	public void setDisplayDownloadBtn(String data) {
		displayDownloadBtn = data;
	}

	public String getDisplayDownloadBtn() {
		return displayDownloadBtn;
	}
	
	private String displayAttachment;

	public void setDisplayAttachment(String data) {
		displayAttachment = data;
	}

	public String getDisplayAttachment() {
		return displayAttachment;
	}
	
	//是否显示创建人及创建时间
	private String displayCInfo;

	public void setDisplayCInfo(String data) {
		displayCInfo = data;
	}

	public String getDisplayCInfo() {
		return displayCInfo;
	}
	
	//是否显示修改人及修改时间
	private String displayMInfo;

	public void setDisplayMInfo(String data) {
		displayMInfo = data;
	}

	public String getDisplayMInfo() {
		return displayMInfo;
	}

	private String viewTemplate;

	public void setViewTemplate(String data) {
		viewTemplate = data;
	}

	public String getViewTemplate() {
		return viewTemplate;
	}
	
	
	public List<SelectItem> si;

	public List<SelectItem> getSi() {
		si = new FormViewDao().buildSi();
		return si;
	}

	private List<FormView> items;

	public List<FormView> getItems() {
		if (items == null)
			items = new FormViewDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		FormView bean = new FormViewDao().selectRecordById();
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.formId = bean.getFormId();
		this.viewName = bean.getViewName();
		this.displayProcessBtn = bean.getDisplayProcessBtn();
		this.displayNewBtn = bean.getDisplayNewBtn();
		this.displayEditBtn = bean.getDisplayEditBtn();
		this.displayDelBtn = bean.getDisplayDelBtn();
		this.displayDownloadBtn = bean.getDisplayDownloadBtn();
		this.displayAttachment = bean.getDisplayAttachment();
		this.displayCInfo = bean.getDisplayCInfo();
		this.displayMInfo = bean.getDisplayMInfo();
		this.viewTemplate = bean.getViewName();
		return init;
	}

	public FormView() {

	}

	public FormView(int size) {

	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new FormViewDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new FormViewDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new FormViewDao().deleteRecordById();
	}
}
