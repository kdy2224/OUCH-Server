package com.hy.ouch.dto.visitHistory.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitHistoryCreateRequest {

	@NotBlank(message = "Visit date is required.")
	private String visitDate;

	@NotBlank(message = "Visiting hospital is required.")
	private String visitingHospital;

	@NotBlank(message = "Medical subject is required.")
	private String medicalSubject;

	@NotBlank(message = "Symptoms are required.")
	private String symptoms;

	@NotBlank(message = "Treatment summary is required.")
	private String treatmentSummary;
}
