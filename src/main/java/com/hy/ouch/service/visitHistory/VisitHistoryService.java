package com.hy.ouch.service.visitHistory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.ouch.apiPayload.code.error.VisitHistoryErrorCode;
import com.hy.ouch.apiPayload.exception.OuchException;
import com.hy.ouch.converter.VisitHistoryConverter;
import com.hy.ouch.domain.Summary;
import com.hy.ouch.domain.mapping.VisitHistory;
import com.hy.ouch.dto.visitHistory.request.VisitHistoryCreateRequest;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryCreateResponse;
import com.hy.ouch.repository.department.DepartmentRepository;
import com.hy.ouch.repository.hospital.HospitalRepository;
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

	@Transactional
	public VisitHistoryCreateResponse createVisitHistory(VisitHistoryCreateRequest request, Long userId) {

		VisitHistory visitHistory = VisitHistory.builder()
			.user(userRepository.findById(userId)
				.orElseThrow(() -> new OuchException(VisitHistoryErrorCode.USER_NOT_FOUND)))
			.visitDate(request.getVisitDate())
			.hospital(hospitalRepository.findByName(request.getVisitingHospital()))
			.department(departmentRepository.findByName(request.getMedicalSubject()))
			.symptoms(request.getSymptoms())
			.build();

		Summary summary = Summary.builder()
			.visitHistory(visitHistory)
			.contents(request.getTreatmentSummary())
			.contents_summary(request.getTreatmentSummary())
			.build();

		visitHistory.setSummary(summary);
		
		visitHistoryRepository.save(visitHistory);

		return visitHistoryConverter.visitHistory2VisitHistoryResponse(visitHistory);
	}
}
