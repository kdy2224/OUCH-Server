package com.hy.ouch.dto.user.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

	private String loginId;

	private String password;

	private String name;

	private String nickname;

	private String phoneNumber;

	private LocalDate birthday;

	private String email;

	private String address;

	// private UserStatus status;
}
