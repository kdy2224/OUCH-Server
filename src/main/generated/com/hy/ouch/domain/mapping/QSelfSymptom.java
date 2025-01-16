package com.hy.ouch.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSelfSymptom is a Querydsl query type for SelfSymptom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSelfSymptom extends EntityPathBase<SelfSymptom> {

    private static final long serialVersionUID = -365277818L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSelfSymptom selfSymptom = new QSelfSymptom("selfSymptom");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final com.hy.ouch.domain.mapping.compositeKey.QDiagnosisSymptomPK diagnosisSymptomPk;

    public final com.hy.ouch.domain.QSelfDiagnosis selfDiagnosis;

    public final com.hy.ouch.domain.QSymptom symptom;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSelfSymptom(String variable) {
        this(SelfSymptom.class, forVariable(variable), INITS);
    }

    public QSelfSymptom(Path<? extends SelfSymptom> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSelfSymptom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSelfSymptom(PathMetadata metadata, PathInits inits) {
        this(SelfSymptom.class, metadata, inits);
    }

    public QSelfSymptom(Class<? extends SelfSymptom> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.diagnosisSymptomPk = inits.isInitialized("diagnosisSymptomPk") ? new com.hy.ouch.domain.mapping.compositeKey.QDiagnosisSymptomPK(forProperty("diagnosisSymptomPk")) : null;
        this.selfDiagnosis = inits.isInitialized("selfDiagnosis") ? new com.hy.ouch.domain.QSelfDiagnosis(forProperty("selfDiagnosis"), inits.get("selfDiagnosis")) : null;
        this.symptom = inits.isInitialized("symptom") ? new com.hy.ouch.domain.QSymptom(forProperty("symptom")) : null;
    }

}

