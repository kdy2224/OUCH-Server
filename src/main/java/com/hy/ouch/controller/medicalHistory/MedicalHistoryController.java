package com.hy.ouch.controller.medicalHistory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.ouch.dto.medicalHistory.request.MedicalHistoryCreateRequest;
import com.hy.ouch.dto.medicalHistory.response.GetUsersAllMedicalHistoryResponse;
import com.hy.ouch.dto.medicalHistory.response.MedicalHistoryCreateResponse;
import com.hy.ouch.service.medicalHistory.MedicalHistoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/health-status")
@RequiredArgsConstructor
public class MedicalHistoryController {

	private final MedicalHistoryService medicalHistoryService;

	@PostMapping("/{userId}")
	public MedicalHistoryCreateResponse createMedicalHistory(@RequestBody @Valid MedicalHistoryCreateRequest request,
		@PathVariable Long userId) {
		return medicalHistoryService.createMedicalHistory(request, userId);
	}

	@GetMapping("/{userId}")
	public GetUsersAllMedicalHistoryResponse getUserMedicalHistory(@PathVariable Long userId) {
		return medicalHistoryService.getUserMedicalHistory(userId);
	}
}
