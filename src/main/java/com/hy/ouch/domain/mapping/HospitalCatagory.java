package com.hy.ouch.domain.mapping;

import com.hy.ouch.domain.Category;
import com.hy.ouch.domain.Hospital;
import com.hy.ouch.domain.User;
import com.hy.ouch.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HospitalCatagory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospitaa_id")
	private Hospital hospital;
}
