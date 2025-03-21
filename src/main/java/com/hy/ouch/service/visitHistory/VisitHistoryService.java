package com.hy.ouch.service.visitHistory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.apiPayload.exception.UserNotFoundException;
import com.hy.ouch.apiPayload.exception.VisitHistoryNotFoundException;
import com.hy.ouch.converter.VisitHistoryConverter;
import com.hy.ouch.domain.Summary;
import com.hy.ouch.domain.mapping.VisitHistory;
import com.hy.ouch.dto.visitHistory.request.VisitHistoryCreateRequest;
import com.hy.ouch.dto.visitHistory.response.DateAndHospital;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryCreateResponse;
import com.hy.ouch.repository.department.DepartmentRepository;
import com.hy.ouch.repository.hospital.HospitalRepository;
import com.hy.ouch.repository.summary.SummaryRepository;
import com.hy.ouch.repository.user.UserRepository;
import com.hy.ouch.repository.visitHistory.VisitHistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitHistoryService {

	private final UserRepository userRepository;
	private final HospitalRepository hospitalRepository;
	private final DepartmentRepository departmentRepository;
	private final VisitHistoryRepository visitHistoryRepository;
	private final VisitHistoryConverter visitHistoryConverter;
	private final SummaryRepository summaryRepository;

	// @Transactional
	// public VisitHistoryCreateResponse createVisitHistory(VisitHistoryCreateRequest request, Long userId) {
	//
	// 	// 1. VisitHistory 먼저 저장
	// 	VisitHistory visitHistory = visitHistoryRepository.save(
	// 		VisitHistory.builder()
	// 			.user(userRepository.findById(userId)
	// 				.orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found")))
	// 			.visitDate(request.getVisitDate())
	// 			.hospital(hospitalRepository.findByName(request.getVisitingHospital()))
	// 			.department(departmentRepository.findByName(request.getMedicalSubject()))
	// 			.symptoms(request.getSymptoms())
	// 			.build()
	// 	);
	//
	// 	// 2. Summary 저장 (visitHistory를 넘기기)
	// 	summaryRepository.save(
	// 		Summary.builder()
	// 			.visitHistory(visitHistory)  // visitHistory를 직접 전달
	// 			.contents(request.getTreatmentSummary())
	// 			.contents_summary(request.getTreatmentSummary())
	// 			.build()
	// 	);
	//
	// 	visitHistoryRepository.save(visitHistory); // VisitHistory 다시 저장하여 Summary 연관 관계 반영
	//
	// 	return visitHistoryConverter.visitHistory2VisitHistoryResponse(visitHistory);
	// }

	// 의료 기록 생성
	@Transactional
	public VisitHistoryCreateResponse createVisitHistory(VisitHistoryCreateRequest request, Long userId) {
		// 1. VisitHistory 먼저 저장
		VisitHistory visitHistory = VisitHistory.builder()
			.user(userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found")))
			.visitDate(request.getVisitDate())
			.hospital(hospitalRepository.findByName(request.getVisitingHospital()))
			.department(departmentRepository.findByName(request.getMedicalSubject()))
			.symptoms(request.getSymptoms())
			.build();

		visitHistory = visitHistoryRepository.save(visitHistory); // 먼저 저장

		// 2. Summary 저장
		Summary summary = Summary.builder()
			.visitHistory(visitHistory)
			.contents(request.getTreatmentSummary())
			.contents_summary(request.getTreatmentSummary())
			.build();

		summaryRepository.save(summary); // Summary 저장

		visitHistory.setSummary(summary);
		visitHistoryRepository.save(visitHistory); // VisitHistory 다시 저장하여 Summary 연관 관계 반영

		return visitHistoryConverter.visitHistory2VisitHistoryCreateResponse(visitHistory);
	}

	//특정 사용자의 모든 의료기록 조회
	@Transactional
	public List<DateAndHospital> getUsersAllVisitHistory(Long userId) {
		List<VisitHistory> visitHistory = visitHistoryRepository.findAllByUserId(userId);
		return visitHistoryConverter.visitHistory2GetUsersAllVisitHistoryResponse(visitHistory);
	}

	//특정 의료기록 삭제
	@Transactional
	public void deleteVisitHistory(Long visitHistoryId) {
		VisitHistory visitHistory = visitHistoryRepository.findById(visitHistoryId)
			.orElseThrow(
				() -> new VisitHistoryNotFoundException("VisitHistory with ID " + visitHistoryId + " not found"));

		visitHistoryRepository.delete(visitHistory);
	}
}
