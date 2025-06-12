package com.motorBackened.motor_backened.response;

import java.time.LocalDateTime;

public class UserResponse {

	private Long userId;
	private String name;
	private String email;
	private Long roleId;
	private String roleName;
	private String password;
	private LocalDateTime createdAt;

	public UserResponse(Long userId, String name, String email, Long roleId, String roleName, String password,
			LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.roleId = roleId;
		this.roleName = roleName;
		this.password = password;
		this.createdAt = createdAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
