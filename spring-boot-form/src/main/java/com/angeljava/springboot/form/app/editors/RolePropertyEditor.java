package com.angeljava.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.angeljava.springboot.form.app.services.RoleService;

@Component 
public class RolePropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RoleService roleService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try { 
			Integer id =Integer.parseInt(text);
			setValue(roleService.getRoleById(id));
		} catch(NumberFormatException e) {
			setValue(null);
		}
	}

}
