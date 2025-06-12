package com.motorBackened.motor_backened.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_has_permissions")
public class RoleHasPermissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "role_id")
	private Long role;

	@Column(name = "permission_id")
	private Long permission;

	public RoleHasPermissions() {
	}

	public RoleHasPermissions(Long role, Long permission) {
		super();
		this.role = role;
		this.permission = permission;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getPermission() {
		return permission;
	}

	public void setPermission(Long permission) {
		this.permission = permission;
	}

}
