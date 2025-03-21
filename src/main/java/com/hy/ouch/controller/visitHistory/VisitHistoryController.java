package com.hy.ouch.controller.visitHistory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.ouch.dto.visitHistory.request.VisitHistoryCreateRequest;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryCreateResponse;
import com.hy.ouch.service.visitHistory.VisitHistoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/visit-history")
@RequiredArgsConstructor
public class VisitHistoryController {

	private final VisitHistoryService visitHistoryService;

	// 의료기록 생성
	@PostMapping("/{userId}")
	public VisitHistoryCreateResponse createVisitHistory(@RequestBody @Valid VisitHistoryCreateRequest request,
		@PathVariable Long userId) {
		return visitHistoryService.createVisitHistory(request, userId);
	}

	// 모든 의료기록 조회 (의료기록 메인 페이지용)
	@GetMapping("/{userId}")
	public VisitHistoryCreateResponse getUsersAllVisitHistory(@PathVariable Long userId) {
		return visitHistoryService.getUsersAllVisitHistory(userId);
	}

}
