package com.hy.ouch.domain;

import java.util.ArrayList;
import java.util.List;

import com.hy.ouch.domain.common.BaseEntity;
import com.hy.ouch.domain.mapping.HospitalCategory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Hospital extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 100)
	private String address;

	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	private List<HospitalCategory> hospitalCategoryList = new ArrayList<>();
}
