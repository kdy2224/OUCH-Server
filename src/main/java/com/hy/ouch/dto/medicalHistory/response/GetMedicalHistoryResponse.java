package com.hy.ouch.dto.medicalHistory.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetMedicalHistoryResponse {

	private Long id;
	private String disease;
	private String allergy;
	private Long bloodPressure;
	private Long bloodSugar;
	private String medicineHistory;
}
