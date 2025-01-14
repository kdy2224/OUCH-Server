package com.hy.ouch.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QVisitHistory is a Querydsl query type for VisitHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisitHistory extends EntityPathBase<VisitHistory> {

	private static final long serialVersionUID = 1876089248L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QVisitHistory visitHistory = new QVisitHistory("visitHistory");

	public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

	//inherited
	public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

	public final com.hy.ouch.domain.QHospital hospital;

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final com.hy.ouch.domain.QSummary summary;

	//inherited
	public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

	public final com.hy.ouch.domain.QUser user;

	public QVisitHistory(String variable) {
		this(VisitHistory.class, forVariable(variable), INITS);
	}

	public QVisitHistory(Path<? extends VisitHistory> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QVisitHistory(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QVisitHistory(PathMetadata metadata, PathInits inits) {
		this(VisitHistory.class, metadata, inits);
	}

	public QVisitHistory(Class<? extends VisitHistory> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.hospital =
			inits.isInitialized("hospital") ? new com.hy.ouch.domain.QHospital(forProperty("hospital")) : null;
		this.summary = inits.isInitialized("summary") ?
			new com.hy.ouch.domain.QSummary(forProperty("summary"), inits.get("summary")) : null;
		this.user =
			inits.isInitialized("user") ? new com.hy.ouch.domain.QUser(forProperty("user"), inits.get("user")) : null;
	}

}

