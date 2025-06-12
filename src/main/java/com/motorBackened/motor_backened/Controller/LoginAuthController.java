package com.motorBackened.motor_backened.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorBackened.motor_backened.Service.LoginAuthService;
import com.motorBackened.motor_backened.request.LoginRequest;
import com.motorBackened.motor_backened.response.ApiResponse;
import com.motorBackened.motor_backened.response.LoginResponse;

@RestController
@RequestMapping("api/auth") 
public class LoginAuthController {
	
	@Autowired
	private LoginAuthService authService; 
	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<LoginResponse>> loginUser(@RequestBody LoginRequest request) {
	    try {
	        LoginResponse response = authService.login(request);
	        return ResponseEntity.ok(new ApiResponse<>("success", response, "Login successful"));
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(new ApiResponse<>("error", null, e.getMessage()));
	    }
	}


}
