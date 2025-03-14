package com.hy.ouch.apiPayload.code.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MedicalHistoryErrorCode implements ErrorCode {

	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEDICAL-HISTORY400", "User not found."),
	MEDICAL_HISTORY_NOT_FOUND(HttpStatus.NOT_FOUND, "MEDICAL-HISTORY401", "Medical history not found.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
