package com.hy.ouch.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hy.ouch.domain.MedicalHistory;
import com.hy.ouch.dto.medicalHistory.response.DateAndDisease;
import com.hy.ouch.dto.medicalHistory.response.GetMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.GetUsersAllMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryCreateResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryUpdateResponse;

@Component
public class MedicalHistoryConverter {
	public MedicalHistoryCreateResponse medicalHistory2MedicalHistoryResponse(MedicalHistory medicalHistory,
		Long userId) {
		return new MedicalHistoryCreateResponse(medicalHistory.getId(), userId,
			medicalHistory.getDisease(),
			medicalHistory.getAllergy(),
			medicalHistory.getBloodPressure(), medicalHistory.getBloodSugar(), medicalHistory.getMedicineHistory());
	}

	public GetUsersAllMedicalHistoryResponse medicalHistory2GetUsersAllMedicalHistoryResponse(
		List<MedicalHistory> medicalHistory) {

		List<DateAndDisease> list = new ArrayList<>();

		for (MedicalHistory history : medicalHistory) {
			list.add(new DateAndDisease(history.getId(), history.getUpdatedAt().toString(), history.getDisease()));
		}

		return new GetUsersAllMedicalHistoryResponse(list);
	}

	public GetMedicalHistoryResponse medicalHistory2GetMedicalHistoryResponse(MedicalHistory medicalHistory) {
		return new GetMedicalHistoryResponse(medicalHistory.getId(), medicalHistory.getDisease(),
			medicalHistory.getAllergy(), medicalHistory.getBloodPressure(), medicalHistory.getBloodSugar(),
			medicalHistory.getMedicineHistory());
	}

	public MedicalHistoryUpdateResponse medicalHistory2MedicalHistoryUpdateResponse(MedicalHistory medicalHistory,
		Long userId) {
		return new MedicalHistoryUpdateResponse(medicalHistory.getId(), userId, medicalHistory.getDisease(),
			medicalHistory.getAllergy(), medicalHistory.getBloodPressure(), medicalHistory.getBloodSugar(),
			medicalHistory.getMedicineHistory());
	}
}
