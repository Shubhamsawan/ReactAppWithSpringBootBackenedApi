package com.motorBackened.motor_backened.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motorBackened.motor_backened.Enums.Statuses;
import com.motorBackened.motor_backened.entity.MenuMaster;

@Repository
public interface MenuMasterRequestRepoisitory extends JpaRepository<MenuMaster, Long> {

	List<MenuMaster> findAllByStatus(Statuses y);

}
