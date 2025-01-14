package com.hy.ouch.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.domain.User;
import com.hy.ouch.domain.enums.UserStatus;
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.UserInfo;
import com.hy.ouch.dto.user.response.UserResponse;
import com.hy.ouch.repository.user.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void saveUser(UserCreateRequest request) {
		User user = User.builder()
			.loginId(request.getLoginId())
			.password(request.getPassword())
			.name(request.getName())
			.nickname(request.getNickname())
			.phoneNumber(request.getPhoneNumber())
			.birthday(request.getBirthday())
			.email(request.getEmail())
			.address(request.getAddress())
			.status(UserStatus.ACTIVE)
			.build();

		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public List<UserResponse> getUsers1() {
		List<User> users = userRepository.findAll();
		return users.stream()
			.map(user -> new UserResponse(user.getAddress(), user.getBirthday(), user.getEmail(), user.getLoginId(),
				user.getName(), user.getNickname(), user.getPassword(), user.getPhoneNumber(), user.getStatus()))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<User> getUsers2() {
		return userRepository.findAll();
	}

	@Transactional
	public UserInfo getUserInfo(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return new UserInfo(user.getLoginId(), user.getName(), user.getNickname(), user.getPhoneNumber(),
			user.getBirthday(), user.getEmail(), user.getAddress());
	}

	@Transactional
	public void updatenUser(Long id, UserCreateRequest request) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		if (request.getLoginId() != null) {
			user.setLoginId(request.getLoginId());
		}
		if (request.getPassword() != null) {
			user.setPassword(request.getPassword());
		}
		if (request.getName() != null) {
			user.setName(request.getName());
		}
		if (request.getNickname() != null) {
			user.setNickname(request.getNickname());
		}
		if (request.getPhoneNumber() != null) {
			user.setPhoneNumber(request.getPhoneNumber());
		}
		if (request.getBirthday() != null) {
			user.setBirthday(request.getBirthday());
		}
		if (request.getEmail() != null) {
			user.setEmail(request.getEmail());
		}
		if (request.getAddress() != null) {
			user.setAddress(request.getAddress());
		}
	}

	@Transactional
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		userRepository.delete(user);
	}
}



















