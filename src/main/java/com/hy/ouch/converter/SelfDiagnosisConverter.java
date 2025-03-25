package com.hy.ouch.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hy.ouch.domain.SelfDiagnosis;
import com.hy.ouch.domain.mapping.SelfSymptom;
import com.hy.ouch.dto.selfDiagnosis.response.DiagnosisCreateResponse;
import com.hy.ouch.dto.selfDiagnosis.response.DiagnosisCreateResponseDetailed;
import com.hy.ouch.dto.selfDiagnosis.response.DiagnosisUpdateResponse;
import com.hy.ouch.dto.selfDiagnosis.response.GetDiagnosisByUserIdResponse;
import com.hy.ouch.dto.selfDiagnosis.response.GetDiagnosisResponse;
import com.hy.ouch.dto.selfDiagnosis.response.GetSymptomsOfDiagnosisResponse;

@Component
public class SelfDiagnosisConverter {

	public static DiagnosisUpdateResponse diagnosis2DiagnosisUpdateResponse(SelfDiagnosis updatedDiagnosis) {
		List<String> symptoms = new ArrayList<>();
		for (SelfSymptom symptom : updatedDiagnosis.getSelfSymptomList()) {
			symptoms.add(symptom.getSymptom().getName());
		}
		return new DiagnosisUpdateResponse(updatedDiagnosis.getId(), updatedDiagnosis.getVisitType(), symptoms,
			updatedDiagnosis.getDuration(), updatedDiagnosis.getPainSeverity(), updatedDiagnosis.getAdditionalNote(),
			updatedDiagnosis.getCreatedAt().toString());
	}

	public DiagnosisCreateResponseDetailed diagnosis2DiagnosisCreateResponseDetailed(SelfDiagnosis diagnosis) {
		List<String> symotimList = new ArrayList<>();
		for (SelfSymptom symptom : diagnosis.getSelfSymptomList()) {
			symotimList.add(symptom.getSymptom().getName());
		}
		return new DiagnosisCreateResponseDetailed(diagnosis.getId(),
			diagnosis.getVisitType(), symotimList, diagnosis.getDuration(), diagnosis.getPainSeverity(),
			diagnosis.getAdditionalNote(), diagnosis.getCreatedAt().toString());
	}

	public DiagnosisCreateResponse diagnosis2DiagnosisCreateResponse(SelfDiagnosis diagnosis) {
		return new DiagnosisCreateResponse(diagnosis.getId(), "Self-diagnosis submitted successfully.");
	}

	public GetDiagnosisResponse diagnosis2GetDiagnosisResponse(SelfDiagnosis diagnosis) {
		List<String> selfSymotimList = new ArrayList<>();
		for (SelfSymptom symptom : diagnosis.getSelfSymptomList()) {
			selfSymotimList.add(symptom.getSymptom().getName());
		}
		return new GetDiagnosisResponse(diagnosis.getUser().getId(), diagnosis.getVisitType(), selfSymotimList,
			diagnosis.getDuration(),
			diagnosis.getPainSeverity(), diagnosis.getAdditionalNote(), diagnosis.getCreatedAt().toString());
	}

	public GetDiagnosisByUserIdResponse diagnosis2GetDiagnosisByUserIdResponse(SelfDiagnosis diagnosis) {
		List<String> selfSymotimList = new ArrayList<>();
		for (SelfSymptom symptom : diagnosis.getSelfSymptomList()) {
			selfSymotimList.add(symptom.getSymptom().getName());
		}
		return new GetDiagnosisByUserIdResponse(diagnosis.getId(), diagnosis.getVisitType(), selfSymotimList,
			diagnosis.getDuration(), diagnosis.getPainSeverity(), diagnosis.getAdditionalNote(),
			diagnosis.getCreatedAt().toString());
	}

	public GetSymptomsOfDiagnosisResponse diagnosis2GetSymptomsOfDiagnosisResponse(SelfDiagnosis diagnosis) {
		List<String> symptoms = new ArrayList<>();
		for (SelfSymptom symptom : diagnosis.getSelfSymptomList()) {
			symptoms.add(symptom.getSymptom().getName());
		}
		return new GetSymptomsOfDiagnosisResponse(symptoms);
	}
}
