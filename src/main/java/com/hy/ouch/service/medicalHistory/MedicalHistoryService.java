package com.hy.ouch.service.medicalHistory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.apiPayload.code.error.MedicalHistoryErrorCode;
import com.hy.ouch.apiPayload.exception.OuchException;
import com.hy.ouch.converter.MedicalHistoryConverter;
import com.hy.ouch.domain.MedicalHistory;
import com.hy.ouch.dto.medicalHistory.request.MedicalHistoryCreateRequest;
import com.hy.ouch.dto.medicalHistory.response.GetUsersAllMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryCreateResponse;
import com.hy.ouch.repository.medicalHistory.MedicalHistoryRepository;
import com.hy.ouch.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalHistoryService {

	private final UserRepository userRepository;
	private final MedicalHistoryConverter medicalHistoryConverter;
	private final MedicalHistoryRepository medicalHistoryRepository;

	@Transactional
	public MedicalHistoryCreateResponse createMedicalHistory(MedicalHistoryCreateRequest request, Long userId) {
		MedicalHistory medicalHistory = MedicalHistory.builder()
			.user(userRepository.findById(userId)
				.orElseThrow(() -> new OuchException(MedicalHistoryErrorCode.USER_NOT_FOUND)))
			.disease(request.getDisease())
			.allergy(request.getAllergy())
			.bloodPressure(request.getBloodPressure())
			.bloodSugar(request.getBloodSugar())
			.medicineHistory(request.getMedicineHistory())
			.build();

		medicalHistoryRepository.save(medicalHistory);

		return medicalHistoryConverter.medicalHistory2MedicalHistoryResponse(medicalHistory);
	}

	@Transactional
	public GetUsersAllMedicalHistoryResponse getUserMedicalHistory(Long userId) {
		List<MedicalHistory> medicalHistory = medicalHistoryRepository.findAllByUserId(userId);
		return medicalHistoryConverter.medicalHistory2GetUserMedicalHistoryResponse(userId, medicalHistory);
	}
}
