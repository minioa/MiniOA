package org.minioa.core;

import java.util.List;

import org.hibernate.validator.NotEmpty;
import org.minioa.core.PropDao;

public class Prop {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-29
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

	@NotEmpty
	private String propName;

	public void setPropName(String data) {
		propName = data;
	}

	public String getPropName() {
		return propName;
	}

	@NotEmpty
	private String propDesc;

	public void setPropDesc(String data) {
		propDesc = data;
	}

	public String getPropDesc() {
		return propDesc;
	}

	@NotEmpty
	private String propValue;

	public void setPropValue(String data) {
		propValue = data;
	}

	public String getPropValue() {
		return propValue;
	}
	
	private String inputType;

	public void setInputType(String data) {
		inputType = data;
	}

	public String getInputType() {
		return inputType;
	}

	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new PropDao().buildDsList();
		}
		return dsList;
	}

	private List<Prop> items;

	public List<Prop> getItems() {
		if (items == null)
			items = new PropDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Prop bean = new PropDao().selectRecordById();
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.propName = bean.getPropName();
		this.propDesc = bean.getPropDesc();
		this.propValue = bean.getPropValue();
		this.inputType = bean.getInputType();
		return init;
	}

	public Prop() {

	}

	public Prop(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new PropDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new PropDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new PropDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new PropDao().deleteRecordById();
	}
}
