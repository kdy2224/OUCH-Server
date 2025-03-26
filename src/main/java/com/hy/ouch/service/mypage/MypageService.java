package com.hy.ouch.service.mypage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.apiPayload.code.error.MypageErrorCode;
import com.hy.ouch.apiPayload.exception.OuchException;
import com.hy.ouch.converter.UserConverter;
import com.hy.ouch.domain.Nation;
import com.hy.ouch.domain.User;
import com.hy.ouch.dto.mypage.request.MypageUserInfoUpdateRequest;
import com.hy.ouch.dto.user.response.MypageUserInfoResponse;
import com.hy.ouch.repository.nation.NationRepository;
import com.hy.ouch.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MypageService {

	private final UserRepository userRepository;
	private final NationRepository nationRepository;
	private final UserConverter userConverter;

	@Transactional(readOnly = true)
	public MypageUserInfoResponse myPageGetUserInfo(Long userId) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new OuchException(MypageErrorCode.USER_NOT_FOUND));
		return userConverter.user2MypageUserInfoResponse(user);
	}

	@Transactional
	public void myPageUpdateUserInfo(Long userId, MypageUserInfoUpdateRequest request) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new OuchException(MypageErrorCode.USER_NOT_FOUND));

		Nation wantedNation = nationRepository.findById(request.getNationId())
			.orElseThrow(() -> new OuchException(MypageErrorCode.NATION_NOT_FOUND));

		User updatedUser = user.toBuilder()
			.nickname(request.getNickname())
			.phoneNumber(request.getPhoneNumber())
			.gender(request.getGender())
			.email(request.getEmail())
			.nation(wantedNation)
			.build();

		userRepository.save(updatedUser);
	}
}
