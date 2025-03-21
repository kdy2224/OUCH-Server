package com.hy.ouch.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hy.ouch.domain.mapping.VisitHistory;
import com.hy.ouch.dto.visitHistory.response.DateAndHospital;

@Component
public class VisitHistoryConverter {
	public List<DateAndHospital> visitHistory2GetUsersAllVisitHistoryResponse(List<VisitHistory> visitHistory) {
		List<DateAndHospital> list = new ArrayList<>();
		for (VisitHistory history : visitHistory) {
			list.add(new DateAndHospital(history.getId(), history.getUpdatedAt().toString(),
				history.getHospital().toString()));
		}
		return list;
	}

}
