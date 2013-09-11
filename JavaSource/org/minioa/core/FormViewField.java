package org.minioa.core;

import java.util.List;
import org.minioa.core.FormViewFieldDao;

public class FormViewField {
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

	private Integer viewId;

	public void setViewId(Integer data) {
		viewId = data;
	}

	public Integer getViewId() {
		return viewId;
	}

	private Integer fieldId;

	public void setFieldId(Integer data) {
		fieldId = data;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	private String isShow;

	public void setIsShow(String data) {
		isShow = data;
	}

	public String getIsShow() {
		return isShow;
	}
	
	//是否启用搜索
	private String enabledSearch;

	public void setEnabledSearch(String data) {
		enabledSearch = data;
	}

	public String getEnabledSearch() {
		return enabledSearch;
	}
	//是否空单元
	private Integer spacer;

	public void setSpacer(Integer data) {
		spacer = data;
	}

	public Integer getSpacer() {
		return spacer;
	}

	private String canEdit;

	public void setCanEdit(String data) {
		canEdit = data;
	}

	public String getCanEdit() {
		return canEdit;
	}

	// 列表字段对齐方式
	private String textAlign;

	public void setTextAlign(String data) {
		textAlign = data;
	}

	public String getTextAlign() {
		return textAlign;
	}

	// 列表字段长度
	private String displayWidth;

	public void setDisplayWidth(String data) {
		displayWidth = data;
	}

	public String getDisplayWidth() {
		return displayWidth;
	}

	// 文本框长度
	private Integer inputTextBoxSize;

	public void setInputTextBoxSize(Integer data) {
		inputTextBoxSize = data;
	}

	public Integer getInputTextBoxSize() {
		return inputTextBoxSize;
	}

	// 控件类型
	private String inputType;

	public void setInputType(String data) {
		inputType = data;
	}

	public String getInputType() {
		return inputType;
	}

	// 必填字段？
	private String required;

	public void setRequired(String data) {
		required = data;
	}

	public String getRequired() {
		return required;
	}

	private String fieldType;

	public void setFieldType(String data) {
		fieldType = data;
	}

	public String getFieldType() {
		return fieldType;
	}

	/**
	 * 字段类型，是列表字段还是属性字段
	 */
	private String tableOrEdit;

	public void setTableOrEdit(String data) {
		tableOrEdit = data;
	}

	public String getTableOrEdit() {
		return tableOrEdit;
	}

	/**
	 * 字段显示名称
	 */
	private String fieldText;

	public void setFieldText(String data) {
		fieldText = data;
	}

	public String getFieldText() {
		return fieldText;
	}

	private String fieldName;

	public void setFieldName(String data) {
		fieldName = data;
	}

	public String getFieldName() {
		return fieldName;
	}

	private String checkText;

	public void setCheckText(String data) {
		checkText = data;
	}

	public String getCheckText() {
		return checkText;
	}

	/**
	 * 格式化文本
	 */
	private String formatString;

	public void setFormatString(String data) {
		formatString = data;
	}

	public String getFormatString() {
		return formatString;
	}

	/**
	 * 数据来源
	 */
	private String dataSource;

	public void setDataSource(String data) {
		dataSource = data;
	}

	public String getDataSource() {
		return dataSource;
	}

	private List<FormViewField> items;

	public List<FormViewField> getItems() {
		if (items == null)
			items = new FormViewFieldDao().buildItems();
		return items;
	}

	private List<FormViewField> items2;

	public List<FormViewField> getItems2() {
		if (items2 == null)
			items2 = new FormViewFieldDao().buildItems2();
		return items2;
	}

	private String init;

	public String getInit() {
		FormViewField bean = new FormViewFieldDao().selectRecordById();
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.viewId = bean.getViewId();
		this.fieldId = bean.getFieldId();
		this.isShow = bean.getIsShow();
		this.canEdit = bean.getCanEdit();
		this.fieldText = bean.getFieldText();
		this.fieldType = bean.getFieldType();
		this.tableOrEdit = bean.getTableOrEdit();
		this.displayWidth = bean.getDisplayWidth();
		this.textAlign = bean.getTextAlign();
		this.inputTextBoxSize = bean.getInputTextBoxSize();
		this.inputType = bean.getInputType();
		this.checkText = bean.getCheckText();
		this.required = bean.getRequired();
		this.formatString = bean.getFormatString();
		this.dataSource = bean.getDataSource();
		this.enabledSearch = bean.getEnabledSearch();
		this.spacer = bean.getSpacer();
		return init;
	}

	public FormViewField() {

	}

	public FormViewField(int size) {

	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new FormViewFieldDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new FormViewFieldDao().updateRecordById(this, "", "");
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new FormViewFieldDao().deleteRecordById();
	}

	public void buildFormFile() {
		new FormViewFieldDao().buildFormFile();
	}
}
