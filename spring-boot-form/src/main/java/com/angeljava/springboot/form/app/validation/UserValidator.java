package com.angeljava.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.angeljava.springboot.form.app.models.domain.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.user.firstName");
		/*
		 * if(user.getFirstName().isEmpty()) { errors.rejectValue("firstName",
		 * "NotEmpty.user.firstName"); }
		 */
		/*
		 * if(user.getId().matches(
		 * "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}")== false) {
		 * errors.rejectValue("id", "Pattern.user.id"); }
		 */
	}

}
