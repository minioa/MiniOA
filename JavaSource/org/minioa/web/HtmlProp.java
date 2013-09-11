package org.minioa.web;

import java.util.List;

public class HtmlProp {

	private int ID_, CID_, MID_;
	private String CDATE, MDATE;
	private java.util.Date CDATE_, MDATE_;

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

	private String propName;
	
	public void setPropName(String data) {
		propName = data;
	}

	public String getPropName() {
		return propName;
	}
	
	private String propValue;
	
	public void setPropValue(String data) {
		propValue = data;
	}

	public String getPropValue() {
		return propValue;
	}
	
	private String propType;
	
	public void setPropType(String data) {
		propType = data;
	}

	public String getPropType() {
		return propType;
	}
	
	private String keywords;
	
	public void setKeywords(String data) {
		keywords = data;
	}

	public String getKeywords() {
		return keywords;
	}

	private String title;
	
	public void setTitle(String data) {
		title = data;
	}

	public String getTitle() {
		return title;
	}
	
	private String description;
	
	public void setDescription(String data) {
		description = data;
	}

	public String getDescription() {
		return description;
	}


	private List<HtmlProp> items;

	public List<HtmlProp> getItems() {
		if (items == null)
			items = new HtmlPropDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		HtmlProp bean = new HtmlPropDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.propName = bean.getPropName();
		this.propValue = bean.getPropValue();
		this.propType = bean.getPropType();
		this.title = bean.getTitle();
		this.keywords = bean.getKeywords();
		this.description = bean.getDescription();
		return init;
	}

	public HtmlProp() {

	}

	public HtmlProp(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new HtmlPropDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new HtmlPropDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new HtmlPropDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new HtmlPropDao().deleteRecordById();
	}
}
