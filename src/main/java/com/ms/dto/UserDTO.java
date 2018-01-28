package com.ms.dto;

import com.ms.entity.User;

public class UserDTO {
	private Integer id;
	private String email;
	private String name;
	private Integer roleId;

	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.roleId = user.getRoleId();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "UserDTO [id=" + this.id + ", email=" + this.email + ", name=" + this.name + "]";
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}