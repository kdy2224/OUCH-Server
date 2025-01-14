package com.hy.ouch.dto.user.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private String loginId;

	private String name;

	private String nickname;

	private String phoneNumber;

	private LocalDate birthday;

	private String email;

	private String address;
}
