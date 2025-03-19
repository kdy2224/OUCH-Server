package com.hy.ouch.dto.medicalHistory.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicalHistoryUpdateResponse {
	private Long id;
	private Long userId;
	private String disease;
	private String allergy;
	private Long bloodPressure;
	private Long bloodSugar;
	private String medicineHistory;
}
