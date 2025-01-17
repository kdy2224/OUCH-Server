package com.hy.ouch.dto.user.request;

import com.hy.ouch.domain.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MypageUserInfoUpdateRequest {

	private String nickname;

	private String phoneNumber;

	private Gender gender;

	private String email;

	private Long nationId;
}
