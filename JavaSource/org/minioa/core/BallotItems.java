package org.minioa.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.jboss.seam.ui.*;

public class BallotItems {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */

	private int ID_, CID_, MID_;
	private String CDATE, MDATE, MUSER;
	private java.util.Date CDATE_, MDATE_;
	private String UUID_, init;
	public static SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

	public void setMUSER(String data) {
		MUSER = data;
	}

	public String getMUSER() {
		return MUSER;
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

	public String getInit() {
		selectRecordById();
		return init;
	}

	private int headerId;

	public void setHeaderId(Integer data) {
		headerId = data;
	}

	public Integer getHeaderId() {
		return headerId;
	}

	@NotEmpty
	@Length(min = 2, max = 64)
	private String title;

	public void setTitle(String data) {
		title = data;
	}

	public String getTitle() {
		return title;
	}

	private int orderNum;

	public void setOrderNum(Integer data) {
		orderNum = data;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	private List<BallotItems> items;

	public List<BallotItems> getItems() {
		if (items == null)
			buildItems();
		return items;
	}

	public Lang lang;

	public Lang getLang() {
		if (lang == null)
			lang = (Lang) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Lang");
		if (lang == null)
			FunctionLib.redirect(FunctionLib.getWebAppName());
		return lang;
	}

	public MySession mySession;

	public MySession getMySession() {
		if (mySession == null)
			mySession = (MySession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MySession");
		if(null == mySession)
			return null;
		if(!"true".equals(mySession.getIsLogin()))
			return null;
		return mySession;
	}

	private Session session;

	private Session getSession() {
		if (session == null)
			session = new HibernateEntityLoader().getSession();
		return session;
	}

	public BallotItems() {
	}

	/**
	 * 构造函数，用于创建items
	 * 
	 * @param id
	 * @param cId
	 * @param cDate
	 * @param mId
	 * @param mDate
	 * @param uuid
	 * @param hId
	 * @param t
	 * @param o
	 */
	public BallotItems(int id, int cId, String cDate, int mId, String mDate, String uuid, int hId, String t, int o, String m) {
		setID_(id);
		setCID_(cId);
		setCDATE(cDate);
		setMID_(mId);
		setMDATE(mDate);
		setUUID_(uuid);
		setHeaderId(hId);
		setTitle(t);
		setOrderNum(o);
		setMUSER(m);
	}

	/**
	 * 初始化变量
	 */
	public void reset() {
		ID_ = CID_ = MID_ = 0;
		CDATE = MDATE = UUID_ = "";
		CDATE_ = MDATE_ = null;
		title = MUSER = "";
		headerId = orderNum = 0;
	}

	/**
	 * 将全部记录加入列表
	 */
	public void buildItems() {
		try {
			if(null == getMySession())
				return;
			items = new ArrayList<BallotItems>();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String hId = (String) params.get("headerId");
			if (!FunctionLib.isNum(hId))
				hId = getMySession().getTempStr().get("BallotItems.headerId");
			if (FunctionLib.isNum(hId)) {
				getMySession().getTempStr().put("BallotItems.headerId", hId);

				Query query = getSession().getNamedQuery("core.ballot.items.records");
				query.setParameter("headerId", hId);

				Iterator<?> it = query.list().iterator();
				int id, cId, mId;
				String cDate, mDate, uuid;
				String t;
				int o;
				String hasOp = "false";
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					id = cId = mId = 0;
					cDate = mDate = uuid = "";
					t = "";
					o = 0;
					id = FunctionLib.getInt(obj[0]);
					cId = FunctionLib.getInt(obj[1]);
					cDate = FunctionLib.getDateTimeString(obj[2]);
					mId = FunctionLib.getInt(obj[3]);
					mDate = FunctionLib.getDateTimeString(obj[4]);
					t = FunctionLib.getString(obj[7]);
					o = FunctionLib.getInt(obj[8]);
					items.add(new BallotItems(id, cId, cDate, mId, mDate, uuid, Integer.valueOf(hId), t, o, FunctionLib.getString(obj[9])));
					if (mId == getMySession().getUserId() && o == 0)
						hasOp = "true";
				}
				it = null;
				getMySession().getTempStr().put("BallotItems.hasOp", hasOp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 读取一条记录
	 */
	public void selectRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			Query query = getSession().getNamedQuery("core.ballot.items.getrecordbyid");
			query.setParameter("id", id);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				this.reset();
				Object obj[] = (Object[]) it.next();
				ID_ = FunctionLib.getInt(obj[0]);
				CID_ = FunctionLib.getInt(obj[1]);
				CDATE = FunctionLib.getDateTimeString(obj[2]);
				MID_ = FunctionLib.getInt(obj[3]);
				MDATE = FunctionLib.getDateTimeString(obj[4]);
				headerId = FunctionLib.getInt(obj[6]);
				title = FunctionLib.getString(obj[7]);
				orderNum = FunctionLib.getInt(obj[8]);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 新增一条记录，注意这里没有使用到insert语句，这是hibernate的特点
	 */
	public void newRecord() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String hId = (String) params.get("headerId");
			if (FunctionLib.isNum(hId)) {
				getMySession().getTempStr().put("BallotItems.headerId", (String) params.get("headerId"));

				BallotItems bean = new BallotItems();
				bean.setHeaderId(Integer.valueOf(hId));
				bean.setTitle(title);
				bean.setOrderNum(orderNum);
				bean.setCID_(getMySession().getUserId());
				bean.setCDATE_(new java.util.Date());
				bean.setMID_(MID_);
				getSession().save(bean);
				bean = null;
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");

			Query query = getSession().getNamedQuery("core.ballot.items.updaterecordbyid");
			query.setParameter("mId", getMySession().getUserId());
			query.setParameter("title", title);
			query.setParameter("orderNum", orderNum);
			query.setParameter("id", id);
			query.executeUpdate();
			query = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	/**
	 * 删除一条记录
	 */
	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("BallotItems.id");
			Query query = getSession().getNamedQuery("core.ballot.items.deleterecordbyid");
			query.setParameter("id", id);
			query.executeUpdate();
			query = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			getMySession().getTempStr().put("BallotItems.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void ballot() {
		try {

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String hId = (String) params.get("headerId");
			Query query = getSession().getNamedQuery("core.ballot.items.records.count");
			query.setParameter("headerId", hId);
			int rowcount = Integer.valueOf(query.list().get(0).toString());
			//
			query = getSession().getNamedQuery("core.ballot.items.check");
			query.setParameter("headerId", hId);
			query.setParameter("mId", getMySession().getUserId());
			ID_ = FunctionLib.getInt(query.list().get(0));
			if(ID_ ==0){
				String msg = getLang().getProp().get(getMySession().getL()).get("ballotwaring");
				getMySession().setMsg(msg, 2);
				return;
			}
			boolean bool = true;
			while (bool) {
				Random random = new Random();
				int order = random.nextInt(rowcount) + 1;
				query = getSession().getNamedQuery("core.ballot.items.getordernum");
				query.setParameter("id", ID_);
				query.setParameter("orderNum", order);
				query.setParameter("headerId", hId);
				if ("0".equals(String.valueOf(query.list().get(0)))) {
					query = getSession().getNamedQuery("core.ballot.items.updaterecordbyid");
					query.setParameter("mId", getMySession().getUserId());
					query.setParameter("orderNum", order);
					query.setParameter("id", ID_);
					query.executeUpdate();
					break;
				}
			}
			query = getSession().getNamedQuery("core.ballot.items.completed");
			query.setParameter("headerId", hId);
			query.executeUpdate();
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
