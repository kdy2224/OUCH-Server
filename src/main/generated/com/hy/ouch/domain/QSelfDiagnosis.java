package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QSelfDiagnosis is a Querydsl query type for SelfDiagnosis
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSelfDiagnosis extends EntityPathBase<SelfDiagnosis> {

	private static final long serialVersionUID = -1358336722L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QSelfDiagnosis selfDiagnosis = new QSelfDiagnosis("selfDiagnosis");

	public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

	public final StringPath contents = createString("contents");

	//inherited
	public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

	public final ListPath<com.hy.ouch.domain.mapping.DiagnosisSymptom, com.hy.ouch.domain.mapping.QDiagnosisSymptom> diagnosisSymptomList = this.<com.hy.ouch.domain.mapping.DiagnosisSymptom, com.hy.ouch.domain.mapping.QDiagnosisSymptom>createList(
		"diagnosisSymptomList", com.hy.ouch.domain.mapping.DiagnosisSymptom.class,
		com.hy.ouch.domain.mapping.QDiagnosisSymptom.class, PathInits.DIRECT2);

	public final NumberPath<Long> id = createNumber("id", Long.class);

	//inherited
	public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

	public final QUser user;

	public QSelfDiagnosis(String variable) {
		this(SelfDiagnosis.class, forVariable(variable), INITS);
	}

	public QSelfDiagnosis(Path<? extends SelfDiagnosis> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QSelfDiagnosis(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QSelfDiagnosis(PathMetadata metadata, PathInits inits) {
		this(SelfDiagnosis.class, metadata, inits);
	}

	public QSelfDiagnosis(Class<? extends SelfDiagnosis> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
	}

}

