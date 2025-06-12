package com.motorBackened.motor_backened.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorBackened.motor_backened.Service.RoleService;
import com.motorBackened.motor_backened.entity.RoleMaster;
import com.motorBackened.motor_backened.request.RoleRequestDto;
import com.motorBackened.motor_backened.response.ApiResponse;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@DeleteMapping("delete/{id}")
	public ResponseEntity<ApiResponse<String>> deleteRole(@PathVariable Long id) {
		try {
			roleService.deleteRoleById(id);
			return ResponseEntity.ok(new ApiResponse<>("success", null, "Role deleted successfully"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(new ApiResponse<>("error", null, e.getMessage()));
		}
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<RoleMaster>> addRole(@RequestBody RoleRequestDto dto) {
		try {
			RoleMaster savedRole = roleService.addRole(dto);
			ApiResponse<RoleMaster> response = new ApiResponse<>("success", savedRole, "Role created successfully");
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			ApiResponse<RoleMaster> response = new ApiResponse<>("error", null, e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ApiResponse<RoleMaster>> updateRole(@PathVariable Long id, @RequestBody RoleRequestDto dto) {
		try {
			RoleMaster updatedRole = roleService.updateRole(id, dto);
			return ResponseEntity.ok(new ApiResponse<>("success", updatedRole, "Role updated successfully"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(new ApiResponse<>("error", null, e.getMessage()));
		}
	}

	@GetMapping("list_all")
	public ResponseEntity<ApiResponse<List<RoleMaster>>> listAllRoles() {
		List<RoleMaster> roles = roleService.getAllRoles();
		return ResponseEntity.ok(new ApiResponse<>("success", roles, "Roles fetched successfully"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<RoleMaster>> getRoleById(@PathVariable Long id) {
		try {
			RoleMaster role = roleService.getRoleById(id);
			return ResponseEntity.ok(new ApiResponse<>("success", role, "Role fetched successfully"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(new ApiResponse<>("error", null, e.getMessage()));
		}
	}

}
