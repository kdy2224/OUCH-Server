package com.hy.ouch.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHospitalCategory is a Querydsl query type for HospitalCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHospitalCategory extends EntityPathBase<HospitalCategory> {

    private static final long serialVersionUID = 1251878575L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHospitalCategory hospitalCategory = new QHospitalCategory("hospitalCategory");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final com.hy.ouch.domain.QHospital hospital;

    public final com.hy.ouch.domain.mapping.compositeKey.QHospitalCategoryPk hospitalCategoryPk;

    public final com.hy.ouch.domain.QMedicalCategory medicalCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QHospitalCategory(String variable) {
        this(HospitalCategory.class, forVariable(variable), INITS);
    }

    public QHospitalCategory(Path<? extends HospitalCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHospitalCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHospitalCategory(PathMetadata metadata, PathInits inits) {
        this(HospitalCategory.class, metadata, inits);
    }

    public QHospitalCategory(Class<? extends HospitalCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hospital = inits.isInitialized("hospital") ? new com.hy.ouch.domain.QHospital(forProperty("hospital")) : null;
        this.hospitalCategoryPk = inits.isInitialized("hospitalCategoryPk") ? new com.hy.ouch.domain.mapping.compositeKey.QHospitalCategoryPk(forProperty("hospitalCategoryPk")) : null;
        this.medicalCategory = inits.isInitialized("medicalCategory") ? new com.hy.ouch.domain.QMedicalCategory(forProperty("medicalCategory")) : null;
    }

}

