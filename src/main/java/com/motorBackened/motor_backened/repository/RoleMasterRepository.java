package com.motorBackened.motor_backened.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motorBackened.motor_backened.entity.RoleMaster;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long> {

	boolean existsByName(String name);

}
