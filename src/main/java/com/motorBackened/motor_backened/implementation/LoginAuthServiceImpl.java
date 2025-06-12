package com.motorBackened.motor_backened.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.motorBackened.motor_backened.Enums.Statuses;
import com.motorBackened.motor_backened.Service.LoginAuthService;
import com.motorBackened.motor_backened.entity.UserRelation;
import com.motorBackened.motor_backened.entity.Users;
import com.motorBackened.motor_backened.repository.UserRelationRepository;
import com.motorBackened.motor_backened.repository.UsersRepository;
import com.motorBackened.motor_backened.request.LoginRequest;
import com.motorBackened.motor_backened.response.LoginResponse;
@Service
public class LoginAuthServiceImpl implements LoginAuthService {
	
	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRelationRepository userRelationRepository; // To fetch role

	public LoginResponse login(LoginRequest request) {
	    Users user = userRepository.findByEmailAndStatus(request.getEmail(), Statuses.Y)
	        .orElseThrow(() -> new IllegalArgumentException("User not found or inactive"));

	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	        throw new IllegalArgumentException("Invalid credentials");
	    }

	    // Get role from UserRelation
	    UserRelation userRelation = userRelationRepository.findByUser(user)
	        .orElseThrow(() -> new IllegalArgumentException("User role not assigned"));

	    return new LoginResponse(
	        user.getUserId(),
	        user.getName(),
	        
	        user.getEmail(),
	        userRelation.getRole().getName()
	    );
	}


}
