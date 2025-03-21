package com.hy.ouch.service.medicalHistory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.apiPayload.exception.MedicalHistoryNotFoundException;
import com.hy.ouch.apiPayload.exception.UserNotFoundException;
import com.hy.ouch.converter.MedicalHistoryConverter;
import com.hy.ouch.domain.MedicalHistory;
import com.hy.ouch.dto.medicalHistory.request.MedicalHistoryCreateRequest;
import com.hy.ouch.dto.medicalHistory.request.MedicalHistoryUpdateRequest;
import com.hy.ouch.dto.medicalHistory.response.GetMedicalHistoryResponse;
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

	//건강상태 생성
	@Transactional
	public MedicalHistoryCreateResponse createMedicalHistory(MedicalHistoryCreateRequest request, Long userId) {
		MedicalHistory medicalHistory = MedicalHistory.builder()
			.user(userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found")))
			.disease(request.getDisease())
			.allergy(request.getAllergy())
			.bloodPressure(request.getBloodPressure())
			.bloodSugar(request.getBloodSugar())
			.medicineHistory(request.getMedicineHistory())
			.build();

		medicalHistoryRepository.save(medicalHistory);

		return medicalHistoryConverter.medicalHistory2MedicalHistoryResponse(medicalHistory, userId);
	}

	//특정 건강상태 조회
	@Transactional
	public GetMedicalHistoryResponse getMedicalHistory(Long medicalHistoryId) {
		MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId)
			.orElseThrow(
				() -> new MedicalHistoryNotFoundException("MedicalHistory with ID " + medicalHistoryId + " not found"));
		return medicalHistoryConverter.medicalHistory2GetMedicalHistoryResponse(medicalHistory);
	}

	//특정 사용자의 모든 건강상태 조회
	@Transactional
	public GetUsersAllMedicalHistoryResponse getUsersAllMedicalHistory(Long userId) {
		List<MedicalHistory> medicalHistory = medicalHistoryRepository.findAllByUserId(userId);
		return medicalHistoryConverter.medicalHistory2GetUsersAllMedicalHistoryResponse(medicalHistory);
	}

	//특정 건강상태 수정
	@Transactional
	public void updateMedicalHistory(MedicalHistoryUpdateRequest request,
		Long medicalHistoryId) {
		MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId)
			.orElseThrow(
				() -> new MedicalHistoryNotFoundException("MedicalHistory with ID " + medicalHistoryId + " not found"));

		MedicalHistory updatedMedicalHistory = medicalHistory.toBuilder()
			.disease(request.getDisease())
			.allergy(request.getAllergy())
			.bloodPressure(request.getBloodPressure())
			.bloodSugar(request.getBloodSugar())
			.medicineHistory(request.getMedicineHistory())
			.build();

		medicalHistoryRepository.save(updatedMedicalHistory);
	}

	//특정 건강상태 삭제
	@Transactional
	public void deleteMedicalHistory(Long medicalHistoryId) {
		MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId)
			.orElseThrow(
				() -> new MedicalHistoryNotFoundException("MedicalHistory with ID " + medicalHistoryId + " not found"));

		medicalHistoryRepository.delete(medicalHistory);
	}
}
