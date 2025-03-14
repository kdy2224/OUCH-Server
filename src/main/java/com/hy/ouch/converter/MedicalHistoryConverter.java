package com.hy.ouch.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hy.ouch.domain.MedicalHistory;
import com.hy.ouch.dto.medicalHistory.response.DateAndDisease;
import com.hy.ouch.dto.medicalHistory.response.GetUsersAllMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryCreateResponse;

@Component
public class MedicalHistoryConverter {
	public MedicalHistoryCreateResponse medicalHistory2MedicalHistoryResponse(MedicalHistory medicalHistory) {
		return new MedicalHistoryCreateResponse(medicalHistory.getId(), medicalHistory.getDisease(),
			medicalHistory.getAllergy(),
			medicalHistory.getBloodPressure(), medicalHistory.getBloodSugar(), medicalHistory.getMedicineHistory());
	}

	public GetUsersAllMedicalHistoryResponse medicalHistory2GetUserMedicalHistoryResponse(
		long userId, List<MedicalHistory> medicalHistory) {

		List<DateAndDisease> list = new ArrayList<>();

		for (MedicalHistory history : medicalHistory) {
			list.add(new DateAndDisease(history.getUpdatedAt().toString(), history.getDisease()));
		}

		return new GetUsersAllMedicalHistoryResponse(userId, list);
	}
}
