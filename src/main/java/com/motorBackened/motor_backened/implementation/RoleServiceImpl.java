package com.motorBackened.motor_backened.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorBackened.motor_backened.Service.RoleService;
import com.motorBackened.motor_backened.entity.RoleMaster;
import com.motorBackened.motor_backened.repository.RoleMasterRepository;
import com.motorBackened.motor_backened.request.RoleRequestDto;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMasterRepository roleRepository;

	public List<RoleMaster> getAllRoles() {
		List<RoleMaster> findAll = roleRepository.findAll();
		return findAll;
	}

	public RoleMaster getRoleById(Long id) {
		RoleMaster roleOrElseThrow = roleRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));
		return roleOrElseThrow;

	}

	public RoleMaster addRole(RoleRequestDto dto) {
		if (roleRepository.existsByName(dto.getName())) {
			throw new IllegalArgumentException("Role with name already exists.");
		}

		RoleMaster role = new RoleMaster();
		role.setName(dto.getName());
		role.setGaurdName(dto.getGaurdName());
		RoleMaster save = roleRepository.save(role);
		return save;
	}

	public RoleMaster updateRole(Long id, RoleRequestDto dto) {
	    RoleMaster existingRole = roleRepository.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));

	    existingRole.setName(dto.getName());
	    existingRole.setGaurdName(dto.getGaurdName());
	    RoleMaster save = roleRepository.save(existingRole);
	    return save;
	}
	
	public void deleteRoleById(Long id) {
	    RoleMaster existingRole = roleRepository.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));

	    roleRepository.delete(existingRole);
	}


}
