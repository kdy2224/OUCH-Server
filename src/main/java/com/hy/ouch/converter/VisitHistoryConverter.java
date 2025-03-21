package com.hy.ouch.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hy.ouch.domain.mapping.VisitHistory;
import com.hy.ouch.dto.visitHistory.response.DateAndHospital;
import com.hy.ouch.dto.visitHistory.response.VisitHistoryCreateResponse;

@Component
public class VisitHistoryConverter {

	public VisitHistoryCreateResponse visitHistory2VisitHistoryCreateResponse(VisitHistory visitHistory) {
		return new VisitHistoryCreateResponse(visitHistory.getId(), visitHistory.getVisitDate(),
			visitHistory.getHospital().getName(),
			visitHistory.getDepartment().getName(), visitHistory.getSymptoms(),
			visitHistory.getSummary().getContents());
	}

	public List<DateAndHospital> visitHistory2GetUsersAllVisitHistoryResponse(List<VisitHistory> visitHistory) {
		List<DateAndHospital> list = new ArrayList<>();
		for (VisitHistory history : visitHistory) {
			list.add(new DateAndHospital(history.getId(), history.getUpdatedAt().toString(),
				history.getHospital().getName()));
		}
		return list;
	}

}
