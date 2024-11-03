package com.hy.ouch.domain;

import com.hy.ouch.domain.common.BaseEntity;
import com.hy.ouch.domain.mapping.VisitHistory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Summary extends BaseEntity {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "visit_history_id")
	private VisitHistory visitHistory;

	@Column(columnDefinition = "TEXT")
	private String contents;

	@Column(columnDefinition = "TEXT")
	private String contents_summary;
}
