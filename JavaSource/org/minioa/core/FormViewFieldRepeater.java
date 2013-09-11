package org.minioa.core;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import org.ajax4jsf.component.UIRepeat;
import org.hibernate.Query;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FormViewFieldRepeater {
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-12-15
	 */

	HtmlInputHidden fieldId;
	HtmlInputText inputTextBoxSize;
	HtmlSelectOneMenu displayWidth;
	HtmlSelectOneMenu textAlign;
	HtmlSelectOneMenu isShow;
	HtmlSelectOneMenu enabledSearch;
	HtmlSelectOneMenu spacer;
	HtmlSelectOneMenu canEdit;
	HtmlSelectOneMenu inputType;
	HtmlSelectOneMenu required;
	private UIRepeat repeater, repeater2;
	private Set<Integer> keys = null;

	/**
	 * @return the keys
	 */
	public Set<Integer> getKeys() {
		return keys;
	}

	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(Set<Integer> keys) {
		this.keys = keys;
	}

	public void setRepeater(UIRepeat repeater) {
		this.repeater = repeater;
	}

	public UIRepeat getRepeater() {
		return repeater;
	}

	public void setRepeater2(UIRepeat repeater2) {
		this.repeater2 = repeater2;
	}

	public UIRepeat getRepeater2() {
		return repeater2;
	}

	public HtmlInputHidden getFieldId() {
		return fieldId;
	}

	public void setFieldId(HtmlInputHidden data) {
		this.fieldId = data;
	}

	public HtmlInputText getInputTextBoxSize() {
		return inputTextBoxSize;
	}

	public void setInputTextBoxSize(HtmlInputText data) {
		this.inputTextBoxSize = data;
	}

	public HtmlSelectOneMenu getDisplayWidth() {
		return displayWidth;
	}

	public void setDisplayWidth(HtmlSelectOneMenu data) {
		this.displayWidth = data;
	}

	public HtmlSelectOneMenu getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(HtmlSelectOneMenu data) {
		this.textAlign = data;
	}

	public HtmlSelectOneMenu getIsShow() {
		return isShow;
	}

	public void setIsShow(HtmlSelectOneMenu data) {
		this.isShow = data;
	}
	
	public HtmlSelectOneMenu getEnabledSearch() {
		return enabledSearch;
	}

	public void setEnabledSearch(HtmlSelectOneMenu data) {
		this.enabledSearch = data;
	}
	
	public HtmlSelectOneMenu getSpacer() {
		return spacer;
	}

	public void setSpacer(HtmlSelectOneMenu data) {
		this.spacer = data;
	}

	public HtmlSelectOneMenu getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(HtmlSelectOneMenu data) {
		this.canEdit = data;
	}

	public void setInputType(HtmlSelectOneMenu data) {
		this.inputType = data;
	}

	public HtmlSelectOneMenu getInputType() {
		return inputType;
	}

	public void setRequired(HtmlSelectOneMenu data) {
		this.required = data;
	}

	public HtmlSelectOneMenu getRequired() {
		return required;
	}

	public FormViewFieldRepeater() {
	}

	public void saveTable() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String viewId = (String) params.get("viewId");
			String tableOrEdit = (String) params.get("tableOrEdit");
			HashSet<Integer> keys = new HashSet<Integer>();
			int rowKey = getRepeater().getRowIndex();
			keys.add(rowKey);
			setKeys(keys);
			fieldId.processValidators(FacesContext.getCurrentInstance());
			fieldId.processUpdates(FacesContext.getCurrentInstance());
			displayWidth.processValidators(FacesContext.getCurrentInstance());
			displayWidth.processUpdates(FacesContext.getCurrentInstance());
			textAlign.processValidators(FacesContext.getCurrentInstance());
			textAlign.processUpdates(FacesContext.getCurrentInstance());
			isShow.processValidators(FacesContext.getCurrentInstance());
			isShow.processUpdates(FacesContext.getCurrentInstance());
			enabledSearch.processValidators(FacesContext.getCurrentInstance());
			enabledSearch.processUpdates(FacesContext.getCurrentInstance());
			spacer.processValidators(FacesContext.getCurrentInstance());
			spacer.processUpdates(FacesContext.getCurrentInstance());
			
			FormViewField bean = new FormViewFieldDao().selectRecordById();
			bean.setFieldId(Integer.valueOf(fieldId.getValue().toString()));
			bean.setDisplayWidth(displayWidth.getValue().toString());
			bean.setTextAlign(textAlign.getValue().toString());
			bean.setIsShow(isShow.getValue().toString());
			bean.setEnabledSearch(enabledSearch.getValue().toString());
			bean.setSpacer(Integer.valueOf(spacer.getValue().toString()));
			bean.setTableOrEdit(tableOrEdit);
			new FormViewFieldDao().updateRecordById(bean, formId, viewId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void saveEdit() {
		try {
			Map<?, ?> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String formId = (String) params.get("formId");
			String viewId = (String) params.get("viewId");
			String tableOrEdit = (String) params.get("tableOrEdit");

			HashSet<Integer> keys = new HashSet<Integer>();
			int rowKey = getRepeater2().getRowIndex();
			keys.add(rowKey);
			setKeys(keys);
			
			fieldId.processValidators(FacesContext.getCurrentInstance());
			fieldId.processUpdates(FacesContext.getCurrentInstance());
			inputTextBoxSize.processValidators(FacesContext.getCurrentInstance());
			inputTextBoxSize.processUpdates(FacesContext.getCurrentInstance());
			canEdit.processValidators(FacesContext.getCurrentInstance());
			canEdit.processUpdates(FacesContext.getCurrentInstance());
			inputType.processValidators(FacesContext.getCurrentInstance());
			inputType.processUpdates(FacesContext.getCurrentInstance());
			required.processValidators(FacesContext.getCurrentInstance());
			required.processUpdates(FacesContext.getCurrentInstance());
			FormViewField bean = new FormViewFieldDao().selectRecordById();
			bean.setFieldId(Integer.valueOf(fieldId.getValue().toString()));
			if (inputTextBoxSize.getValue() == null)
				bean.setInputTextBoxSize(0);
			else
				bean.setInputTextBoxSize(Integer.valueOf(inputTextBoxSize.getValue().toString()));
			bean.setCanEdit(canEdit.getValue().toString());
			bean.setInputType(String.valueOf(inputType.getValue()));
			bean.setRequired(required.getValue().toString());
			bean.setTableOrEdit(tableOrEdit);
			new FormViewFieldDao().updateRecordById(bean, formId, viewId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
