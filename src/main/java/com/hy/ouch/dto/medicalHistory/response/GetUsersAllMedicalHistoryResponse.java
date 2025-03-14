package com.hy.ouch.dto.medicalHistory.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetUsersAllMedicalHistoryResponse {

	private Long userId;
	private List<DateAndDisease> list;

}
