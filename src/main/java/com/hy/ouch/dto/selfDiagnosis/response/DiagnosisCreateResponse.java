package com.hy.ouch.dto.selfDiagnosis.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiagnosisCreateResponse {

	private Long diagnosisId;
	private String message;
}
