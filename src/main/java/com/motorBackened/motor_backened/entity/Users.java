package com.motorBackened.motor_backened.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.motorBackened.motor_backened.Enums.Statuses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Transient // This field won't be stored in DB
	private String confirmPassword;

//	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

//	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Statuses status;

	public Users(Long userId, String name, String email, String password, String confirmPassword,
			LocalDateTime createdAt, LocalDateTime updatedAt, Statuses status) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

	public Users() {

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
