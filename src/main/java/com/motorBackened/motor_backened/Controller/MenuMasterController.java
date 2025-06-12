package com.motorBackened.motor_backened.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorBackened.motor_backened.Service.MenumasterService;
import com.motorBackened.motor_backened.request.MenuMasterRequest;
import com.motorBackened.motor_backened.response.ApiResponse;
import com.motorBackened.motor_backened.response.MenuMasterResponse;

@RestController
@RequestMapping("/menu")
public class MenuMasterController {

	@Autowired
	private MenumasterService menumasterService;

    @PostMapping("/add")
	public ResponseEntity<ApiResponse<MenuMasterResponse>> addMenu(@RequestBody MenuMasterRequest request) {
		MenuMasterResponse res = menumasterService.addMenu(request);
		return ResponseEntity.ok(new ApiResponse<>("success", res, "Menu added successfully"));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<MenuMasterResponse>> updateMenu(@PathVariable Long id,
			@RequestBody MenuMasterRequest request) {
		try {
			MenuMasterResponse res = menumasterService.updateMenu(id, request);
			return ResponseEntity.ok(new ApiResponse<>("success", res, "Menu updated successfully"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse<List<MenuMasterResponse>>> listMenus() {
	    List<MenuMasterResponse> menus = menumasterService.getAllMenus();
	    return ResponseEntity.ok(new ApiResponse<>("success", menus, "Menu list fetched successfully"));
	}

	@GetMapping("/listById/{id}")
	public ResponseEntity<ApiResponse<MenuMasterResponse>> getMenuById(@PathVariable Long id) {
	    try {
	        MenuMasterResponse menu = menumasterService.getMenuById(id);
	        return ResponseEntity.ok(new ApiResponse<>("success", menu, "Menu fetched successfully"));
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
	    }
	}

}
