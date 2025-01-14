package com.hy.ouch.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QDiagnosisSymptom is a Querydsl query type for DiagnosisSymptom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiagnosisSymptom extends EntityPathBase<DiagnosisSymptom> {

	private static final long serialVersionUID = -1308984497L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QDiagnosisSymptom diagnosisSymptom = new QDiagnosisSymptom("diagnosisSymptom");

	public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

	//inherited
	public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

	public final com.hy.ouch.domain.mapping.compositeKey.QDiagnosisSymptomPK diagnosisSymptomPk;

	public final com.hy.ouch.domain.QSelfDiagnosis selfDiagnosis;

	public final com.hy.ouch.domain.QSymptomCategory symptomCategory;

	//inherited
	public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

	public QDiagnosisSymptom(String variable) {
		this(DiagnosisSymptom.class, forVariable(variable), INITS);
	}

	public QDiagnosisSymptom(Path<? extends DiagnosisSymptom> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QDiagnosisSymptom(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QDiagnosisSymptom(PathMetadata metadata, PathInits inits) {
		this(DiagnosisSymptom.class, metadata, inits);
	}

	public QDiagnosisSymptom(Class<? extends DiagnosisSymptom> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.diagnosisSymptomPk = inits.isInitialized("diagnosisSymptomPk") ?
			new com.hy.ouch.domain.mapping.compositeKey.QDiagnosisSymptomPK(forProperty("diagnosisSymptomPk")) : null;
		this.selfDiagnosis = inits.isInitialized("selfDiagnosis") ?
			new com.hy.ouch.domain.QSelfDiagnosis(forProperty("selfDiagnosis"), inits.get("selfDiagnosis")) : null;
		this.symptomCategory = inits.isInitialized("symptomCategory") ?
			new com.hy.ouch.domain.QSymptomCategory(forProperty("symptomCategory")) : null;
	}

}

