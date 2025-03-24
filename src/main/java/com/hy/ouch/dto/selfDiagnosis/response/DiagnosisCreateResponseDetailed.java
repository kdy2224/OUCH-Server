package com.hy.ouch.dto.selfDiagnosis.response;

import java.util.List;

import com.hy.ouch.domain.enums.SymptomDuration;
import com.hy.ouch.domain.enums.VisitType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiagnosisCreateResponseDetailed {

	private Long id;
	private Long userId;
	private VisitType visitType;
	private List<String> symptoms;
	private SymptomDuration duration;
	private Integer painSeverity;
	private String additionalNote;
	private String createdAt;

}
