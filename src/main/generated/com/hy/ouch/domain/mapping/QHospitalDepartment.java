package com.hy.ouch.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHospitalDepartment is a Querydsl query type for HospitalDepartment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHospitalDepartment extends EntityPathBase<HospitalDepartment> {

    private static final long serialVersionUID = 16123075L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHospitalDepartment hospitalDepartment = new QHospitalDepartment("hospitalDepartment");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final com.hy.ouch.domain.QDepartment department;

    public final com.hy.ouch.domain.QHospital hospital;

    public final com.hy.ouch.domain.mapping.compositeKey.QHospitalCategoryPk hospitalCategoryPk;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QHospitalDepartment(String variable) {
        this(HospitalDepartment.class, forVariable(variable), INITS);
    }

    public QHospitalDepartment(Path<? extends HospitalDepartment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHospitalDepartment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHospitalDepartment(PathMetadata metadata, PathInits inits) {
        this(HospitalDepartment.class, metadata, inits);
    }

    public QHospitalDepartment(Class<? extends HospitalDepartment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new com.hy.ouch.domain.QDepartment(forProperty("department")) : null;
        this.hospital = inits.isInitialized("hospital") ? new com.hy.ouch.domain.QHospital(forProperty("hospital")) : null;
        this.hospitalCategoryPk = inits.isInitialized("hospitalCategoryPk") ? new com.hy.ouch.domain.mapping.compositeKey.QHospitalCategoryPk(forProperty("hospitalCategoryPk")) : null;
    }

}

