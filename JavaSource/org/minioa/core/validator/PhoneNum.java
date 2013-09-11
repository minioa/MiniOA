package org.minioa.core.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PhoneNum implements Validator {
	/**
	 * 电话号码、手机号码验证
	 */
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Pattern pattern = Pattern.compile("\\d{3}-\\d{8}|\\d{4}-\\d{7}|\\d{11}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher((String) value);
		if (!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}