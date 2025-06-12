package com.motorBackened.motor_backened.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// FOr disable by default username password
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // ✅ correct way to disable CSRF
				.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).formLogin(form -> form.disable()) // disable
																												// login
																												// form
				.httpBasic(basic -> basic.disable()); // disable basic auth

		return http.build();
	}
}
