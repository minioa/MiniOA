package org.minioa.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ui.*;
import org.minioa.core.FormView;
import org.minioa.core.FormViewField;

public class FormViewFieldDao {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-7
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

	public FormViewFieldDao() {
	}

	public ArrayList<FormViewField> buildItems() {
		ArrayList<FormViewField> items = new ArrayList<FormViewField>();
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String viewId = (String) params.get("viewId");
			if (FunctionLib.isNum(viewId) && FunctionLib.isNum(viewId))
				items = lists(formId, viewId, "0");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<FormViewField> buildItems2() {
		ArrayList<FormViewField> items = new ArrayList<FormViewField>();
		try {
			getMySession();
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String viewId = (String) params.get("viewId");
			if (FunctionLib.isNum(viewId) && FunctionLib.isNum(viewId))
				items = lists(formId, viewId, "1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<FormViewField> lists(String formId, String viewId, String tableOrEdit) {
		ArrayList<FormViewField> items = new ArrayList<FormViewField>();
		try {
			getMySession();
			items = new ArrayList<FormViewField>();
			Query query = getSession().getNamedQuery("core.form.view.field.items");
			query.setParameter("formId", formId);
			query.setParameter("viewId", viewId);
			query.setParameter("tableOrEdit", tableOrEdit);
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object obj[] = (Object[]) it.next();
				FormViewField bean = new FormViewField();
				bean.setFieldId(FunctionLib.getInt(obj[0]));
				bean.setFieldText(FunctionLib.getString(obj[1]));
				bean.setFieldName(FunctionLib.getString(obj[2]));
				bean.setFieldType(FunctionLib.getString(obj[3]));
				bean.setID_(FunctionLib.getInt(obj[4]));
				bean.setIsShow(FunctionLib.getString(obj[5]));
				bean.setCanEdit(FunctionLib.getString(obj[6]));
				bean.setDisplayWidth(FunctionLib.getString(obj[7]));
				bean.setTextAlign(FunctionLib.getString(obj[8]));
				bean.setInputTextBoxSize(FunctionLib.getInt(obj[9]));
				bean.setInputType(FunctionLib.getString(obj[10]));
				bean.setCheckText(FunctionLib.getString(obj[11]));
				bean.setRequired(FunctionLib.getString(obj[12]));
				bean.setEnabledSearch(FunctionLib.getString(obj[15]));
				bean.setSpacer(FunctionLib.getInt(obj[16]));
				items.add(bean);
			}
			it = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public ArrayList<SelectItem> buildSi() {
		ArrayList<SelectItem> si = new ArrayList<SelectItem>();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String viewId = (String) params.get("viewId");
			if (FunctionLib.isNum(viewId)) {
				Query query = new HibernateEntityLoader().getSession().getNamedQuery("core.form.main.items");
				query.setParameter("viewId", viewId);
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					si.add(new SelectItem(FunctionLib.getInt(obj[0]), FunctionLib.getString(obj[1])));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return si;
	}

	public FormViewField selectRecordById() {
		FormViewField bean = new FormViewField();
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = (String) params.get("id");
			if (FunctionLib.isNum(id))
				bean = selectRecordById(Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public FormViewField selectRecordById(Integer id) {
		FormViewField bean = new FormViewField();
		try {
			Criteria criteria = getSession().createCriteria(FormViewField.class).add(Restrictions.eq("ID_", id));
			Iterator<?> it = criteria.list().iterator();
			while (it.hasNext())
				bean = (FormViewField) it.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public void newRecord(FormViewField bean) {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String viewId = (String) params.get("viewId");
			if (FunctionLib.isNum(viewId)) {
				bean.setViewId(Integer.valueOf(viewId));
				bean.setCID_(getMySession().getUserId());
				bean.setCDATE_(new java.util.Date());
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

	public void deleteRecordById() {
		try {
			String id = getMySession().getTempStr().get("FormViewField.id");
			if (FunctionLib.isNum(id)) {
				Criteria criteria = getSession().createCriteria(FormViewField.class).add(Restrictions.eq("ID_", Integer.valueOf(id)));
				Iterator<?> it = criteria.list().iterator();
				while (it.hasNext())
					getSession().delete((FormViewField) it.next());
			}
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
			getMySession().getTempStr().put("FormViewField.id", (String) params.get("id"));
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public void updateRecordById(FormViewField bean, String formId, String viewId) {
		try {
			boolean is = isExists(viewId, bean.getTableOrEdit(), bean.getFieldId());
			Query query;
			if ("0".equals(bean.getTableOrEdit())) {
				if (is)
					query = getSession().getNamedQuery("core.form.view.field.update.table");
				else
					query = getSession().getNamedQuery("core.form.view.field.insert.table");
				query.setParameter("viewId", viewId);
				query.setParameter("tableOrEdit", "0");
				query.setParameter("fieldId", bean.getFieldId());
				query.setParameter("displayWidth", bean.getDisplayWidth());
				query.setParameter("textAlign", bean.getTextAlign());
				query.setParameter("isShow", bean.getIsShow());
				query.setParameter("enabledSearch", bean.getEnabledSearch());
				query.setParameter("spacer", bean.getSpacer());
				query.executeUpdate();
			}
			if ("1".equals(bean.getTableOrEdit())) {
				if (is)
					query = getSession().getNamedQuery("core.form.view.field.update.edit");
				else
					query = getSession().getNamedQuery("core.form.view.field.insert.edit");
				query.setParameter("viewId", viewId);
				query.setParameter("tableOrEdit", "1");
				query.setParameter("fieldId", bean.getFieldId());
				query.setParameter("inputTextBoxSize", bean.getInputTextBoxSize());
				query.setParameter("inputType", bean.getInputType());
				query.setParameter("canEdit", bean.getCanEdit());
				query.setParameter("required", bean.getRequired());
				query.executeUpdate();
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}

	public boolean isExists(String viewId, String fieldType, Integer fieldId) {
		try {
			Query query = getSession().getNamedQuery("core.form.view.field.isexists");
			query.setParameter("viewId", viewId);
			query.setParameter("tableOrEdit", fieldType);
			query.setParameter("fieldId", fieldId);
			if (query.list().get(0).toString().equals("1"))
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public void buildFormFile() {
		try {
			getMySession();
			StringBuffer tContent = new StringBuffer();
			boolean enableSearch = false;

			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String viewId = (String) params.get("viewId");
			if (FunctionLib.isNum(viewId) && FunctionLib.isNum(viewId)) {
				Form form = new FormDao().selectRecordById(Integer.valueOf(formId));
				FormView view = new FormViewDao().selectRecordById(Integer.valueOf(viewId));
				if(null == view.getViewTemplate()){
					getMySession().setMsg("请先指定模版，然后再重试!", 2);
					return ;
				}
				
				//载入模版
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FunctionLib.getBaseDir() + view.getViewTemplate()), "UTF-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					tContent.append(line + "\r\n");
				}
				br.close();

				ArrayList<FormViewField> dataTableFields = new ArrayList<FormViewField>();
				ArrayList<FormViewField> editFormFields = new ArrayList<FormViewField>();

				Query query = getSession().getNamedQuery("core.form.view.field.items");
				query.setParameter("formId", formId);
				query.setParameter("viewId", viewId);
				query.setParameter("tableOrEdit", "0");
				Iterator<?> it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					FormViewField bean = new FormViewField();
					bean.setFieldId(FunctionLib.getInt(obj[0]));
					bean.setFieldText(FunctionLib.getString(obj[1]));
					bean.setFieldName(FunctionLib.getString(obj[2]));
					bean.setFieldType(FunctionLib.getString(obj[3]));
					bean.setID_(FunctionLib.getInt(obj[4]));
					bean.setIsShow(FunctionLib.getString(obj[5]));
					bean.setCanEdit(FunctionLib.getString(obj[6]));
					bean.setDisplayWidth(FunctionLib.getString(obj[7]));
					bean.setTextAlign(FunctionLib.getString(obj[8]));
					bean.setInputTextBoxSize(FunctionLib.getInt(obj[9]));
					bean.setInputType(FunctionLib.getString(obj[10]));
					bean.setCheckText(FunctionLib.getString(obj[11]));
					bean.setRequired(FunctionLib.getString(obj[12]));
					bean.setFormatString(FunctionLib.getString(obj[13]));
					bean.setDataSource(FunctionLib.getString(obj[14]));
					bean.setEnabledSearch(FunctionLib.getString(obj[15]));
					bean.setSpacer(FunctionLib.getInt(obj[16]));
					dataTableFields.add(bean);
				}
				query = getSession().getNamedQuery("core.form.view.field.items");
				query.setParameter("formId", formId);
				query.setParameter("viewId", viewId);
				query.setParameter("tableOrEdit", "1");
				it = query.list().iterator();
				while (it.hasNext()) {
					Object obj[] = (Object[]) it.next();
					FormViewField bean = new FormViewField();
					bean.setFieldId(FunctionLib.getInt(obj[0]));
					bean.setFieldText(FunctionLib.getString(obj[1]));
					bean.setFieldName(FunctionLib.getString(obj[2]));
					bean.setFieldType(FunctionLib.getString(obj[3]));
					bean.setID_(FunctionLib.getInt(obj[4]));
					bean.setIsShow(FunctionLib.getString(obj[5]));
					bean.setCanEdit(FunctionLib.getString(obj[6]));
					bean.setDisplayWidth(FunctionLib.getString(obj[7]));
					bean.setTextAlign(FunctionLib.getString(obj[8]));
					bean.setInputTextBoxSize(FunctionLib.getInt(obj[9]));
					bean.setInputType(FunctionLib.getString(obj[10]));
					bean.setCheckText(FunctionLib.getString(obj[11]));
					bean.setRequired(FunctionLib.getString(obj[12]));
					bean.setFormatString(FunctionLib.getString(obj[13]));
					bean.setDataSource(FunctionLib.getString(obj[14]));
					bean.setEnabledSearch(FunctionLib.getString(obj[15]));
					bean.setSpacer(FunctionLib.getInt(obj[16]));
					editFormFields.add(bean);
				}
				StringBuffer search = new StringBuffer();
				StringBuffer table = new StringBuffer();
				StringBuffer edit = new StringBuffer();

				String fieldsText = "";
				String fieldsDate = "";
				String onclick = "";
				//
				search.append("<h:panelGrid columns=\"12\">\r\n");
				it = dataTableFields.iterator();
				while (it.hasNext()) {
					FormViewField bean = (FormViewField) it.next();

					if ("Y".equals(bean.getEnabledSearch())) {
						if ("datetime".equals(bean.getFieldType())) {
							search.append("<h:outputText value=\"" + bean.getFieldText() + ":\" />\r\n");
							String datePattern = "datePattern=\"yyyy-MM-dd\"";
							if (!"".equals(bean.getFormatString()))
								datePattern = "datePattern=\"" + bean.getFormatString() + "\"";
							search.append("<a4j:outputPanel layout=\"block\" >\r\n");
							search.append("<rich:calendar id=\"" + bean.getFieldName() + "\" value=\"#{MySession.tempDate['FormMain." + bean.getFieldName() + "']}\" locale=\"zh/CN\"  cellWidth=\"24px\" cellHeight=\"22px\" enableManualInput=\"true\" " + datePattern + " required=\"" + bean.getRequired() + "\" requiredMessage=\"" + bean.getFieldText() + "不能空\"/>\r\n");
							search.append("</a4j:outputPanel>\r\n");

							fieldsDate = fieldsDate + bean.getFieldName() + ",";
							onclick = onclick + "$('searchForm:" + bean.getFieldName() + "').value='';";
							search.append("<a4j:outputPanel layout=\"block\" >\r\n");
							search.append("<rich:calendar id=\"" + bean.getFieldName() + "_2\" value=\"#{MySession.tempDate['FormMain." + bean.getFieldName() + "_2']}\" locale=\"zh/CN\"  cellWidth=\"24px\" cellHeight=\"22px\" enableManualInput=\"true\" " + datePattern + " required=\"" + bean.getRequired() + "\" requiredMessage=\"" + bean.getFieldText() + "不能空\"/>\r\n");
							search.append("</a4j:outputPanel>\r\n");

							fieldsDate = fieldsDate + bean.getFieldName() + "_2,";
							onclick = onclick + "$('searchForm:" + bean.getFieldName() + "_2').value='';";
						} else {
							search.append("<h:outputText value=\"" + bean.getFieldText() + ":\" />\r\n");
							search.append("<h:inputText id=\"key" + bean.getFieldName() + "\" value=\"#{MySession.tempStr['FormMain." + bean.getFieldName() + "']}\" style=\"width:80px;\" />\r\n");
							onclick = onclick + "$('searchForm:" + bean.getFieldName() + "').value='';";
							fieldsText = fieldsText + bean.getFieldName() + ",";
						}
						for (int m = 0; m < bean.getSpacer() - 1; m++) {
							search.append("<h:outputText value=\"\" />\r\n");
						}
						enableSearch = true;
					}
				}
				if(enableSearch){
					search.append("<a4j:commandLink action=\"#{FormMain.buildItems}\" reRender=\"dataForm\">\r\n");
					search.append("<h:outputText value=\"搜索\" class=\"btn\" />\r\n");
					search.append("<f:param name=\"reload\" value=\"true\" />\r\n");
					search.append("<f:param name=\"formId\" value=\"#{param['formId']}\" />\r\n");
					search.append("<f:param name=\"itemId\" value=\"#{param['itemId']}\" />\r\n");
					search.append("<f:param name=\"viewId\" value=\"" + viewId + "\" />\r\n");
					search.append("<f:param name=\"resetPageNo\" value=\"true\" />\r\n");
					search.append("<f:param name=\"fieldsText\" value=\"" + fieldsText + "\" />\r\n");
					search.append("<f:param name=\"fieldsDate\" value=\"" + fieldsDate + "\" />\r\n");
					search.append("</a4j:commandLink>\r\n");
					search.append("<a4j:commandLink style=\"margin-left:6px;\" onclick=\"" + onclick + "return false;\">\r\n");
					search.append("<h:outputText value=\"清空\" class=\"btn\" />\r\n");
					search.append("</a4j:commandLink>\r\n");
				}
				if ("Y".equals(view.getDisplayDownloadBtn())) {
					search.append("<h:commandLink action=\"#{FormMain.download}\" reRender=\"dataForm\">\r\n");
					search.append("<h:outputText value=\"下载\" class=\"btn\" />\r\n");
					search.append("<f:param name=\"formId\" value=\"#{param['formId']}\" />\r\n");
					search.append("<f:param name=\"viewId\" value=\"" + viewId + "\" />\r\n");
					search.append("<f:param name=\"fieldsText\" value=\"" + fieldsText + "\" />\r\n");
					search.append("<f:param name=\"fieldsDate\" value=\"" + fieldsDate + "\" />\r\n");
					search.append("</h:commandLink>\r\n");
				}
				search.append("</h:panelGrid>\r\n");

				table.append("<rich:dataTable id=\"dataTable\" value=\"#{FormMain.items}\" var=\"item\" rowKeyVar=\"rowNum\" rendered=\"#{MySession.hasOp['form." + formId + ".view." + viewId + ".read']}\" style=\"width:100%;\">\r\n");
				table.append("<f:facet name=\"header\">\r\n");
				table.append("<rich:columnGroup>\r\n");
				table.append("<rich:column styleClass=\"left\" style=\"width:1%;\">\r\n");
				table.append("<a4j:commandLink action=\"#{FormMain.buildItems}\" reRender=\"dataForm\">\r\n");
				table.append("<h:graphicImage title=\"刷新\" class=\"imgBtn\" url=\"images/reload.png\" style=\"width:16px;\">\r\n");
				table.append("</h:graphicImage>\r\n");
				table.append("<f:param name=\"reload\" value=\"true\" />\r\n");
				table.append("<f:param name=\"resetPageNo\" value=\"true\" />\r\n");
				table.append("<f:param name=\"formId\" value=\"" + formId + "\" />\r\n");
				table.append("</a4j:commandLink>\r\n");
				table.append("</rich:column>\r\n");
				table.append("<rich:column style=\"width:1%;text-align:center;\">\r\n");
				table.append("<h:outputText value=\"\" />\r\n");
				table.append("</rich:column>\r\n");
				it = dataTableFields.iterator();
				while (it.hasNext()) {
					FormViewField bean = (FormViewField) it.next();
					if ("Y".equals(bean.getIsShow())) {
						table.append("<rich:column style=\"width:" + bean.getDisplayWidth() + ";text-align:" + bean.getTextAlign() + ";\">\r\n");
						table.append("<h:outputText value=\"" + bean.getFieldText() + "\" />\r\n");
						table.append("</rich:column>\r\n");
					}
				}
				if("Y".equals(view.getDisplayCInfo())){
					table.append("<rich:column style=\"width:5%;text-align:center;\">\r\n");
					table.append("<h:outputText value=\"C\" />\r\n");
					table.append("</rich:column>\r\n");
					table.append("<rich:column style=\"width:5%;text-align:center;\">\r\n");
					table.append("<h:outputText value=\"D\" />\r\n");
					table.append("</rich:column>\r\n");
				}
				if("Y".equals(view.getDisplayMInfo())){
					table.append("<rich:column style=\"width:5%;text-align:center;\">\r\n");
					table.append("<h:outputText value=\"M\" />\r\n");
					table.append("</rich:column>\r\n");
					table.append("<rich:column style=\"width:5%;text-align:center;\">\r\n");
					table.append("<h:outputText value=\"D\" />\r\n");
					table.append("</rich:column>\r\n");
				}
				table.append("<rich:column styleClass=\"right\" style=\"width:1%;\">\r\n");
				table.append("<h:outputText value=\"\" />\r\n");
				table.append("</rich:column>\r\n");
				table.append("</rich:columnGroup>\r\n");
				table.append("</f:facet>\r\n");

				table.append("<rich:column style=\"width:1%;text-align:center;\">\r\n");
				table.append("<h:outputText value=\"#{rowNum + 1}\" />\r\n");
				table.append("</rich:column>\r\n");
				if ("Y".equals(view.getDisplayProcessBtn()))
					table.append("<rich:column style=\"text-align:center;width:36px;white-space:nowrap\">\r\n");
				else
					table.append("<rich:column style=\"text-align:center;width:18px;white-space:nowrap\">\r\n");
				table.append("<h:panelGrid columns=\"2\">\r\n");
				table.append("<a4j:commandLink reRender=\"editForm\">\r\n");
				table.append("<h:graphicImage id=\"edit\" onclick=\"RichFaces.switchTab('tab','tab2','tab2');\" title=\"修改\" class=\"imgBtn\" url=\"images/edit.png\">\r\n");
				table.append("</h:graphicImage>\r\n");
				table.append("<f:param name=\"id\" value=\"#{item.ID_}\" />\r\n");
				table.append("<f:param name=\"headerId\" value=\"#{item.ID_}\" />\r\n");
				table.append("<f:param name=\"reload\" value=\"false\" />\r\n");
				table.append("<f:param name=\"formId\" value=\"" + formId + "\" />\r\n");
				table.append("<f:param name=\"viewId\" value=\"#{item.ID_}\" />\r\n");
				table.append("<f:param name=\"processId\" value=\"#{item.processId}\" />\r\n");
				table.append("<f:param name=\"processDefId\" value=\"#{item.processDefId}\" />\r\n");
				table.append("<f:param name=\"instanceId\" value=\"#{item.ID_}\" />\r\n");
				table.append("</a4j:commandLink>\r\n");
				if ("Y".equals(view.getDisplayProcessBtn())) {
					table.append("<h:outputLink  value=\"processentity.jsf\">\r\n");
					table.append("<h:graphicImage id=\"process\" title=\"流程\" class=\"imgBtn\" url=\"images/process.png\">\r\n");
					table.append("</h:graphicImage>\r\n");
					table.append("<f:param name=\"id\" value=\"#{item.ID_}\" />\r\n");
					table.append("<f:param name=\"reload\" value=\"false\" />\r\n");
					table.append("<f:param name=\"formId\" value=\"" + formId + "\" />\r\n");
					table.append("<f:param name=\"processId\" value=\"#{item.processId}\" />\r\n");
					table.append("<f:param name=\"processDefId\" value=\"#{item.processDefId}\" />\r\n");
					table.append("<f:param name=\"instanceId\" value=\"#{item.ID_}\" />\r\n");
					table.append("</h:outputLink>\r\n");
				}
				table.append("</h:panelGrid>\r\n");
				table.append("</rich:column>\r\n");
				it = dataTableFields.iterator();
				while (it.hasNext()) {
					FormViewField bean = (FormViewField) it.next();
					if ("Y".equals(bean.getIsShow())) {
						table.append("<rich:column style=\"text-align:" + bean.getTextAlign() + ";\">\r\n");
						if ("datetime".equals(bean.getFieldType())) {
							table.append("<h:outputText value=\"#{item." + bean.getFieldName() + "}\" class=\"datetimeBlue\"/>\r\n");
						} else {
							table.append("<h:outputText value=\"#{item." + bean.getFieldName() + "}\" />\r\n");
						}
						table.append("</rich:column>\r\n");
					}
				}
				if("Y".equals(view.getDisplayCInfo())){
					table.append("<rich:column style=\"text-align:center;\">\r\n");
					table.append("<h:outputText value=\"#{item.CUSER}\" />\r\n");
					table.append("</rich:column>\r\n");
					table.append("<rich:column style=\"text-align:center;\">\r\n");
					table.append("<h:outputText value=\"#{item.CDATE}\" class=\"datetimeBlue\"/>\r\n");
					table.append("</rich:column>\r\n");
				}
				if("Y".equals(view.getDisplayMInfo())){
					table.append("<rich:column style=\"text-align:center;\">\r\n");
					table.append("<h:outputText value=\"#{item.MUSER}\" />\r\n");
					table.append("</rich:column>\r\n");
					table.append("<rich:column style=\"text-align:center;\">\r\n");
					table.append("<h:outputText value=\"#{item.MDATE}\" class=\"datetimeBlue\"/>\r\n");
					table.append("</rich:column>\r\n");
				}

				table.append("<rich:column style=\"text-align:center;width:40px;white-space:nowrap\">\r\n");
				if ("Y".equals(view.getDisplayDelBtn())) {
					table.append("<a4j:commandLink action=\"#{FormMainDao.showDialog}\"\r\n");
					table.append("onclick=\"#{rich:component('mpForConfirm')}.show();hideObject('dataForm:dataTable:#{rowNum}:edit');hideObject('dataForm:dataTable:#{rowNum}:del');\">\r\n");
					table.append("<h:graphicImage id=\"del\" title=\"删除\" class=\"imgBtn\" url=\"images/delete.png\">\r\n");
					table.append("</h:graphicImage>\r\n");
					table.append("<f:param name=\"id\" value=\"#{item.ID_}\" />\r\n");
					table.append("<f:param name=\"reload\" value=\"false\" />\r\n");
					table.append("<f:param name=\"formId\" value=\"" + formId + "\" />\r\n");
					table.append("</a4j:commandLink>\r\n");
				}
				table.append("</rich:column>\r\n");
				table.append("</rich:dataTable>\r\n");
				
				
				
				edit.append("<fieldset class=\"fieldset\" style=\"width:800px;\"><legend> <h:outputText value=\"基本属性\" /> </legend>\r\n");
				edit.append("<a4j:form>\r\n");
				edit.append("<h:panelGrid columns=\"4\" columnClasses=\"co1,co2,co3,co3\">\r\n");
				it = editFormFields.iterator();
				while (it.hasNext()) {
					FormViewField bean = (FormViewField) it.next();
					// 可编辑框
					if ("Y".equals(bean.getCanEdit())) {
						edit.append("<h:outputText value=\"" + bean.getFieldText() + ":\" />\r\n");
						if ("datetime".equals(bean.getFieldType())) {
							// 日期选择框
							String datePattern = "datePattern=\"yyyy-MM-dd\"";
							if (!"".equals(bean.getFormatString()))
								datePattern = "datePattern=\"" + bean.getFormatString() + "\"";
							edit.append("<a4j:outputPanel layout=\"block\">\r\n");
							edit.append("<rich:calendar id=\"" + bean.getFieldName() + "\" value=\"#{FormMain." + bean.getFieldName() + "}\" locale=\"zh/CN\"  cellWidth=\"24px\" cellHeight=\"22px\" enableManualInput=\"true\" " + datePattern + " required=\"" + bean.getRequired() + "\" requiredMessage=\"" + bean.getFieldText() + "不能空\"/>\r\n");
							edit.append("</a4j:outputPanel>\r\n");
						} else {
							if ("textarea".equals(bean.getInputType())) {
								// 多行文本框
								edit.append("<h:inputTextarea value=\"#{FormMain." + bean.getFieldName() + "}\" id=\"" + bean.getFieldName() + "\" required=\"" + bean.getRequired() + "\" requiredMessage=\"" + bean.getFieldText() + "不能空\" style=\"margin-left:3px;width:80%;border: 1px dotted #D5D8DC;\" rows=\"" + bean.getInputTextBoxSize() + "\">\r\n");
								//edit.append("<rich:ajaxValidator event=\"onblur\" />\r\n");
								edit.append("</h:inputTextarea>\r\n");
							} else if ("select".equals(bean.getInputType())) {
								// 下拉框
								if ("员工列表".equals(bean.getDataSource())) {
									edit.append("<h:panelGrid columns=\"2\" style=\"margin-left:-3px;\">\r\n");
									edit.append("<h:inputText id=\"" + bean.getFieldName() + "\" style=\"width:80px;\" value=\"#{FormMain." + bean.getFieldName() + "}\" required=\"" + bean.getRequired() + "\" requiredMessage=\"" + bean.getFieldText() + "不能空\"/>\r\n");
									edit.append("<rich:suggestionbox height=\"200\" width=\"236\" suggestionAction=\"#{UserEntitysBean.autocomplete}\" var=\"user\" fetchValue=\"#{user.displayName}\" for=\"" + bean.getFieldName() + "\">\r\n");
									edit.append("<h:column>\r\n");
									edit.append("<h:outputText value=\"#{user.name}\" />\r\n");
									edit.append("</h:column>\r\n");
									edit.append("<h:column>\r\n");
									edit.append("<h:outputText value=\"#{user.displayName}\" />\r\n");
									edit.append("</h:column>\r\n");
									edit.append("<h:column>\r\n");
									edit.append("<h:outputText value=\"#{user.depaName}\" />\r\n");
									edit.append("</h:column>\r\n");
									edit.append("</rich:suggestionbox>\r\n");
									edit.append("</h:panelGrid>\r\n");
								} else {
									;
								}
							} else {
								// 文本框
								edit.append("<h:inputText value=\"#{FormMain." + bean.getFieldName() + "}\" id=\"" + bean.getFieldName() + "\" required=\"" + bean.getRequired() + "\" requiredMessage=\"" + bean.getFieldText() + "不能空\" size=\"" + bean.getInputTextBoxSize() + "\">\r\n");
								//edit.append("<rich:ajaxValidator event=\"onblur\" />\r\n");
								edit.append("</h:inputText>\r\n");
							}
						}
						edit.append("<h:graphicImage title=\"" + bean.getCheckText() + "\" class=\"imgBtn\" url=\"images/help.png\" />\r\n");
						edit.append("<rich:message for=\"" + bean.getFieldName() + "\" style=\"color:red;margin-left:3px;\">\r\n");
						edit.append("<f:facet name=\"errorMarker\">\r\n");
						edit.append("<h:outputText value=\"" + bean.getCheckText() + "\" />\r\n");
						edit.append("</f:facet>\r\n");
						edit.append("</rich:message>\r\n");
					} else {
						if ("datetime".equals(bean.getFieldType())) {
							edit.append("<h:outputText value=\"" + bean.getFieldText() + ":\" />\r\n");
							edit.append("<h:outputText value=\"#{FormMain." + bean.getFieldName() + "}\" class=\"datetimeBlue\"/>\r\n");
							edit.append("<h:outputText value=\"\" />\r\n");
							edit.append("<h:outputText value=\"\" />\r\n");
						} else {
							edit.append("<h:outputText value=\"" + bean.getFieldText() + ":\" />\r\n");
							edit.append("<h:outputText value=\"#{FormMain." + bean.getFieldName() + "}\" />\r\n");
							edit.append("<h:outputText value=\"\" />\r\n");
							edit.append("<h:outputText value=\"\" />\r\n");
						}
					}
				}

				edit.append("<h:outputText value=\"\" />\r\n");
				edit.append("<h:panelGrid columns=\"2\">\r\n");
				if ("Y".equals(view.getDisplayNewBtn())) {
					edit.append("<a4j:commandLink action=\"#{FormMain.newRecord}\" rendered=\"#{!(param['id'] > 0)}\" onclick=\"if(lock) return false; else{lock=true;setTimeout(('lock=false'),5000);}\" reRender=\"msg\">\r\n");
					edit.append("<h:outputText class=\"btn\" value=\"新建\" />\r\n");
					edit.append("<f:param name=\"redirect\" value=\"false\" />\r\n");
					edit.append("<f:param name=\"reload\" value=\"false\" />\r\n");
					edit.append("<a4j:actionparam name=\"formId\" value=\"" + formId + "\" assignTo=\"#{FormMain.formId}\" />\r\n");
					edit.append("</a4j:commandLink>\r\n");
				}
				if ("Y".equals(view.getDisplayEditBtn())) {
					edit.append("<a4j:commandLink action=\"#{FormMain.updateRecordById}\" rendered=\"#{param['id'] > 0}\" onclick=\"if(lock) return false; else{lock=true;setTimeout(('lock=false'),5000);}\" reRender=\"msg\">\r\n");
					edit.append("<h:outputText class=\"btn\" value=\"保存\" />\r\n");
					edit.append("<f:param name=\"redirect\" value=\"false\" />\r\n");
					edit.append("<f:param name=\"reload\" value=\"false\" />\r\n");
					edit.append("<f:param name=\"id\" value=\"#{param['id']}\" />\r\n");
					edit.append("<a4j:actionparam name=\"formId\" value=\"" + formId + "\" assignTo=\"#{FormMain.formId}\" />\r\n");
					edit.append("</a4j:commandLink>\r\n");
				}
				edit.append("</h:panelGrid>\r\n");
				edit.append("</h:panelGrid>\r\n");

				it = editFormFields.iterator();
				while (it.hasNext()) {
					FormViewField bean = (FormViewField) it.next();
					if ("N".equals(bean.getCanEdit()))
						edit.append("<h:inputHidden value=\"#{FormMain." + bean.getFieldName() + "}\" />\r\n");
				}
				edit.append("<h:inputHidden value=\"#{FormMain.ID_}\" />\r\n");
				edit.append("<h:inputHidden value=\"#{FormMain.CID_}\" />\r\n");
				edit.append("<h:inputHidden value=\"#{FormMain.CDATE_}\" />\r\n");
				edit.append("<h:inputHidden value=\"#{FormMain.UUID_}\" />\r\n");
				edit.append("<h:inputHidden value=\"#{FormMain.isArc}\" />\r\n");
				edit.append("</a4j:form>\r\n");
				edit.append("</fieldset>\r\n");

				if ("Y".equals(form.getEnabledAtt()) && "Y".equals(view.getDisplayAttachment())) {
					edit.append("<fieldset class=\"fieldset\" style=\"width:400px;\"><legend> <h:outputText value=\"附件:\" /> </legend>\r\n");
					edit.append("<a4j:form>\r\n");
					if ("Y".equals(view.getDisplayDelBtn())) {
						edit.append("<rich:simpleTogglePanel opened=\"false\" switchType=\"client\" style=\"width:100%;\">\r\n");
						edit.append("<rich:fileUpload fileUploadListener=\"#{FormMainAttachment.uploadListener}\" maxFilesQuantity=\"100\" listWidth=\"100%\" listHeight=\"60\" ondblclick=\"#{rich:component('mpForAttachment')}.hide()\">\r\n");
						edit.append("<a4j:support event=\"onuploadcomplete\" reRender=\"msg,attachmentTable\" />\r\n");
						edit.append("<f:param name=\"uuid\" value=\"#{FormMain.UUID_}\" />\r\n");
						edit.append("<f:param name=\"formid\" value=\"#{param['formid']}\" />\r\n");
						edit.append("</rich:fileUpload>\r\n");
						edit.append("</rich:simpleTogglePanel>\r\n");
					}
					edit.append("<rich:dataGrid id=\"attachmentTable\" value=\"#{FormMainAttachment.items}\" var=\"att\" columns=\"3\" elements=\"36\" style=\"border-width:0;\">\r\n");
					edit.append("<h:commandLink action=\"#{FormMainAttachment.download}\">\r\n");
					edit.append("<h:outputText value=\"#{att.prop['oldname']}\" />\r\n");
					edit.append("<f:param name=\"id\" value=\"#{att.prop['id']}\" />\r\n");
					edit.append("<f:param name=\"uuid\" value=\"#{att.prop['uuid']}\" />\r\n");
					edit.append("</h:commandLink>\r\n");
					if ("Y".equals(view.getDisplayDelBtn())) {
						edit.append("<a4j:commandLink action=\"#{FormMainAttachment.showDialog}\" onclick=\"#{rich:component('mpForConfirmAtt')}.show();\">\r\n");
						edit.append("<h:graphicImage title=\"#{Lang.prop[MySession.l]['delete']}\" class=\"imgBtn\" url=\"images/delete.png\">\r\n");
						edit.append("</h:graphicImage>\r\n");
						edit.append("<f:param name=\"reload\" value=\"false\" />\r\n");
						edit.append("<f:param name=\"id\" value=\"#{att.prop['id']}\" />\r\n");
						edit.append("<f:param name=\"uuid\" value=\"#{att.prop['uuid']}\" />\r\n");
						edit.append("</a4j:commandLink>\r\n");
					}
					edit.append("</rich:dataGrid>\r\n");
					edit.append("</a4j:form>\r\n");
					edit.append("</fieldset>\r\n");
				}
				it = null;
				
				String content = tContent.toString();
				if(view.getViewTemplate().equals("formtemplate.xhtml")){
					content = content.replaceAll("\\{search\\}", search.toString().replace("$", "_dollar_"));
					content = content.replace("_dollar_", "$");
					content = content.replaceAll("\\{title\\}", form.getFormName() + "&gt;" + view.getViewName());
					content = content.replaceAll("\\{table\\}", table.toString());
					content = content.replaceAll("\\{edit\\}", edit.toString());
				}
				if(view.getViewTemplate().equals("formtemplateprocess.xhtml")){
					content = content.replaceAll("\\{edit\\}", edit.toString());
				}
				//生成默认模版
				String filename = FunctionLib.getBaseDir() + "templates" + FunctionLib.getSeparator() + "default" + FunctionLib.getSeparator() + "formview" + view.getID_() + ".xhtml";
				File f = new File(filename);
				if (f.exists())
					f.delete();
				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
				out.write(content);
				out.close();
				//生成网页模版
				filename = FunctionLib.getBaseDir() + "templates" + FunctionLib.getSeparator() + "web" + FunctionLib.getSeparator() + "formview" + view.getID_() + ".xhtml";
				f = new File(filename);
				if (f.exists())
					f.delete();
				out = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
				out.write(content);
				out.close();
				String msg = getLang().getProp().get(getMySession().getL()).get("success");
				getMySession().setMsg(msg, 1);
			}
		} catch (Exception ex) {
			String msg = getLang().getProp().get(getMySession().getL()).get("faield");
			getMySession().setMsg(msg, 2);
			ex.printStackTrace();
		}
	}
}
