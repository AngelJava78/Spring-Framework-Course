package com.angeljava.springboot.form.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint( validatedBy = RegexIdentifierValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface RegexIdentifier {

	//String message() default "{jakarta.validation.constraints.Pattern.message}";
	String message() default "The field id pattern is invalid!";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
