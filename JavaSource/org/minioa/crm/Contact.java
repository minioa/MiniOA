package org.minioa.crm;

import java.util.List;
import org.minioa.core.FormDao;

public class Contact {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2012-3-24
	 * 姓名xingming、称呼chenghu、职位zhiwei
	 * 年龄bumen、固定电话gudingdh、移动电话yidongdh、兴趣xingqu
	 * QQ、MSN、邮件youjian、个人主页nickname、备注beizhu、存档isarc
	 * 
	 * 姓名、昵称nickname、性别、部门bumen、生日shengri（带下拉菜单可选日期）、
	 * 联系等级lianxidj（一般、重要、非常重要）、职位、职责zhize、
	 * 角色作用juesezy（执行者、建议者、决策者、核心决策者）、办公电话、传真chuanzhen、手机、宅电zhaidian、邮件、
	 * QQ、MSN、兴趣、籍贯jiguan、婚否hunfou、毕业院校biyeyx、办公地址dizhi、备注。
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

	private java.util.Date birthday;
	public void setBirthday(java.util.Date data) {
		birthday = data;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}
	
	
	private String chuanzhen, lianxidj, zhize, juesezy, jiguan, zhaidian, hunfou, biyeyx,dizhi,xingming, chenghu, zhiwei, bumen, gudingdh, yidongdh, xingqu, qq, msn, youjian, nickname, beizhu, isarc;

	public void setChuanzhen(String data) {
		chuanzhen = data;
	}

	public String getChuanzhen() {
		return chuanzhen;
	}
	public void setLianxidj(String data) {
		lianxidj = data;
	}

	public String getLianxidj() {
		return lianxidj;
	}
	
	public void setZhize(String data) {
		zhize = data;
	}

	public String getZhize() {
		return zhize;
	}
	
	public void setJuesezy(String data) {
		juesezy = data;
	}

	public String getJuesezy() {
		return juesezy;
	}
	
	public void setJiguan(String data) {
		jiguan = data;
	}

	public String getJiguan() {
		return jiguan;
	}
	
	
	public void setZhaidian(String data) {
		zhaidian = data;
	}

	public String getZhaidian() {
		return zhaidian;
	}
	
	public void setHunfou(String data) {
		hunfou = data;
	}

	public String getHunfou() {
		return hunfou;
	}
	
	public void setBiyeyx(String data) {
		biyeyx = data;
	}

	public String getBiyeyx() {
		return biyeyx;
	}
	
	public void setDizhi(String data) {
		dizhi = data;
	}

	public String getDizhi() {
		return dizhi;
	}
	
	public void setXingming(String data) {
		xingming = data;
	}

	public String getXingming() {
		return xingming;
	}

	public void setChenghu(String data) {
		chenghu = data;
	}

	public String getChenghu() {
		return chenghu;
	}

	public void setZhiwei(String data) {
		zhiwei = data;
	}

	public String getZhiwei() {
		return zhiwei;
	}

	public void setBumen(String data) {
		bumen = data;
	}

	public String getBumen() {
		return bumen;
	}

	public void setGudingdh(String data) {
		gudingdh = data;
	}

	public String getGudingdh() {
		return gudingdh;
	}

	public void setYidongdh(String data) {
		yidongdh = data;
	}

	public String getYidongdh() {
		return yidongdh;
	}

	public void setXingqu(String data) {
		xingqu = data;
	}

	public String getXingqu() {
		return xingqu;
	}

	public void setQq(String data) {
		qq = data;
	}

	public String getQq() {
		return qq;
	}

	public void setMsn(String data) {
		msn = data;
	}

	public String getMsn() {
		return msn;
	}

	public void setNickname(String data) {
		nickname = data;
	}

	public String getNickname() {
		return nickname;
	}

	public void setYoujian(String data) {
		youjian = data;
	}

	public String getYoujian() {
		return youjian;
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
	
	private String CUSER;
	
	public void setCUSER(String data) {
		CUSER = data;
	}

	public String getCUSER() {
		return CUSER;
	}

	private List<Contact> items;

	public List<Contact> getItems() {
		if (items == null)
			items = new ContactDao().buildItems();
		return items;
	}

	private String init;

	public String getInit() {
		Contact bean = new ContactDao().selectRecordById();
		if (bean == null)
			return "";
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.UUID_ = bean.getUUID_();
		this.CUSER = bean.getCUSER();
		this.xingming = bean.getXingming();
		this.chenghu = bean.getChenghu();
		this.zhiwei = bean.getZhiwei();
		this.bumen = bean.getBumen();
		this.gudingdh = bean.getGudingdh();
		this.yidongdh = bean.getYidongdh();
		this.xingqu = bean.getXingqu();
		this.qq = bean.getQq();
		this.msn = bean.getMsn();
		this.nickname = bean.getNickname();
		this.youjian = bean.getYoujian();
		this.beizhu = bean.getBeizhu();
		this.isarc = bean.getIsarc();
		this.birthday = bean.getBirthday();
		this.lianxidj = bean.getLianxidj();
		this.zhize = bean.getZhize();
		this.juesezy = bean.getJuesezy();
		this.zhaidian = bean.getZhaidian();
		this.jiguan = bean.getJiguan();
		this.hunfou = bean.getHunfou();
		this.biyeyx = bean.getBiyeyx();
		this.dizhi = bean.getDizhi();
		this.chuanzhen = bean.getChuanzhen();
		return init;
	}

	public Contact() {

	}

	public Contact(int size) {

	}

	/**
	 * 记录表
	 */
	public void buildItems() {
		items = new ContactDao().buildItems();
	}

	/**
	 * 新增记录
	 */
	public void newRecord() {
		new ContactDao().newRecord(this);
	}

	/**
	 * 修改一条记录
	 */
	public void updateRecordById() {
		new ContactDao().updateRecordById(this);
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		new ContactDao().deleteRecordById();
	}
	public void arc() {
		new ContactDao().arc(this);
	}
	
	public void unarc() {
		new ContactDao().unarc(this);
	}
}
