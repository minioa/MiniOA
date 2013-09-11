package org.minioa.crm;

import java.util.List;
import org.minioa.core.FormDao;

public class Record {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24 项目名称 xiangmumc、项目金额
	 * jiaoyije、开始日期 jiaoyisj、结束日期jieshusj 、培训对象peixundx、学员人数xueyuanrs、客户反馈kehufk、备注beizhu、增值服务zengzhifw
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

	private double jiaoyije;

	public void setJiaoyije(double data) {
		jiaoyije = data;
	}

	public double getJiaoyije() {
		return jiaoyije;
	}

	private java.util.Date jiaoyisj, jieshusj;

	public void setJiaoyisj(java.util.Date data) {
		jiaoyisj = data;
	}

	public java.util.Date getJiaoyisj() {
		return jiaoyisj;
	}
	
	public void setJieshusj(java.util.Date data) {
		jieshusj = data;
	}

	public java.util.Date getJieshusj() {
		return jieshusj;
	}

	private String xiangmumc, kehufk, beizhu, peixundx, zengzhifw, isarc;

	public void setXiangmumc(String data) {
		xiangmumc = data;
	}

	public String getXiangmumc() {
		return xiangmumc;
	}

	public void setKehufk(String data) {
		kehufk = data;
	}

	public String getKehufk() {
		return kehufk;
	}

	public void setBeizhu(String data) {
		beizhu = data;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setIsarc(String data) {
		isarc = data;
	}

	public String getIsarc() {
		return isarc;
	}
	
	public void setPeixundx(String data) {
		peixundx = data;
	}

	public String getPeixundx() {
		return peixundx;
	}

	public void setZengzhifw(String data) {
		zengzhifw = data;
	}

	public String getZengzhifw() {
		return zengzhifw;
	}
	
	private Integer xueyuanrs;
	
	public void setXueyuanrs(Integer data) {
		xueyuanrs = data;
	}

	public Integer getXueyuanrs() {
		return xueyuanrs;
	}
	
	private List<Record> items;

	public List<Record> getItems() {
		if (items == null)
			items = new RecordDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Record bean = new RecordDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.xiangmumc = bean.getXiangmumc();
		this.jiaoyije = bean.getJiaoyije();
		this.jiaoyisj = bean.getJiaoyisj();
		this.kehufk = bean.getKehufk();
		this.beizhu = bean.getBeizhu();
		this.jieshusj = bean.getJieshusj();
		this.xueyuanrs = bean.getXueyuanrs();
		this.peixundx = bean.getPeixundx();
		this.zengzhifw = bean.getZengzhifw();
		this.isarc = bean.getIsarc();
		return init;
	}

	public Record() {

	}

	public Record(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new RecordDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new RecordDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new RecordDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new RecordDao().deleteRecordById();
	}
	
	public void arc() {
		new RecordDao().arc(this);
	}
	
	public void unarc() {
		new RecordDao().unarc(this);
	}
}
