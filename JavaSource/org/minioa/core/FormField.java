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
import org.minioa.core.FormFieldDao;

public class FormField {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-27
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

	private Integer formId, fieldWidth;

	public void setFormId(Integer data) {
		formId = data;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFieldWidth(Integer data) {
		fieldWidth = data;
	}

	public Integer getFieldWidth() {
		return fieldWidth;
	}

	private String fieldName;

	public void setFieldName(String data) {
		fieldName = data;
	}

	public String getFieldName() {
		return fieldName;
	}

	private String fieldText;

	public void setFieldText(String data) {
		fieldText = data;
	}

	public String getFieldText() {
		return fieldText;
	}

	private String fieldType, dataSource, textItems, checkRule, checkText, formatString;

	public void setFieldType(String data) {
		fieldType = data;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setDataSource(String data) {
		dataSource = data;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setTextItems(String data) {
		textItems = data;
	}

	public String getTextItems() {
		return textItems;
	}

	public void setCheckRule(String data) {
		checkRule = data;
	}

	public String getCheckRule() {
		return checkRule;
	}

	public void setCheckText(String data) {
		checkText = data;
	}

	public String getCheckText() {
		return checkText;
	}

	public void setFormatString(String data) {
		formatString = data;
	}

	public String getFormatString() {
		return formatString;
	}

	private String checkType;

	public void setCheckType(String data) {
		checkType = data;
	}

	public String getCheckType() {
		return checkType;
	}

	private String autoIncrease;

	public void setAutoIncrease(String data) {
		autoIncrease = data;
	}

	public String getAutoIncrease() {
		return autoIncrease;
	}

	private Integer orderNum;

	public void setOrderNum(Integer data) {
		orderNum = data;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public List<SelectItem> si;

	public List<SelectItem> getSi() {
		if (si == null)
			si = new FormFieldDao().buildSi();
		return si;
	}

	private List<FormField> items;

	public List<FormField> getItems() {
		if (items == null)
			items = new FormFieldDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		FormField bean = new FormFieldDao().selectRecordById();
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.formId = bean.getFormId();
		this.fieldWidth = bean.getFieldWidth();
		this.fieldName = bean.getFieldName();
		this.fieldText = bean.getFieldText();
		this.fieldType = bean.getFieldType();
		this.dataSource = bean.getDataSource();
		this.textItems = bean.getTextItems();
		this.checkRule = bean.getCheckRule();
		this.checkText = bean.getCheckText();
		this.formatString = bean.getFormatString();
		this.checkType = bean.getCheckType();
		this.autoIncrease = bean.getAutoIncrease();
		this.orderNum = bean.getOrderNum();
		return init;
	}

	public FormField() {

	}

	public FormField(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new FormFieldDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new FormFieldDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new FormFieldDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new FormFieldDao().deleteRecordById();
	}
}
