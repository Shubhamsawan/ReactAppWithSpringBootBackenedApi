package com.motorBackened.motor_backened.Service;

import java.util.List;

import com.motorBackened.motor_backened.entity.RoleMaster;
import com.motorBackened.motor_backened.request.RoleRequestDto;

public interface RoleService {

	RoleMaster addRole(RoleRequestDto dto);

	List<RoleMaster> getAllRoles();

	RoleMaster getRoleById(Long id);

	RoleMaster updateRole(Long id, RoleRequestDto dto);

	void deleteRoleById(Long id);

}
