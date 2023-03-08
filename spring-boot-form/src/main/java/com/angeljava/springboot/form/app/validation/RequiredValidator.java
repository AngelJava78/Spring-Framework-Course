package com.angeljava.springboot.form.app.validation;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		/*
		 * if(value== null || value.isEmpty() || value.isBlank()) { return false; }
		 * return true;
		 */
		//return (value != null && !value.trim().isEmpty());
		return (value != null && StringUtils.hasText(value));
	}

}
