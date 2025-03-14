package com.hy.ouch.converter;

import org.springframework.stereotype.Component;

import com.hy.ouch.domain.mapping.VisitHistory;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryCreateResponse;

@Component
public class VisitHistoryConverter {
	public VisitHistoryCreateResponse visitHistory2VisitHistoryResponse(VisitHistory visitHistory) {
		return new VisitHistoryCreateResponse(visitHistory.getId(), visitHistory.getVisitDate(),
			visitHistory.getHospital().getName(),
			visitHistory.getDepartment().getName(), visitHistory.getSymptoms(),
			visitHistory.getSummary().getContents());
	}
}
