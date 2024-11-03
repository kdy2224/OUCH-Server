package com.hy.ouch.domain.mapping;

import com.hy.ouch.domain.Hospital;
import com.hy.ouch.domain.MedicalCategory;
import com.hy.ouch.domain.common.BaseEntity;
import com.hy.ouch.domain.mapping.compositeKey.HospitalCategoryPk;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HospitalCategory extends BaseEntity {

	@EmbeddedId
	private HospitalCategoryPk hospitalCategoryPk;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("medicalCategoryId")  // HospitalCategoryId의 categoryId와 매핑
	//@JoinColumn(name = "medicalCategory_id", nullable = false)
	private MedicalCategory medicalCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("hospitalId")  // HospitalCategoryId의 hospitalId와 매핑
	//@JoinColumn(name = "hospital_id", nullable = false)
	private Hospital hospital;
}
