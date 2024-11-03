package com.hy.ouch.domain.mapping;

import com.hy.ouch.domain.SelfDiagnosis;
import com.hy.ouch.domain.SymptomCategory;
import com.hy.ouch.domain.common.BaseEntity;
import com.hy.ouch.domain.mapping.compositeKey.DiagnosisSymptomPK;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DiagnosisSymptom extends BaseEntity {

	@EmbeddedId
	private DiagnosisSymptomPK diagnosisSymptomPk;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("selfDiagnosisId")  // HospitalCategoryId의 categoryId와 매핑
	@JoinColumn(name = "selfDiagnosis_id", nullable = false)
	private SelfDiagnosis selfDiagnosis;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("symptomCategoryId")  // HospitalCategoryId의 hospitalId와 매핑
	@JoinColumn(name = "symptomCategory_id", nullable = false)
	private SymptomCategory symptomCategory;
}
