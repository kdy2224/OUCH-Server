package com.hy.ouch.apiPayload.code.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VisitHistoryErrorCode implements ErrorCode {

	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "VISIT-HISTORY400", "User not found."),
	;

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
