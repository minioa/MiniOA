package org.minioa.crm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.minioa.core.FormDao;

public class Customer {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24
	 * 公司名称gongsimc，经营范围，行业（银行、证券、保险、企业）hangye，规模guimo，
	 * 法人代表kehubm，城市city，
	 * 地址dizhi，邮编youbian，电话dianhua，传真chuanzhen，邮件youjian，网址wangzhi
	 * ，备注beizhu，存档isarc
	 * 客户编码（建议最好帮忙设定个规则）kehubm、客户全称gongsimc、省份shengfen、区市city、行业、
	 * 规模、年营业额nianyingye、地址、第二地址dizhi2、网址、邮编、电话、传真、邮箱、 预留两个自定义zidingyi
	 * zidingyi2、备注 kehuly 客户来源：网站搜索、朋友介绍、广告、公司资源分配
	 * 
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
	
	private String gongsimc, shengfen, hangye, guimo, kehubm, city, dizhi,dizhi2, zidingyi, zidingyi2,kehulb, youbian, dianhua, chuanzhen, youjian, wangzhi, beizhu, isarc, kehuly;

	public void setGongsimc(String data) {
		gongsimc = data;
	}

	public String getGongsimc() {
		return gongsimc;
	}

	public void setShengfen(String data) {
		shengfen = data;
	}

	public String getShengfen() {
		return shengfen;
	}

	public void setHangye(String data) {
		hangye = data;
	}

	public String getHangye() {
		return hangye;
	}

	public void setGuimo(String data) {
		guimo = data;
	}

	public String getGuimo() {
		return guimo;
	}

	public void setKehubm(String data) {
		kehubm = data;
	}

	public String getKehubm() {
		return kehubm;
	}

	public void setCity(String data) {
		city = data;
	}

	public String getCity() {
		return city;
	}

	public void setDizhi(String data) {
		dizhi = data;
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setYoubian(String data) {
		youbian = data;
	}

	public String getYoubian() {
		return youbian;
	}

	public void setDianhua(String data) {
		dianhua = data;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setChuanzhen(String data) {
		chuanzhen = data;
	}

	public String getChuanzhen() {
		return chuanzhen;
	}

	public void setYoujian(String data) {
		youjian = data;
	}

	public String getYoujian() {
		return youjian;
	}

	public void setWangzhi(String data) {
		wangzhi = data;
	}

	public String getWangzhi() {
		return wangzhi;
	}

	public void setBeizhu(String data) {
		beizhu = data;
	}

	public String getBeizhu() {
		return beizhu;
	}
	
	public void setDizhi2(String data) {
		dizhi2 = data;
	}

	public String getDizhi2() {
		return dizhi2;
	}
	
	public void setZidingyi(String data) {
		zidingyi = data;
	}

	public String getZidingyi() {
		return zidingyi;
	}
	
	public void setZidingyi2(String data) {
		zidingyi2 = data;
	}

	public String getZidingyi2() {
		return zidingyi2;
	}

	public void setKehulb(String data) {
		kehulb = data;
	}

	public String getKehulb() {
		return kehulb;
	}
	public void setIsarc(String data) {
		isarc = data;
	}

	public String getIsarc() {
		return isarc;
	}
	
	private Integer nianyingye;
	
	public void setNianyingye(Integer data) {
		nianyingye = data;
	}

	public Integer getNianyingye() {
		return nianyingye;
	}
	
	public void setKehuly(String data) {
		kehuly = data;
	}

	public String getKehuly() {
		return kehuly;
	}

	private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new CustomerDao().buildDsList();
		}
		return dsList;
	}

	private List<Customer> items;

	public List<Customer> getItems() {
		if (items == null)
			items = new CustomerDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Customer bean = new CustomerDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.gongsimc = bean.getGongsimc();
		this.shengfen = bean.getShengfen();
		this.hangye = bean.getHangye();
		this.guimo = bean.getGuimo();
		this.kehubm = bean.getKehubm();
		this.city = bean.getCity();
		this.dizhi = bean.getDizhi();
		this.youbian = bean.getYoubian();
		this.dianhua = bean.getDianhua();
		this.chuanzhen = bean.getChuanzhen();
		this.youjian = bean.getYoujian();
		this.wangzhi = bean.getWangzhi();
		this.beizhu = bean.getBeizhu();
		this.isarc = bean.getIsarc();
		this.dizhi2 = bean.getDizhi2();
		this.zidingyi = bean.getZidingyi();
		this.zidingyi2 = bean.getZidingyi2();
		this.kehulb = bean.getKehulb();
		this.nianyingye = bean.getNianyingye();
		this.kehuly = bean.getKehuly();
		return init;
	}


	private Map<String, String> prop;

	public void setProp(Map<String, String> data) {
		prop = data;
	}

	public Map<String, String> getProp() {
		if (prop == null)
			prop = new HashMap<String, String>();
		return prop;
	}
	
	public Customer() {

	}
	
	public Customer(Map<String, String> data) {
		setProp(data);
	}
	
	public Customer(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new CustomerDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new CustomerDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new CustomerDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new CustomerDao().deleteRecordById();
	}

	public void arc() {
		new CustomerDao().arc(this);
	}

	public void unarc() {
		new CustomerDao().unarc(this);
	}
}
