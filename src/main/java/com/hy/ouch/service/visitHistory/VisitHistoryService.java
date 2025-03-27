package com.hy.ouch.service.visitHistory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.apiPayload.code.error.VisitHistoryErrorCode;
import com.hy.ouch.apiPayload.exception.OuchException;
import com.hy.ouch.converter.VisitHistoryConverter;
import com.hy.ouch.domain.Summary;
import com.hy.ouch.domain.User;
import com.hy.ouch.domain.mapping.VisitHistory;
import com.hy.ouch.dto.visitHistory.request.VisitHistoryCreateRequest;
import com.hy.ouch.dto.visitHistory.request.VisitHistoryUpdateRequest;
import com.hy.ouch.dto.visitHistory.response.DateAndHospital;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryCreateResponse;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryUpdateResponse;
import com.hy.ouch.repository.department.DepartmentRepository;
import com.hy.ouch.repository.hospital.HospitalRepository;
import com.hy.ouch.repository.summary.SummaryRepository;
import com.hy.ouch.repository.user.UserRepository;
import com.hy.ouch.repository.visitHistory.VisitHistoryRepository;

import jakarta.validation.Valid;
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

	//의료 기록 생성
	@Transactional
	public VisitHistoryCreateResponse createVisitHistory(VisitHistoryCreateRequest request, Long userId) {
		// 1. VisitHistory 먼저 저장
		VisitHistory visitHistory = VisitHistory.builder()
			.user(userRepository.findById(userId)
				.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.USER_NOT_FOUND)))
			.visitDate(request.getVisitDate())
			.hospital(hospitalRepository.findByName(request.getVisitingHospital())
				.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.HOSPITAL_NOT_FOUND)))
			.department(departmentRepository.findByName(request.getMedicalSubject())
				.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.DEPARTMENT_NOT_FOUND)))
			.symptoms(request.getSymptoms())
			.build();

		// 2. Summary 저장
		Summary summary = Summary.builder()
			.visitHistory(visitHistory)
			.contents(request.getTreatmentSummary())
			.contents_summary(request.getTreatmentSummary())
			.build();

		summary = summaryRepository.save(summary); // Summary 저장

		visitHistory.assignSummary(summary);

		visitHistoryRepository.save(visitHistory); // 다시 저장 (연관관계 반영)

		return visitHistoryConverter.visitHistory2VisitHistoryCreateResponse(visitHistory);
	}

	@Transactional
	public VisitHistoryUpdateResponse getVisitHistory(Long visitHistoryId) {
		VisitHistory visitHistory = visitHistoryRepository.findById(visitHistoryId)
			.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.VISIT_HISTORY_NOT_FOUND));

		return visitHistoryConverter.visitHistory2GetVisitHistoryResponse(visitHistory);
	}

	//특정 사용자의 모든 의료기록 조회
	@Transactional
	public List<DateAndHospital> getUsersAllVisitHistory(Long userId) {

		User user = userRepository.findById(userId)
			.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.USER_NOT_FOUND));

		List<VisitHistory> visitHistory = visitHistoryRepository.findAllByUserId(userId);
		return visitHistoryConverter.visitHistory2GetUsersAllVisitHistoryResponse(visitHistory);
	}

	//특정 의료기록 삭제
	@Transactional
	public void deleteVisitHistory(Long visitHistoryId) {
		VisitHistory visitHistory = visitHistoryRepository.findById(visitHistoryId)
			.orElseThrow(
				() -> new OuchException(VisitHistoryErrorCode.VISIT_HISTORY_NOT_FOUND));

		visitHistoryRepository.delete(visitHistory);
	}

	//특정 의료기록 수정
	//VisitHistory entity 클래스에 update 메서드를 추가하는 방식으로 바꿀까요?
	@Transactional
	public VisitHistoryUpdateResponse updateVisitHistory(@Valid VisitHistoryUpdateRequest request,
		Long visitHistoryId) {
		VisitHistory visitHistory = visitHistoryRepository.findById(visitHistoryId)
			.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.VISIT_HISTORY_NOT_FOUND));

		Summary summary = visitHistory.getSummary();

		VisitHistory updatedVisitHistory = visitHistory.toBuilder()
			.visitDate(request.getVisitDate())
			.hospital(hospitalRepository.findByName(request.getVisitingHospital())
				.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.HOSPITAL_NOT_FOUND))
			)
			.department(departmentRepository.findByName(request.getMedicalSubject())
				.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.DEPARTMENT_NOT_FOUND))
			)
			.symptoms(request.getSymptoms())
			.build();

		Summary updatedSummary = summary.toBuilder()
			.visitHistory(updatedVisitHistory)
			.contents(request.getTreatmentSummary())
			.contents_summary(request.getTreatmentSummary())
			.build();

		summary = summaryRepository.save(updatedSummary); // Summary 저장

		visitHistory.assignSummary(summary);

		visitHistoryRepository.save(updatedVisitHistory); // 다시 저장 (연관관계 반영)

		return visitHistoryConverter.visitHistory2VisitHistoryUpdateResponse(visitHistory);
	}

}
