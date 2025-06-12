package com.motorBackened.motor_backened.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motorBackened.motor_backened.entity.UserRelation;
import com.motorBackened.motor_backened.entity.Users;

public interface UserRelationRepository extends JpaRepository<UserRelation, Long> {

	Optional<UserRelation> findByUser(Users user);

}
