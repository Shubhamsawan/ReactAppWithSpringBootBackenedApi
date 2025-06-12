package com.motorBackened.motor_backened.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.motorBackened.motor_backened.Enums.Statuses;
import com.motorBackened.motor_backened.Service.UsersService;
import com.motorBackened.motor_backened.entity.RoleMaster;
import com.motorBackened.motor_backened.entity.UserRelation;
import com.motorBackened.motor_backened.entity.Users;
import com.motorBackened.motor_backened.repository.RoleMasterRepository;
import com.motorBackened.motor_backened.repository.UserRelationRepository;
import com.motorBackened.motor_backened.repository.UsersRepository;
import com.motorBackened.motor_backened.request.UserRequest;
import com.motorBackened.motor_backened.response.UserResponse;

@Service
public class UsersServiceimpl implements UsersService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private RoleMasterRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRelationRepository userRelationRepository;

	@Override
	public Users addUser(UserRequest request) {
		if (!request.getPassword().equals(request.getConfirmPassword())) {
			throw new IllegalArgumentException("Passwords do not match");
		}

		RoleMaster role = roleRepository.findById(request.getRoleId())
				.orElseThrow(() -> new IllegalArgumentException("Role not found"));
		boolean existsByEmail = userRepository.existsByEmail(request.getEmail());
		if (existsByEmail) {
			throw new IllegalArgumentException("Email already exists......");
		}
		Users user = new Users();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setStatus(Statuses.Y);

		user = userRepository.save(user); // Save user first

		UserRelation userRelation = new UserRelation();
		userRelation.setUser(user);
		userRelation.setRole(role);

		userRelationRepository.save(userRelation); // Save user-role relation

		return user;
	}

	@Override
	public Users updateUser(UserRequest request, long id) {
		Users user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

		user.setName(request.getName());
		user.setEmail(request.getEmail());

		// If password fields are provided, validate and update
		if (request.getPassword() != null && !request.getPassword().isEmpty()) {
			if (!request.getPassword().equals(request.getConfirmPassword())) {
				throw new IllegalArgumentException("Passwords do not match");
			}
			user.setPassword(passwordEncoder.encode(request.getPassword()));
		}

		userRepository.save(user);

		// Update Role in UserRelation
		UserRelation userRelation = userRelationRepository.findAll().stream()
				.filter(ur -> ur.getUser().getUserId().equals(user.getUserId())).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("UserRelation not found"));

		RoleMaster role = roleRepository.findById(request.getRoleId())
				.orElseThrow(() -> new IllegalArgumentException("Role not found"));

		userRelation.setRole(role);
		user.setStatus(Statuses.Y);

		userRelationRepository.save(userRelation);

		return user;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		List<Users> users = userRepository.findAllByStatus(Statuses.Y);

		return users.stream().map(user -> {
			Optional<UserRelation> relationOpt = userRelationRepository.findById(user.getUserId());
			String roleName = "";
			Long roleId = null;

			if (relationOpt.isPresent()) {
				roleName = relationOpt.get().getRole().getName();
				roleId = relationOpt.get().getRole().getId();
			}

			return new UserResponse(user.getUserId(), user.getName(), user.getEmail(), roleId, roleName,
					user.getPassword(), user.getCreatedAt());
		}).collect(Collectors.toList());
	}

	@Override
	public UserResponse getUserById(Long userId) {
		Users user = userRepository.findByUserIdAndStatus(userId, Statuses.Y)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		UserRelation relation = userRelationRepository.findById(user.getUserId())
				.orElseThrow(() -> new IllegalArgumentException("UserRelation not found"));

		RoleMaster role = relation.getRole();

		return new UserResponse(user.getUserId(), user.getName(), user.getEmail(), role.getId(), role.getName(),
				user.getPassword(), user.getCreatedAt());
	}

	public String deleteUserById(Long userId) {
		Users user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		user.setStatus(Statuses.N);
		userRepository.save(user);

		return "User marked as DELETED successfully";
	}

}
