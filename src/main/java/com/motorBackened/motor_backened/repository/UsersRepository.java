package com.motorBackened.motor_backened.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motorBackened.motor_backened.Enums.Statuses;
import com.motorBackened.motor_backened.entity.RoleMaster;
import com.motorBackened.motor_backened.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	boolean existsByEmail(String email);

	Optional<Users> findByUserIdAndStatus(Long userId, Statuses y);

	List<Users> findAllByStatus(Statuses y);

	Optional<Users> findByEmailAndStatus(String email, Statuses y);

}
