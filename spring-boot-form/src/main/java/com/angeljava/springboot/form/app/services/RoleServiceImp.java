package com.angeljava.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.angeljava.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImp implements RoleService {

	private List<Role> roles;

	public RoleServiceImp() {
		roles = Arrays.asList(
				new Role(1, "Administrator", "ROLE_ADMIN"),
				new Role(2, "User", "ROLE_USER"),
				new Role(3, "Moderator", "ROLE_MODERATOR"));
	}

	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public Role getRoleById(Integer id) {
		// TODO Auto-generated method stub
		return roles.stream().filter(role -> id.equals(role.getId())).findFirst().orElse(null);
	}

}
