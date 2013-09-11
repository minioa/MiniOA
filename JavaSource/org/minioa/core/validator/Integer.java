package org.minioa.core.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class Integer implements Validator {
	/**
	 * 整数验证
	 */
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Pattern pattern = Pattern.compile("^-?\\d+$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(String.valueOf(value));
		if (!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}