package com.hy.ouch.security.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInRequest {
	private String loginId;
	private String password;
}
