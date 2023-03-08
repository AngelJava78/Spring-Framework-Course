package com.angeljava.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class UppercaseEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
	}

	/*
	 * @Override public void setAsText(String text) throws IllegalArgumentException
	 * { super.setAsText(text); }
	 */

}
