package com.motorBackened.motor_backened.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_relation")
public class UserRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRelationId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private RoleMaster role;

	public UserRelation() {

	}

	public UserRelation(Long userRelationId, Users user, RoleMaster role) {
		super();
		this.userRelationId = userRelationId;
		this.user = user;
		this.role = role;
	}

	public Long getUserRelationId() {
		return userRelationId;
	}

	public void setUserRelationId(Long userRelationId) {
		this.userRelationId = userRelationId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public RoleMaster getRole() {
		return role;
	}

	public void setRole(RoleMaster role) {
		this.role = role;
	}

}
