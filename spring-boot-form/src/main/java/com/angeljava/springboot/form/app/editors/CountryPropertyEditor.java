package com.angeljava.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.angeljava.springboot.form.app.services.CountryService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private CountryService service;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
	    try {
	        Integer id = Integer.parseInt(text);
	        this.setValue(service.getCountryById(id));
	    } catch (NumberFormatException e) {
	        this.setValue(null);
	    }
	}


}
