package com.hy.ouch.dto.selfDiagnosis.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSymptomsToDiagnosisRequest {

	private List<String> symptoms;
}
