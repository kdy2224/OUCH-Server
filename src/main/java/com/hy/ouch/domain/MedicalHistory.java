package com.hy.ouch.domain;

import com.hy.ouch.domain.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MedicalHistory extends BaseEntity {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@MapsId // User의 id를 MedicalHistory의 기본 키로 매핑
	@JoinColumn(name = "user_id") //외래 키 이름을 user_id로 설정
	private User user;

	@Column(nullable = true, columnDefinition = "TEXT")
	private String disease;

	@Column(nullable = true, columnDefinition = "TEXT")
	private String allergy;

	@Column(nullable = true, columnDefinition = "TEXT")
	private Long bloodPressure;

	@Column(nullable = true, columnDefinition = "TEXT")
	private Long bloodSugar;

	@Column(nullable = true, columnDefinition = "TEXT")
	private String medicineHistory;
}
