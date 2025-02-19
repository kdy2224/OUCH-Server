package com.hy.ouch.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.converter.UserConverter;
import com.hy.ouch.domain.Language;
import com.hy.ouch.domain.Nation;
import com.hy.ouch.domain.User;
import com.hy.ouch.domain.enums.UserStatus;
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.UserInfoResponse;
import com.hy.ouch.dto.user.response.UserSignupResponse;
import com.hy.ouch.repository.language.LanguageRepository;
import com.hy.ouch.repository.nation.NationRepository;
import com.hy.ouch.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final LanguageRepository languageRepository;
	private final NationRepository nationRepository;
	private final UserConverter userConverter;

	@Transactional
	public UserSignupResponse saveUser(UserCreateRequest request) {

		Language wantedLanguage = languageRepository.findById(request.getLanguageId())
			.orElseThrow(() -> new RuntimeException("Language not found"));

		Nation wantedNation = nationRepository.findById(request.getNationId())
			.orElseThrow(() -> new RuntimeException("Nation not found"));

		User user = User.builder()
			.loginId(request.getLoginId())
			.password(request.getPassword())
			.name(request.getName())
			.nickname(request.getNickname())
			.phoneNumber(request.getPhoneNumber())
			.gender(request.getGender())
			.birthday(request.getBirthday())
			.email(request.getEmail())
			.language(wantedLanguage)
			.nation(wantedNation)
			.status(UserStatus.ACTIVE)
			.build();

		userRepository.save(user);

		return userConverter.user2UserSignupResponse(user);
	}

	@Transactional(readOnly = true)
	public UserInfoResponse getUserInfo(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		return userConverter.user2UserInfoResponse(user);
	}

	@Transactional
	public void deactivateUser(Long userId) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new RuntimeException("User not found"));

		User deactivatedUser = user.toBuilder()
			.status(UserStatus.INACTIVE)
			.build();

		userRepository.save(deactivatedUser);
	}

	@Transactional
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		userRepository.delete(user);
	}

}






































