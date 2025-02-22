package com.hy.ouch.apiPayload.code.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiagnosisErrorCode implements ErrorCode {

	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "DIAGNOSIS400", "사용자를 찾을 수 없습니다."),
	SYMPTOM_NOT_FOUND(HttpStatus.NOT_FOUND, "DIAGNOSIS400", "증상을 찾을 수 없습니다."),
	DIAGNOSIS_NOT_FOUND(HttpStatus.NOT_FOUND, "DIAGNOSIS400", "진단서를 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
