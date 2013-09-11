package org.minioa.crm;

import java.util.List;

public class Visit {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24
	 * 联系日期lianxirq 记录人jiluren 联系内容lianxinr 下一步行动计划xingdongjh 行动日期xingdongrq 主管批复zhuguanpf
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

	private java.util.Date lianxirq;

	public void setLianxirq(java.util.Date data) {
		lianxirq = data;
	}

	public java.util.Date getLianxirq() {
		return lianxirq;
	}
	
	private java.util.Date xingdongrq;

	public void setXingdongrq(java.util.Date data) {
		xingdongrq = data;
	}

	public java.util.Date getXingdongrq() {
		return xingdongrq;
	}

	private String jiluren, lianxinr, xingdongjh, zhuguanpf, isarc;

	public void setJiluren(String data) {
		jiluren = data;
	}

	public String getJiluren() {
		return jiluren;
	}

	public void setLianxinr(String data) {
		lianxinr = data;
	}

	public String getLianxinr() {
		return lianxinr;
	}
	
	public void setXingdongjh(String data) {
		xingdongjh = data;
	}

	public String getXingdongjh() {
		return xingdongjh;
	}
	public void setZhuguanpf(String data) {
		zhuguanpf = data;
	}

	public String getZhuguanpf() {
		return zhuguanpf;
	}
	public void setIsarc(String data) {
		isarc = data;
	}

	public String getIsarc() {
		return isarc;
	}
	
	private List<Visit> items;

	public List<Visit> getItems() {
		if (items == null)
			items = new VisitDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Visit bean = new VisitDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.lianxirq = bean.getLianxirq();
		this.lianxinr = bean.getLianxinr();
		this.xingdongjh = bean.getXingdongjh();
		this.xingdongrq = bean.getXingdongrq();
		this.jiluren = bean.getJiluren();
		this.zhuguanpf = bean.getZhuguanpf();
		this.isarc = bean.getIsarc();
		return init;
	}

	public Visit() {

	}

	public Visit(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new VisitDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new VisitDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new VisitDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new VisitDao().deleteRecordById();
	}

	public void arc() {
		new VisitDao().arc(this);
	}

	public void unarc() {
		new VisitDao().unarc(this);
	}
}
