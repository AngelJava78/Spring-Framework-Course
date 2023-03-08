package com.angeljava.springboot.form.app.models.domain;

import java.util.Objects;

public class Role {

	private Integer id;

	private String code;

	private String name;

	public Role() {
	}

	public Role(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Role role = (Role) obj;
		return Objects.equals(this.id, role.getId());
	}



	
}
