package com.motorBackened.motor_backened.response;

import com.motorBackened.motor_backened.Enums.Statuses;
import com.motorBackened.motor_backened.entity.MenuMaster;

public class MenuMasterResponse {
	private Long menuId;
	private String menuName;
	private String menuSlug;
	private String menuUrl;
	private String menuIcon;
	private int parentId;
	private Statuses status;

	public MenuMasterResponse(MenuMaster menu) {
		this.menuId = menu.getMenuId();
		this.menuName = menu.getMenuName();
		this.menuSlug = menu.getMenuSlug();
		this.menuUrl = menu.getMenuUrl();
		this.menuIcon = menu.getMenuIcon();
		this.parentId = menu.getParentId();
		this.status = menu.getStatus();
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

}
