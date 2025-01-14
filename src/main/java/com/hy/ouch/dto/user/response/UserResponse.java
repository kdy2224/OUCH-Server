package com.hy.ouch.dto.user.response;

import java.time.LocalDate;

import com.hy.ouch.domain.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private String loginId;

	private String password;

	private String name;

	private String nickname;

	private String phoneNumber;

	private LocalDate birthday;

	private String email;

	private String address;

	private UserStatus status;

	public UserResponse(String address, LocalDate birthday, String email, String loginId, String name, String nickname,
		String password, String phoneNumber, UserStatus status) {
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.loginId = loginId;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
}
