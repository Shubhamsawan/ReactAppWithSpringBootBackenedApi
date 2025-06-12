package com.motorBackened.motor_backened.Service;

import com.motorBackened.motor_backened.request.LoginRequest;
import com.motorBackened.motor_backened.response.LoginResponse;

public interface LoginAuthService {

	LoginResponse login(LoginRequest request);

}
