package com.motorBackened.motor_backened.Service;

import java.util.List;

import com.motorBackened.motor_backened.entity.Users;
import com.motorBackened.motor_backened.request.UserRequest;
import com.motorBackened.motor_backened.response.UserResponse;

import jakarta.validation.Valid;

public interface UsersService {
	
    Users addUser(UserRequest request);

	Users updateUser(@Valid UserRequest request,long id);

	UserResponse getUserById(Long userId);

	List<UserResponse> getAllUsers();

	String deleteUserById(Long id);




}
