package com.motorBackened.motor_backened.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorBackened.motor_backened.Service.MenumasterService;
import com.motorBackened.motor_backened.entity.MenuMaster;
import com.motorBackened.motor_backened.repository.MenuMasterRequestRepoisitory;
import com.motorBackened.motor_backened.request.MenuMasterRequest;
import com.motorBackened.motor_backened.response.MenuMasterResponse;

@Service
public class MenuMasterImplementation implements MenumasterService {

	@Autowired
	private MenuMasterRequestRepoisitory menuRepo;

	public MenuMasterResponse addMenu(MenuMasterRequest request) {
		MenuMaster menu = new MenuMaster();
		menu.setMenuName(request.getMenuName());
		menu.setParentId(request.getParentId());
		menu.setMenuSlug(request.getMenuSlug());
		menu.setMenuUrl(request.getMenuUrl());
		menu.setMenuIcon(request.getMenuIcon());
		menu.setStatus(request.getStatus());

		MenuMaster saved = menuRepo.save(menu);
		return new MenuMasterResponse(saved);
	}

	public MenuMasterResponse updateMenu(Long id, MenuMasterRequest request) {
		MenuMaster menu = menuRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Menu not found"));

		menu.setMenuName(request.getMenuName());
		menu.setParentId(request.getParentId());
		menu.setMenuSlug(request.getMenuSlug());
		menu.setMenuUrl(request.getMenuUrl());
		menu.setMenuIcon(request.getMenuIcon());
		menu.setStatus(request.getStatus());

		MenuMaster updated = menuRepo.save(menu);
		return new MenuMasterResponse(updated);
	}
	
	public List<MenuMasterResponse> getAllMenus() {
//	    List<MenuMaster> menus = menuRepo.findAllByStatus(Statuses.Y); // or Statuses.Y
	    List<MenuMaster> menus = menuRepo.findAll();// or Statuses.Y

	    return menus.stream().map(MenuMasterResponse::new).collect(Collectors.toList());
	}

	public MenuMasterResponse getMenuById(Long id) {
	    MenuMaster menu = menuRepo.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Menu not found"));
	    return new MenuMasterResponse(menu);
	}

}


