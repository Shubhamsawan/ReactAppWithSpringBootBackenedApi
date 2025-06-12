package com.motorBackened.motor_backened.entity;

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

@Entity
@Table(name = "menu_master")
public class MenuMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private long menuId;

	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "parent_id")
	private int parentId;

	@Column(name = "menu_slug")
	private String menuSlug;

	@Column(name = "menu_url")
	private String menuUrl;

	@Column(name = "menu_icon")
	private String menuIcon;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Statuses status;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private String createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private String updatedAt;

//	@UpdateTimestamp
	@Column(name = "deleted_at")
	private String deletedAt;

	public MenuMaster() {
		super();
	}

	public MenuMaster(long menuId, String menuName, int parentId, String menuSlug, String menuUrl, String menuIcon,
			Statuses status, String createdAt, String updatedAt, String deletedAt) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.parentId = parentId;
		this.menuSlug = menuSlug;
		this.menuUrl = menuUrl;
		this.menuIcon = menuIcon;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getMenuSlug() {
		return menuSlug;
	}

	public void setMenuSlug(String menuSlug) {
		this.menuSlug = menuSlug;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

}
