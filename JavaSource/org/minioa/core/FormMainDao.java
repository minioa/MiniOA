package org.minioa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FormMain;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

public class FormMainDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-05
	 */
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

	public FormMainDao() {
	}

	public List<Integer> buildDsList() {
		if(null == getMySession())
			return null;
		List<Integer> dsList = new ArrayList<Integer>();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String itemId = (String) params.get("itemId");
			String fieldsText = (String) params.get("fieldsText");
			String fieldsDate = (String) params.get("fieldsDate");
			if (!FunctionLib.isNum(formId))
				return null;

			// 获取搜索关键词
			String[] textNames = {};
			String[] textValues = {};
			String[] dateNames = {};
			ArrayList<java.util.Date> dateValues = new ArrayList<java.util.Date>();
			if (fieldsText != null && !"".equals(fieldsText) && mySession.getTempStr() != null) {
				textNames = fieldsText.split(",");
				textValues = new String[textNames.length];
				for (int i = 0; i < textNames.length; i++) {
					if (!"".equals(mySession.getTempStr().get("FormMain." + textNames[i])))
						textValues[i] = mySession.getTempStr().get("FormMain." + textNames[i]).toString();
					else
						textValues[i] = "";
				}
			}
			if (fieldsDate != null && !"".equals(fieldsDate) && mySession.getTempDate() != null) {
				dateNames = fieldsDate.split(",");
				for (int i = 0; i < dateNames.length; i++) {
					if (mySession.getTempDate().get("FormMain." + dateNames[i]) != null)
						dateValues.add(mySession.getTempDate().get("FormMain." + dateNames[i]));
					else
						dateValues.add(null);
				}
			}

			String sql = getSession().getNamedQuery("core.form.main.items.count").getQueryString();
			String where = "";

			boolean isAdmin = mySession.getHasOp().get("form." + formId + ".admin");
			FormDao formDao = new FormDao();
			Form form = (Form) formDao.selectRecordById(Integer.valueOf(formId));
			// 权限判断
			if (!isAdmin){
				switch (Integer.valueOf(form.getOpRead())) {
				case 6:
					break;
				case 5:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1 or core_iscolleague_f(ta.CID_,:userId)=1)";
					break;
				case 4:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1 or core_iscolleague_f(ta.CID_,:userId)=1)";
					break;
				case 3:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1)";
					break;
				case 2:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1)";
					break;
				case 1:
					where += " and ta.CID_ = :userId";
					break;
				default:
					where += " and ta.CID_ = :userId";
				}
			}

			// 构造搜索sql
			if (textNames.length > 0) {
				for (int i = 0; i < textNames.length; i++) {
					if (!"".equals(textValues[i])) {
						where += " and ta." + textNames[i] + " like :" + textNames[i];
					}
				}
			}
			if (dateNames.length > 0) {
				for (int i = 0; i < dateNames.length; i = i + 2) {
					if (dateValues.get(i) != null) {
						where += " and ta." + dateNames[i] + " between :" + dateNames[i] + " and :" + dateNames[i + 1];
					}
				}
			}

			if (FunctionLib.isNum(itemId))
				where += " and ta.ID_ = " + itemId;
			//System.out.println(sql + where);
			Query query = getSession().createSQLQuery(sql + where);
			query.setParameter("formId", formId);
			if (where.indexOf(":userId") > 0)
				query.setParameter("userId", getMySession().getUserId());
			// 设置搜索参数的值
			if (textNames.length > 0) {
				for (int i = 0; i < textNames.length; i++) {
					if (!"".equals(textValues[i]))
						query.setParameter(textNames[i], "%" + textValues[i] + "%");
				}
			}
			if (dateNames.length > 0) {
				for (int i = 0; i < dateNames.length; i = i + 2) {
					if (dateValues.get(i) != null) {
						query.setParameter(dateNames[i], dateValues.get(i));
						query.setParameter(dateNames[i + 1], dateValues.get(i + 1));

					}
				}
			}

			int tc = Integer.valueOf(String.valueOf(query.list().get(0)));
			for (int i = 0; i < tc; i++)
				dsList.add(i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mySession.setRowCount(dsList.size());
		return dsList;
	}

	public ArrayList<FormMain> buildItems() {
		ArrayList<FormMain> items = new ArrayList<FormMain>();
		try {
			if(null == getMySession())
				return null;
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String itemId = (String) params.get("itemId");
			String fieldsText = (String) params.get("fieldsText");
			String fieldsDate = (String) params.get("fieldsDate");
			if (!FunctionLib.isNum(formId))
				return null;
			// 判断reload参数，是否填充空列表
			if ("false".equals((String) params.get("reload"))) {
				for (int i = 0; i < mySession.getPageSize(); i++)
					items.add(new FormMain());
				return items;
			}
			// 设置第一页
			if ("true".equals((String) params.get("resetPageNo")))
				mySession.setScrollerPage(1);
			// 获取搜索关键词
			String[] textNames = {};
			String[] textValues = {};
			String[] dateNames = {};
			ArrayList<java.util.Date> dateValues = new ArrayList<java.util.Date>();
			if (fieldsText != null && !"".equals(fieldsText) && mySession.getTempStr() != null) {
				textNames = fieldsText.split(",");
				textValues = new String[textNames.length];
				for (int i = 0; i < textNames.length; i++) {
					if (!"".equals(mySession.getTempStr().get("FormMain." + textNames[i])))
						textValues[i] = mySession.getTempStr().get("FormMain." + textNames[i]).toString();
					else
						textValues[i] = "";
				}
			}
			if (fieldsDate != null && !"".equals(fieldsDate) && mySession.getTempDate() != null) {
				dateNames = fieldsDate.split(",");
				for (int i = 0; i < dateNames.length; i++) {
					if (mySession.getTempDate().get("FormMain." + dateNames[i]) != null)
						dateValues.add(mySession.getTempDate().get("FormMain." + dateNames[i]));
					else
						dateValues.add(null);
				}
			}

			items = new ArrayList<FormMain>();
			String sql = getSession().getNamedQuery("core.form.main.items").getQueryString();
			String where = "";

			int userId = getMySession().getUserId();
			boolean isAdmin = mySession.getHasOp().get("form." + formId + ".admin");
			FormDao formDao = new FormDao();
			Form form = (Form) formDao.selectRecordById(Integer.valueOf(formId));
			String opEdit = form.getOpEdit();
			// 权限判断
			if (!isAdmin){
				switch (Integer.valueOf(form.getOpRead())) {
				case 6:
					break;
				case 5:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1 or core_iscolleague_f(ta.CID_,:userId)=1)";
					break;
				case 4:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1 or core_iscolleague_f(ta.CID_,:userId)=1)";
					break;
				case 3:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1)";
					break;
				case 2:
					where += " and (ta.CID_ = :userId or core_issuperior_f(ta.CID_,:userId)=1)";
					break;
				case 1:
					where += " and ta.CID_ = :userId";
					break;
				default:
					where += " and ta.CID_ = :userId";
				}
			}
			
			// 构造搜索sql
			if (textNames.length > 0) {
				for (int i = 0; i < textNames.length; i++) {
					if (!"".equals(textValues[i])) {
						where += " and ta." + textNames[i] + " like :" + textNames[i];
					}
				}
			}
			if (dateNames.length > 0) {
				for (int i = 0; i < dateNames.length; i = i + 2) {
					if (dateValues.get(i) != null) {
						where += " and ta." + dateNames[i] + " between :" + dateNames[i] + " and :" + dateNames[i + 1];
					}
				}
			}

			if (FunctionLib.isNum(itemId))
				where += " and ta.ID_ = " + itemId;
			//System.out.println(sql + where + " order by ta.ID_ desc, tc.ID_ desc");
			Query query = getSession().createSQLQuery(sql + where + " order by ta.ID_ desc, tc.ID_ desc");
			query.setParameter("formId", formId);
			if (where.indexOf(":userId") > 0)
				query.setParameter("userId", getMySession().getUserId());
			// 设置搜索参数的值
			if (textNames.length > 0) {
				for (int i = 0; i < textNames.length; i++) {
					if (!"".equals(textValues[i]))
						query.setParameter(textNames[i], "%" + textValues[i] + "%");
				}
			}
			if (dateNames.length > 0) {
				for (int i = 0; i < dateNames.length; i = i + 2) {
					if (dateValues.get(i) != null) {
						query.setParameter(dateNames[i], dateValues.get(i));
						query.setParameter(dateNames[i + 1], dateValues.get(i + 1));

					}
				}
			}

			query.setMaxResults(mySession.getPageSize());
			query.setFirstResult((Integer.valueOf(mySession.getScrollerPage()) - 1) * mySession.getPageSize());
			Iterator<?> it = query.list().iterator();
			// 避免因多次提交流程而导致记录的重复
			FormMain bean;
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				bean = new FormMain();
				bean.setID_(FunctionLib.getInt(obj[0]));
				bean.setCID_(FunctionLib.getInt(obj[1]));
				bean.setCDATE(FunctionLib.getDateTimeString(obj[2]));
				bean.setMID_(FunctionLib.getInt(obj[3]));
				bean.setMDATE(FunctionLib.getDateTimeString(obj[4]));
				bean.setUUID_(FunctionLib.getString(obj[5]));
				bean.setFormId(FunctionLib.getInt(obj[6]));
				bean.setField(FunctionLib.getString(obj[7]));
				bean.setField2(FunctionLib.getString(obj[8]));
				bean.setField3(FunctionLib.getString(obj[9]));
				bean.setField4(FunctionLib.getString(obj[10]));
				bean.setField5(FunctionLib.getString(obj[11]));
				bean.setField6(FunctionLib.getString(obj[12]));
				bean.setField7(FunctionLib.getString(obj[13]));
				bean.setField8(FunctionLib.getString(obj[14]));
				bean.setField9(FunctionLib.getString(obj[15]));
				bean.setField10(FunctionLib.getString(obj[16]));
				bean.setField11(FunctionLib.getInt(obj[17]));
				bean.setField12(FunctionLib.getInt(obj[18]));
				bean.setField13(FunctionLib.getInt(obj[19]));
				bean.setField14(FunctionLib.getInt(obj[20]));
				bean.setField15(FunctionLib.getInt(obj[21]));
				bean.setField16(FunctionLib.getDouble(obj[22]));
				bean.setField17(FunctionLib.getDouble(obj[23]));
				bean.setField18(FunctionLib.getDouble(obj[24]));
				bean.setField19(FunctionLib.getDouble(obj[25]));
				bean.setField20(FunctionLib.getDouble(obj[26]));
				bean.setField21(FunctionLib.getString(obj[27]));
				bean.setField22(FunctionLib.getString(obj[28]));
				bean.setField23(FunctionLib.getString(obj[29]));
				bean.setField24(FunctionLib.getString(obj[30]));
				bean.setField25(FunctionLib.getString(obj[31]));
				bean.setField26(FunctionLib.getDate(obj[32]));
				bean.setField27(FunctionLib.getDate(obj[33]));
				bean.setField28(FunctionLib.getDate(obj[34]));
				bean.setField29(FunctionLib.getDate(obj[35]));
				bean.setField30(FunctionLib.getDate(obj[36]));
				bean.setField31(FunctionLib.getString(obj[37]));
				bean.setField32(FunctionLib.getString(obj[38]));
				// 流程id
				bean.setProcessDefId(FunctionLib.getInt(obj[39]));
				// 流程Id
				bean.setProcessId(FunctionLib.getInt(obj[40]));
				// 流程状态
				bean.setProcessStatus(FunctionLib.getProcessStatusText(FunctionLib.getString(obj[41])));
				// 创建人
				bean.setCUSER(FunctionLib.getString(obj[42]));
				// 修改人
				bean.setMUSER(FunctionLib.getString(obj[43]));
				items.add(bean);
				boolean op = hasOpEdit(getSession(), bean.getFormId(), opEdit, isAdmin, bean.getCID_(), userId);
				getMySession().getTempBoolean().put("FormMain_" + bean.getID_(), op);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<FormMain> download() {
		ArrayList<FormMain> items = new ArrayList<FormMain>();
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String itemId = (String) params.get("itemId");
			String viewId = (String) params.get("viewId");
			String fieldsText = (String) params.get("fieldsText");
			String fieldsDate = (String) params.get("fieldsDate");
			if (!FunctionLib.isNum(formId))
				return null;
			// 读取Form基本信息
			int userId = getMySession().getUserId();
			boolean isAdmin = mySession.getHasOp().get("form." + formId + ".admin");
			FormDao formDao = new FormDao();
			Form form = (Form) formDao.selectRecordById(Integer.valueOf(formId));

			// 创建下载文件
			String s = FunctionLib.getSeparator();
			String storedir = FunctionLib.getBaseDir() + "temp" + s + "download" + s;
			if (FunctionLib.isDirExists(storedir)) {
				File file = new File(storedir + form.getFormName() + ".xls");
				if (file.exists())
					file.delete();
				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(file);
				jxl.write.WritableSheet ws = wwb.createSheet("data", 0);

				jxl.write.Label label;
				jxl.write.Number number;
				jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##");
				jxl.write.WritableCellFormat wcNf = new jxl.write.WritableCellFormat(nf);
				// 读取当前视图的字段信息
				Query query = getSession().getNamedQuery("core.form.view.field.items");
				query.setParameter("formId", formId);
				query.setParameter("viewId", viewId);
				query.setParameter("tableOrEdit", "0");
				Iterator<?> it = query.list().iterator();
				label = new jxl.write.Label(0, 0, "id");
				ws.addCell(label);
				int n = 1;
				ArrayList<String> fieldsArr = new ArrayList<String>();
				fieldsArr.add("ID_");
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					FormViewField bean = new FormViewField();
					bean.setFieldId(FunctionLib.getInt(obj[0]));
					bean.setFieldText(FunctionLib.getString(obj[1]));
					bean.setFieldName(FunctionLib.getString(obj[2]));
					bean.setFieldType(FunctionLib.getString(obj[3]));
					bean.setIsShow(FunctionLib.getString(obj[5]));
					if ("Y".equals(bean.getIsShow())) {
						fieldsArr.add(bean.getFieldName());
						label = new jxl.write.Label(n, 0, bean.getFieldText());
						ws.addCell(label);
						n++;
					}
				}
				// 获取记录
				// 获取搜索关键词
				String[] textNames = {};
				String[] textValues = {};
				String[] dateNames = {};
				ArrayList<java.util.Date> dateValues = new ArrayList<java.util.Date>();
				if (fieldsText != null && !"".equals(fieldsText) && mySession.getTempStr() != null) {
					textNames = fieldsText.split(",");
					textValues = new String[textNames.length];
					for (int i = 0; i < textNames.length; i++) {
						if (!"".equals(mySession.getTempStr().get("FormMain." + textNames[i])))
							textValues[i] = mySession.getTempStr().get("FormMain." + textNames[i]).toString();
						else
							textValues[i] = "";
					}
				}
				if (fieldsDate != null && !"".equals(fieldsDate) && mySession.getTempDate() != null) {
					dateNames = fieldsDate.split(",");
					for (int i = 0; i < dateNames.length; i++) {
						if (mySession.getTempDate().get("FormMain." + dateNames[i]) != null)
							dateValues.add(mySession.getTempDate().get("FormMain." + dateNames[i]));
						else
							dateValues.add(null);
					}
				}

				items = new ArrayList<FormMain>();
				String sql = getSession().getNamedQuery("core.form.main.items").getQueryString();
				String where = "";
				// 权限判断
				switch (Integer.valueOf(form.getOpRead())) {
				case 6:
					break;
				case 5:
					if (!isAdmin)
						where += " and (ta.CID_ = :userId or core_issuperior(ta.CID_,:userId,10)=1 or core_iscolleague(ta.CID_,:userId,10)=1)";
					break;
				case 4:
					if (!isAdmin)
						where += " and (ta.CID_ = :userId or core_issuperior(ta.CID_,:userId,10)=1 or core_iscolleague(ta.CID_,:userId,1)=1)";
					break;
				case 3:
					if (!isAdmin)
						where += " and (ta.CID_ = :userId or core_issuperior(ta.CID_,:userId,10)=1)";
					break;
				case 2:
					if (!isAdmin)
						where += " and (ta.CID_ = :userId or core_issuperior(ta.CID_,:userId,1)=1)";
					break;
				case 1:
					if (!isAdmin)
						where += " and ta.CID_ = :userId";
					break;
				default:
					where += " and ta.CID_ = :userId";
				}
				// 构造搜索sql
				if (textNames.length > 0) {
					for (int i = 0; i < textNames.length; i++) {
						if (!"".equals(textValues[i])) {
							where += " and ta." + textNames[i] + " like :" + textNames[i];
						}
					}
				}
				if (dateNames.length > 0) {
					for (int i = 0; i < dateNames.length; i = i + 2) {
						if (dateValues.get(i) != null) {
							where += " and ta." + dateNames[i] + " between :" + dateNames[i] + " and :" + dateNames[i + 1];
						}
					}
				}

				if (FunctionLib.isNum(itemId))
					where += " and ta.ID_ = " + itemId;

				query = getSession().createSQLQuery(sql + where + " order by ta.ID_ desc, tc.ID_ desc");
				query.setParameter("formId", formId);
				if (where.indexOf(":userId") > 0)
					query.setParameter("userId", getMySession().getUserId());
				// 设置搜索参数的值
				if (textNames.length > 0) {
					for (int i = 0; i < textNames.length; i++) {
						if (!"".equals(textValues[i]))
							query.setParameter(textNames[i], "%" + textValues[i] + "%");
					}
				}
				if (dateNames.length > 0) {
					for (int i = 0; i < dateNames.length; i = i + 2) {
						if (dateValues.get(i) != null) {
							query.setParameter(dateNames[i], dateValues.get(i));
							query.setParameter(dateNames[i + 1], dateValues.get(i + 1));

						}
					}
				}

				it = query.list().iterator();
				FormMain bean;
				int m = 1;
				int id = 0;
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					bean = new FormMain();
					bean.setID_(FunctionLib.getInt(obj[0]));
					bean.setCID_(FunctionLib.getInt(obj[1]));
					bean.setCDATE(FunctionLib.getDateTimeString(obj[2]));
					bean.setMID_(FunctionLib.getInt(obj[3]));
					bean.setMDATE(FunctionLib.getDateTimeString(obj[4]));
					bean.setUUID_(FunctionLib.getString(obj[5]));
					bean.setFormId(FunctionLib.getInt(obj[6]));
					bean.setField(FunctionLib.getString(obj[7]));
					bean.setField2(FunctionLib.getString(obj[8]));
					bean.setField3(FunctionLib.getString(obj[9]));
					bean.setField4(FunctionLib.getString(obj[10]));
					bean.setField5(FunctionLib.getString(obj[11]));
					bean.setField6(FunctionLib.getString(obj[12]));
					bean.setField7(FunctionLib.getString(obj[13]));
					bean.setField8(FunctionLib.getString(obj[14]));
					bean.setField9(FunctionLib.getString(obj[15]));
					bean.setField10(FunctionLib.getString(obj[16]));
					bean.setField11(FunctionLib.getInt(obj[17]));
					bean.setField12(FunctionLib.getInt(obj[18]));
					bean.setField13(FunctionLib.getInt(obj[19]));
					bean.setField14(FunctionLib.getInt(obj[20]));
					bean.setField15(FunctionLib.getInt(obj[21]));
					bean.setField16(FunctionLib.getDouble(obj[22]));
					bean.setField17(FunctionLib.getDouble(obj[23]));
					bean.setField18(FunctionLib.getDouble(obj[24]));
					bean.setField19(FunctionLib.getDouble(obj[25]));
					bean.setField20(FunctionLib.getDouble(obj[26]));
					bean.setField21(FunctionLib.getString(obj[27]));
					bean.setField22(FunctionLib.getString(obj[28]));
					bean.setField23(FunctionLib.getString(obj[29]));
					bean.setField24(FunctionLib.getString(obj[30]));
					bean.setField25(FunctionLib.getString(obj[31]));
					bean.setField26(FunctionLib.getDate(obj[32]));
					bean.setField27(FunctionLib.getDate(obj[33]));
					bean.setField28(FunctionLib.getDate(obj[34]));
					bean.setField29(FunctionLib.getDate(obj[35]));
					bean.setField30(FunctionLib.getDate(obj[36]));
					bean.setField31(FunctionLib.getString(obj[37]));
					bean.setField32(FunctionLib.getString(obj[38]));
					if (id != bean.getID_()) {
						id = bean.getID_();
						for (int l = 0; l < fieldsArr.size(); l++) {
							if ("ID_".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, String.valueOf(bean.getID_()));
								ws.addCell(label);
							} else if ("field".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField());
								ws.addCell(label);
							} else if ("field2".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField2());
								ws.addCell(label);
							} else if ("field3".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField3());
								ws.addCell(label);
							} else if ("field4".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField4());
								ws.addCell(label);
							} else if ("field5".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField5());
								ws.addCell(label);
							} else if ("field6".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField6());
								ws.addCell(label);
							} else if ("field7".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField7());
								ws.addCell(label);
							} else if ("field8".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField8());
								ws.addCell(label);
							} else if ("field9".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField9());
								ws.addCell(label);
							} else if ("field10".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField10());
								ws.addCell(label);
							} else if ("field11".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField11(), wcNf);
								ws.addCell(number);
							} else if ("field12".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField12(), wcNf);
								ws.addCell(number);
							} else if ("field13".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField13(), wcNf);
								ws.addCell(number);
							} else if ("field14".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField14(), wcNf);
								ws.addCell(number);
							} else if ("field15".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField15(), wcNf);
								ws.addCell(number);
							} else if ("field16".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField16(), wcNf);
								ws.addCell(number);
							} else if ("field17".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField17(), wcNf);
								ws.addCell(number);
							} else if ("field18".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField18(), wcNf);
								ws.addCell(number);
							} else if ("field19".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField19(), wcNf);
								ws.addCell(number);
							} else if ("field20".equals(fieldsArr.get(l))) {
								number = new jxl.write.Number(l, m, bean.getField20(), wcNf);
								ws.addCell(number);
							} else if ("field21".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField21());
								ws.addCell(label);
							} else if ("field22".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField22());
								ws.addCell(label);
							} else if ("field23".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField23());
								ws.addCell(label);
							} else if ("field24".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField24());
								ws.addCell(label);
							} else if ("field25".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField25());
								ws.addCell(label);
							} else if ("field26".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, String.valueOf(bean.getField26()));
								ws.addCell(label);
							} else if ("field27".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, String.valueOf(bean.getField27()));
								ws.addCell(label);
							} else if ("field28".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, String.valueOf(bean.getField28()));
								ws.addCell(label);
							} else if ("field29".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, String.valueOf(bean.getField29()));
								ws.addCell(label);
							} else if ("field30".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, String.valueOf(bean.getField30()));
								ws.addCell(label);
							} else if ("field31".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField31());
								ws.addCell(label);
							} else if ("field32".equals(fieldsArr.get(l))) {
								label = new jxl.write.Label(l, m, bean.getField32());
								ws.addCell(label);
							} else
								;
						}
						m++;
					}
				}
				it = null;
				wwb.write();
				wwb.close();
				FunctionLib.download("temp" + s + "download" + s + file.getName(), form.getFormName() + ".xls", false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public FormMain selectRecordById() {
		FormMain bean = new FormMain();
		Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = (String) params.get("id");
		String formId = (String) params.get("formId");
		try {
			if (!FunctionLib.isNum(id)) {
				id = (String) params.get("FormMainId");
				if (!FunctionLib.isNum(id)){
					bean.setUUID_(java.util.UUID.randomUUID().toString());
					getMySession().getTempStr().put("FormMainAttachment.uuid", bean.getUUID_());
					getMySession().getTempStr().put("FormMainAttachment.formId", formId);
					return bean;
				}
			}
			Criteria criteria = getSession().createCriteria(FormMain.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext()) {
				bean = (FormMain) it.next();
			}
			if (bean != null) {
				FormDao formDao = new FormDao();
				Form form = (Form) formDao.selectRecordById(bean.getFormId());
				String opName = "form." + formId + ".admin";
				boolean op = false;
				if(getMySession().getHasOp().containsKey(opName))
					op = hasOpEdit(getSession(), bean.getFormId(), form.getOpEdit(), getMySession().getHasOp().get("form." + formId + ".admin"), bean.getCID_(), getMySession().getUserId());
				getMySession().getHasOp().put("form." + formId + ".edit", op);
			}
			if (null == bean.getUUID_() || "".equals(bean.getUUID_()))
				bean.setUUID_(java.util.UUID.randomUUID().toString());
			getMySession().getTempStr().put("FormMainAttachment.uuid", bean.getUUID_());
			getMySession().getTempStr().put("FormMainAttachment.formId", formId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public boolean hasOpEdit(Session s, int formId, String opEdit, boolean isAdmin, int cId, int userId) {
		try {
			// 权限判断
			// 0 仅创建者可修改
			// 1 仅创建者、管理员可修改
			// 2 仅创建者、创建者的直接上级可修改
			// 3 仅创建者、创建者的所有上级可修改
			// 4 仅创建者、创建者的同级部门同事可修改
			// 5 仅创建者、创建者的同级或上级部门同事可修改
			// 6 不限制
			switch (Integer.valueOf(opEdit)) {
			case 6:
				return true;
			case 5:
				if (isAdmin || userId == cId || FunctionLib.isSuperior(s, cId, userId, 10) == 1 || FunctionLib.isColleague(s, cId, userId, 10) == 1)
					return true;
				else
					return false;
			case 4:
				if (isAdmin || userId == cId || FunctionLib.isSuperior(s, cId, userId, 10) == 1 || FunctionLib.isColleague(s, cId, userId, 1) == 1)
					return true;
				else
					return false;
			case 3:
				if (isAdmin || userId == cId || FunctionLib.isSuperior(s, cId, userId, 10) == 1)
					return true;
				else
					return false;
			case 2:
				if (isAdmin || userId == cId || FunctionLib.isSuperior(s, cId, userId, 1) == 1)
					return true;
				else
					return false;
			case 1:
				if (isAdmin || userId == cId)
					return true;
				else
					return false;
			default:
				if (userId == cId)
					return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public void newRecord(FormMain bean) {
		try {
			String uuid = getMySession().getTempStr().get("FormMainAttachment.uuid");
			bean.setUUID_(uuid);
			bean.setCID_(getMySession().getUserId());
			bean.setCDATE_(new java.util.Date());
			bean.setIsArc("N");
			getSession().save(bean);
			bean = null;
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
			
			this.selectRecordById();
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(FormMain bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id)) {
				bean.setMID_(getMySession().getUserId());
				bean.setMDATE_(new java.util.Date());
				bean.setID_(Integer.valueOf(id));
				//System.out.println("bean.getUUID_()3:" + bean.getUUID_());
				if("Y".equals(bean.getIsArc())){
					getMySession().setMsg("对不起，已存档记录不允许修改!", 2);
					return;
				}else{
					FormDao formDao = new FormDao();
					Form form = (Form) formDao.selectRecordById(Integer.valueOf(bean.getFormId()));
					String opEdit = form.getOpEdit();
					boolean isAdmin = mySession.getHasOp().get("form." + bean.getFormId() + ".admin");
					if (hasOpEdit(getSession(), bean.getFormId(), opEdit, isAdmin, bean.getCID_(), getMySession().getUserId()))
						getSession().update(bean);
					else {
						getMySession().setMsg("对不起，您没有权限修改此记录!", 2);
						return;
					}
				}
			}
			String msg = getLang().getProp().get(getMySession().getL()).get("success");
			getMySession().setMsg(msg, 1);
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("FormMain.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(FormMain.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				FormMain bean;
				while (it.hasNext()) {
					bean = (FormMain) it.next();
					//判断是否已经存档
					if("N".equals(bean.getIsArc())){
						FormDao formDao = new FormDao();
						Form form = (Form) formDao.selectRecordById(Integer.valueOf(bean.getFormId()));
						String opEdit = form.getOpEdit();
						boolean isAdmin = mySession.getHasOp().get("form." + bean.getFormId() + ".admin");
						if (hasOpEdit(getSession(), bean.getFormId(), opEdit, isAdmin, bean.getCID_(), getMySession().getUserId())) {
							getSession().delete(bean);
							String msg = getLang().getProp().get(getMySession().getL()).get("success");
							getMySession().setMsg(msg, 1);
						} else {
							getMySession().setMsg("对不起，您没有权限删除此记录！", 2);
							return;
						}
					} else {
						getMySession().setMsg("对不起，已存档记录不允许删除！", 2);
						return;
					}
				}
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void showDialog() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			//System.out.println("(String) params.get(\"id\"):" + (String) params.get("id"));
			getMySession().getTempStr().put("FormMain.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
	
	public void importData(UploadEvent event) {
		try {
			String s = FunctionLib.getSeparator();
			String storedir = FunctionLib.getBaseDir() + "temp" + s + "import" + s;
			if (FunctionLib.isDirExists(storedir)) {
				String fileName = storedir + getMySession().getUserId()+".xls";
				File f = new File(fileName);
				if(f.exists())
					f.delete();
				List<UploadItem> itemList = event.getUploadItems();  
		        for(int i=0 ; i<itemList.size() ; i++){
		        	UploadItem item = (UploadItem) itemList.get(i);
		        	File file = new File(fileName);
	                FileOutputStream out = new FileOutputStream(file);
	                out.write(item.getData());
	                out.close();
		        }
		        //准备导入数据
		        f = new File(fileName);
		        if(!f.exists())
		        	return;
		        //

		        InputStream is = new FileInputStream(fileName);
			    jxl.Workbook rwb = Workbook.getWorkbook(is);
			    Sheet rs = rwb.getSheet(0);
			    int rsRows = rs.getRows();
			    if(rsRows < 3){
			    	getMySession().setMsg("必须有三行记录，首行是列标题、第二行是字段名，第三行起是记录行", 2);
			    	return ;
			    }
			    Cell cell;
			    String cellValue;
			    ArrayList<String> fieldNameArr = new ArrayList<String>();
			    int rsColumns = rs.getColumns();
			    for(int i = 0; i<rsColumns; i++){
			    	cellValue = "";
			    	cell = rs.getCell(i,1);
			    	cellValue = cell.getContents();
			    	if("".equals(cellValue) || cellValue == null){
			    		getMySession().setMsg("字段名不能空，請核查后再导入！", 2);
			    		return;
			    	}
			    	fieldNameArr.add(cellValue);
			    }
			    //check date
			    boolean isOk = true;
			    StringBuffer errorMsg = new StringBuffer();
			    String fieldName = "";
			    for(int i = 2; i<rsRows; i++){
					for(int j = 0; j<rsColumns; j++){
						cell = rs.getCell(j,i);
			    		fieldName = fieldNameArr.get(j);
			    		if("formId".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			if(!FunctionLib.isNum(cellValue)){
			    				isOk = false;
			    				errorMsg.append("行"+ i +"列 " + j +"，表单号必须是数字；<br />");
			    			}
			    		}else if("field11".equals(fieldName)
			    				|| "field12".equals(fieldName)
			    				|| "field13".equals(fieldName)
			    				|| "field14".equals(fieldName)
			    				|| "field15".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		//allow cell value is empty
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0";
				    		if(!FunctionLib.isNum(cellValue)){
			    				isOk = false;
			    				errorMsg.append("行"+ i +"列 " + j +"，必须是数字；<br />");
				    		}
			    		}else if("field16".equals(fieldName)
			    				|| "field17".equals(fieldName)
			    				|| "field18".equals(fieldName)
			    				|| "field19".equals(fieldName)
			    				|| "field20".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		//allow cell value is empty
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0.0";
				    		if(!FunctionLib.isDouble(cellValue)){
			    				isOk = false;
			    				errorMsg.append("行"+ i +"列 " + j +"，必须是数字；<br />");
				    		}
			    		}else if("field26".equals(fieldName)
			    				|| "field27".equals(fieldName)
			    				|| "field28".equals(fieldName)
			    				|| "field29".equals(fieldName)
			    				|| "field30".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		//allow cell value is empty
				    		if(null != cellValue && !"".equals(cellValue)){
				    			if(!FunctionLib.isDate(cellValue)){
				    				isOk = false;
				    				errorMsg.append("行"+ i +"列 " + j +"，日期格式不正确；<br />");
				    			}
				    		}
			    		}
					}
			    }
			    if(!isOk){
			    	getMySession().setMsg("数据检查错误，请重新导入。" + errorMsg.toString(), 2);
			    	return ;
			    }			 
			    
			    int m = 0;
			    int userId = getMySession().getUserId();
			    for(int i = 2; i<rsRows; i++){
			    	FormMain bean = new FormMain();
			    	bean.setUUID_(java.util.UUID.randomUUID().toString());
					bean.setCID_(userId);
					bean.setCDATE_(new java.util.Date());
					bean.setIsArc("N");
					for(int j = 0; j<rsColumns; j++){
						cell = rs.getCell(j,i);
			    		fieldName = fieldNameArr.get(j);
			    		if("formId".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setFormId(Integer.valueOf(cellValue));
			    		}else if("field".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField(cellValue);
			    		}else if("field2".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField2(cellValue);
			    		}else if("field3".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField3(cellValue);
			    		}else if("field4".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField4(cellValue);
			    		}else if("field5".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField5(cellValue);
			    		}else if("field6".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField6(cellValue);
			    		}else if("field7".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField7(cellValue);
			    		}else if("field8".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField8(cellValue);
			    		}else if("field9".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField9(cellValue);
			    		}else if("field10".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField10(cellValue);
			    		}else if("field11".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0";
			    			bean.setField11(Integer.valueOf(cellValue));
			    		}
			    		else if("field12".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0";
			    			bean.setField12(Integer.valueOf(cellValue));
			    		}
			    		else if("field13".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0";
			    			bean.setField13(Integer.valueOf(cellValue));
			    		}
			    		else if("field14".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0";
			    			bean.setField14(Integer.valueOf(cellValue));
			    		}
			    		else if("field15".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0";
			    			bean.setField15(Integer.valueOf(cellValue));
			    		}
			    		else if("field16".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0.0";
			    			bean.setField16(Double.valueOf(cellValue));
			    		}
			    		else if("field17".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0.0";
			    			bean.setField17(Double.valueOf(cellValue));
			    		}
			    		else if("field18".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0.0";
			    			bean.setField18(Double.valueOf(cellValue));
			    		}
			    		else if("field19".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0.0";
			    			bean.setField19(Double.valueOf(cellValue));
			    		}
			    		else if("field20".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null == cellValue || "".equals(cellValue))
				    			cellValue = "0.0";
			    			bean.setField20(Double.valueOf(cellValue));
			    		}
			    		else if("field21".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField21(cellValue);
			    		}
			    		else if("field22".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField22(cellValue);
			    		}
			    		else if("field23".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField23(cellValue);
			    		}
			    		else if("field24".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField24(cellValue);
			    		}
			    		else if("field25".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField25(cellValue);
			    		}
			    		else if("field26".equals(fieldName)){
			    			cellValue = cell.getContents();
				    		if(null != cellValue && !"".equals(cellValue)){
				    			DateCell data = (DateCell) rs.getCell(j,i);
				    			bean.setField26(data.getDate());
				    		}
			    		}
			    		else if("field27".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null != cellValue && !"".equals(cellValue)){
				    			DateCell data = (DateCell) rs.getCell(j,i);
				    			bean.setField27(data.getDate());
				    		}
				    			
			    		}
			    		else if("field28".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null != cellValue && !"".equals(cellValue)){
				    			DateCell data = (DateCell) rs.getCell(j,i);
				    			bean.setField28(data.getDate());
				    		}
			    		}
			    		else if("field29".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null != cellValue && !"".equals(cellValue)){
				    			DateCell data = (DateCell) rs.getCell(j,i);
				    			bean.setField29(data.getDate());
				    		}
			    		}
			    		else if("field30".equals(fieldName)){
				    		cellValue = cell.getContents();
				    		if(null != cellValue && !"".equals(cellValue)){
				    			DateCell data = (DateCell) rs.getCell(j,i);
				    			bean.setField30(data.getDate());
				    		}
			    		}
			    		else if("field31".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField24(cellValue);
			    		}
			    		else if("field32".equals(fieldName)){
				    		cellValue = cell.getContents();
			    			bean.setField25(cellValue);
			    		}
					}
					getSession().save(bean);
					bean = null;
			    	m++;
			    }
			    getMySession().setMsg("导入完成，共导入"+m+"条记录。", 1);
			}
			
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
