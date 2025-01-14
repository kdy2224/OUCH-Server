package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QMedicalHistory is a Querydsl query type for MedicalHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicalHistory extends EntityPathBase<MedicalHistory> {

	private static final long serialVersionUID = 1632638394L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QMedicalHistory medicalHistory = new QMedicalHistory("medicalHistory");

	public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

	public final StringPath contents = createString("contents");

	//inherited
	public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

	public final NumberPath<Long> id = createNumber("id", Long.class);

	//inherited
	public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

	public final QUser user;

	public QMedicalHistory(String variable) {
		this(MedicalHistory.class, forVariable(variable), INITS);
	}

	public QMedicalHistory(Path<? extends MedicalHistory> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QMedicalHistory(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QMedicalHistory(PathMetadata metadata, PathInits inits) {
		this(MedicalHistory.class, metadata, inits);
	}

	public QMedicalHistory(Class<? extends MedicalHistory> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
	}

}

