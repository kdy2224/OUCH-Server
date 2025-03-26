package com.hy.ouch.apiPayload.code.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MypageErrorCode implements ErrorCode {

	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "MYPAGE400", "User not found."),
	NATION_NOT_FOUND(HttpStatus.NOT_FOUND, "MYPAGE400", "Nation not found."),
	;

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
