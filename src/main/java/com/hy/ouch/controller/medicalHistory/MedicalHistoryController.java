package com.hy.ouch.controller.medicalHistory;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.ouch.dto.medicalHistory.request.MedicalHistoryCreateRequest;
import com.hy.ouch.dto.medicalHistory.request.MedicalHistoryUpdateRequest;
import com.hy.ouch.dto.medicalHistory.response.GetMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.GetUsersAllMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryCreateResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryUpdateResponse;
import com.hy.ouch.service.medicalHistory.MedicalHistoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/health-status")
@RequiredArgsConstructor
public class MedicalHistoryController {

	private final MedicalHistoryService medicalHistoryService;

	//건강상태 생성
	@PostMapping("/{userId}")
	public MedicalHistoryCreateResponse createMedicalHistory(@RequestBody @Valid MedicalHistoryCreateRequest request,
		@PathVariable Long userId) {
		return medicalHistoryService.createMedicalHistory(request, userId);
	}

	//특정 건강상태 조회
	@GetMapping("/{userId}/{medicalHistoryId}")
	public GetMedicalHistoryResponse getMedicalHistory(@PathVariable Long userId, @PathVariable Long medicalHistoryId) {
		return medicalHistoryService.getMedicalHistory(userId, medicalHistoryId);
	}

	//특정 사용자의 모든 건강상태 조회
	@GetMapping("/{userId}")
	public GetUsersAllMedicalHistoryResponse getUsersAllMedicalHistory(@PathVariable Long userId) {
		return medicalHistoryService.getUsersAllMedicalHistory(userId);
	}

	//특정 건강상태 수정
	@PutMapping("/{userId}/{medicalHistoryId}")
	public MedicalHistoryUpdateResponse updateMedicalHistory(@RequestBody @Valid MedicalHistoryUpdateRequest request,
		@PathVariable Long userId, @PathVariable Long medicalHistoryId) {
		return medicalHistoryService.updateMedicalHistory(request, userId, medicalHistoryId);
	}

	//특정 건강상태 삭제
	@DeleteMapping("/{userId}/{medicalHistoryId}")
	public void deleteMedicalHistory(@PathVariable Long userId, @PathVariable Long medicalHistoryId) {
		medicalHistoryService.deleteMedicalHistory(userId, medicalHistoryId);
	}
}
