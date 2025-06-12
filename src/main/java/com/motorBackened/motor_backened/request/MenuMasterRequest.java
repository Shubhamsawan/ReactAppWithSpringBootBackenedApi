package com.motorBackened.motor_backened.request;

import com.motorBackened.motor_backened.Enums.Statuses;

public class MenuMasterRequest {

	   private String menuName;
	    private int parentId;
	    private String menuSlug;
	    private String menuUrl;
	    private String menuIcon;
	    
	    private Statuses status;

		public MenuMasterRequest() {
			super();
			// TODO Auto-generated constructor stub
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

		
	    

}
