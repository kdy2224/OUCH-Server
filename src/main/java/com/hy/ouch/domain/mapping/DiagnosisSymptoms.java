package com.hy.ouch.domain.mapping;

import com.hy.ouch.domain.SelfDiagnosis;
import com.hy.ouch.domain.SymptomCategory;
import com.hy.ouch.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DiagnosisSymptoms extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "self_diagnosis_id")
	private SelfDiagnosis selfDiagnosis;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "symptom_category_id")
	private SymptomCategory symptomCategory;

}
