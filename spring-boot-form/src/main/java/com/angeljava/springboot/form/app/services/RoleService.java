package com.angeljava.springboot.form.app.services;

import java.util.List;

import com.angeljava.springboot.form.app.models.domain.Role;

public interface RoleService {

	List<Role> getRoleList();
	Role getRoleById(Integer id); 
}
