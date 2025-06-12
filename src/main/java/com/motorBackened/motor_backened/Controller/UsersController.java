package com.motorBackened.motor_backened.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motorBackened.motor_backened.Service.UsersService;
import com.motorBackened.motor_backened.entity.Users;
import com.motorBackened.motor_backened.request.UserRequest;
import com.motorBackened.motor_backened.response.ApiResponse;
import com.motorBackened.motor_backened.response.UserResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UsersService userService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<Users>> addUser(@Valid @RequestBody UserRequest request) {
		try {
			Users user = userService.addUser(request);
			return ResponseEntity.ok(new ApiResponse<>("success", user, "User created successfully"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponse<>("error", null, "Something went wrong"));
		}
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<ApiResponse<Users>> updateUser(@RequestParam long userId,
			@Valid @RequestBody UserRequest request) {
		try {
			Users updatedUser = userService.updateUser(request, userId);
			return ResponseEntity.ok(new ApiResponse<>("success", updatedUser, "User updated successfully"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponse<>("error", null, "Something went wrong"));
		}
	}

	@GetMapping("/searchAll")
	public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
		List<UserResponse> users = userService.getAllUsers();
		return ResponseEntity.ok(new ApiResponse<>("success", users, "All users fetched successfully"));
	}

	@GetMapping("/listById/{id}")
	public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
		try {
			UserResponse user = userService.getUserById(id);
			return ResponseEntity.ok(new ApiResponse<>("success", user, "User found"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
	    try {
	        String msg = userService.deleteUserById(id);
	        return ResponseEntity.ok(new ApiResponse<>("success", null, msg));
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
	    }
	}


}
