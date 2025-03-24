package com.hy.ouch.dto.selfDiagnosis.request;

import java.util.List;

import com.hy.ouch.domain.enums.SymptomDuration;
import com.hy.ouch.domain.enums.VisitType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiagnosisUpdateRequest {

	@NotNull(message = "Visit type is required.")
	private VisitType visitType;

	@NotEmpty(message = "At least one symptom is required.")
	private List<String> symptoms;

	@NotNull(message = "Symptom duration is required.")
	private SymptomDuration duration;

	@NotNull(message = "Pain severity is required.")
	@Min(value = 0, message = "통증 정도는 최소 0 이상이어야 합니다.")
	@Max(value = 10, message = "통증 정도는 최대 10 이하여야 합니다.")
	private Integer painSeverity;

	private String additionalNote;
}
