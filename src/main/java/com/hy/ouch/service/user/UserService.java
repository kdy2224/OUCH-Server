package com.hy.ouch.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.domain.Language;
import com.hy.ouch.domain.Nation;
import com.hy.ouch.domain.User;
import com.hy.ouch.domain.enums.UserStatus;
import com.hy.ouch.dto.language.request.AllLangsRequest;
import com.hy.ouch.dto.language.response.UserLangResponse;
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.AllUsersResponse;
import com.hy.ouch.dto.user.response.UserInfoResponse;
import com.hy.ouch.dto.user.response.UserSignupResponse;
import com.hy.ouch.repository.language.LanguageRepository;
import com.hy.ouch.repository.user.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final LanguageRepository languageRepository;

	public UserService(UserRepository userRepository, LanguageRepository languageRepository) {
		this.userRepository = userRepository;
		this.languageRepository = languageRepository;
	}

	@Transactional
	public UserSignupResponse saveUser(UserCreateRequest request) {
		User user = User.builder()
			.loginId(request.getLoginId())
			.password(request.getPassword())
			.name(request.getName())
			.nickname(request.getNickname())
			.phoneNumber(request.getPhoneNumber())
			.gender(request.getGender())
			.birthday(request.getBirthday())
			.email(request.getEmail())
			.language(new Language(request.getLanguageId(), " ", null))
			.nation(new Nation(request.getNationId(), null))
			.address(request.getAddress())
			.status(UserStatus.ACTIVE)
			.build();

		userRepository.save(user);

		return new UserSignupResponse(user.getId(), user.getCreatedAt());
	}

	@Transactional(readOnly = true)
	public List<AllUsersResponse> getUsers1() {
		List<User> users = userRepository.findAll();
		return users.stream()
			.map(user -> new AllUsersResponse(user.getId(), user.getLoginId(), user.getPassword(),
				user.getName(), user.getNickname(), user.getPhoneNumber(), user.getBirthday(),
				user.getEmail(), user.getAddress(), user.getStatus()))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<User> getUsers2() {
		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public UserInfoResponse getUserInfo(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return new UserInfoResponse(user.getLoginId(), user.getPassword(), user.getName(), user.getNickname(),
			user.getPhoneNumber(), user.getGender(), user.getBirthday(), user.getEmail(), user.getLanguage().getId(),
			user.getNation().getId());
	}

	@Transactional
	public void updateUser(Long id, UserCreateRequest request) {
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

	@Transactional(readOnly = true)
	public List<AllLangsRequest> getLanguages() {
		List<Language> languages = languageRepository.findAll();
		return languages.stream()
			.map(language -> new AllLangsRequest(language.getId(), language.getName()))
			.collect(Collectors.toList());
	}

	@Transactional
	public void saveUserLanguage(Long userId, Long languageId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		Language language = languageRepository.findById(languageId)
			.orElseThrow(() -> new RuntimeException("Language not found"));

		user.setLanguage(language);
	}

	@Transactional(readOnly = true)
	public UserLangResponse getUserLanguage(Long userId) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new RuntimeException("User not found"));
		return new UserLangResponse(user.getLanguage().getId(), user.getLanguage().getName());
	}

	@Transactional
	public void deactivateUser(Long userId) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new RuntimeException("User not found"));
		user.setStatus(UserStatus.INACTIVE);
	}
}






































