package org.minioa.core;

import java.util.List;
import org.minioa.core.EqTestDao;

public class EqTest {
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

	private String itemname;

	public void setItemname(String data) {
		itemname = data;
	}

	public String getItemname() {
		return itemname;
	}

	private String itemcode;

	public void setItemcode(String data) {
		itemcode = data;
	}

	public String getItemcode() {
		return itemcode;
	}

	private java.lang.Float quantity;

	public void setQuantity(java.lang.Float data) {
		quantity = data;
	}

	public java.lang.Float getQuantity() {
		return quantity;
	}

    private List<Integer> dsList;

	public List<Integer> getDsList() {
		if (dsList == null) {
			dsList = new EqTestDao().buildDsList();
		}
		return dsList;
	}
 	private List<EqTest> items;
	public List<EqTest> getItems() {
		if (items == null)
			items = new EqTestDao().buildItems();
		return items;
	}
	private String init;

	public String getInit() {
		EqTest bean = new EqTestDao().selectRecordById();
		this.ID_ = bean.getID_();
		this.CID_ = bean.getCID_();
		this.CDATE_ = bean.getCDATE_();
		this.MID_ = bean.getMID_();
		this.MDATE_ = bean.getMDATE_();
		this.itemname = bean.getItemname();
		this.itemcode = bean.getItemcode();
		this.quantity = bean.getQuantity();
		this.itemcode = bean.getItemcode();
		this.itemname = bean.getItemname();
		this.quantity = bean.getQuantity();
		return init;
	}
	public EqTest() {

	}

	public EqTest(int size) {

	}

	public void buildItems() {
		items = new EqTestDao().buildItems();
	}

	public void newRecord() {
		new EqTestDao().newRecord(this);
	}

	public void updateRecordById() {
		new EqTestDao().updateRecordById(this);
	}

	public void deleteRecordById() {
		new EqTestDao().deleteRecordById();
	}
}
