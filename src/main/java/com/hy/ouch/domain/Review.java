package com.hy.ouch.domain;

import java.util.ArrayList;
import java.util.List;

import com.hy.ouch.domain.common.BaseEntity;
import com.hy.ouch.domain.mapping.VisitHistory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	@Column(columnDefinition = "TEXT")
	private String contents;

	@Column(nullable = false)
	private Integer score;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String imageUrl;

	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
	private List<VisitHistory> visitHistoryList = new ArrayList<>();

}
