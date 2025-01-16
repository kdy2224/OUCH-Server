package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHospital is a Querydsl query type for Hospital
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHospital extends EntityPathBase<Hospital> {

    private static final long serialVersionUID = 1700023409L;

    public static final QHospital hospital = new QHospital("hospital");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final ListPath<com.hy.ouch.domain.mapping.HospitalDepartment, com.hy.ouch.domain.mapping.QHospitalDepartment> hospitalDepartmentList = this.<com.hy.ouch.domain.mapping.HospitalDepartment, com.hy.ouch.domain.mapping.QHospitalDepartment>createList("hospitalDepartmentList", com.hy.ouch.domain.mapping.HospitalDepartment.class, com.hy.ouch.domain.mapping.QHospitalDepartment.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QHospital(String variable) {
        super(Hospital.class, forVariable(variable));
    }

    public QHospital(Path<? extends Hospital> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHospital(PathMetadata metadata) {
        super(Hospital.class, metadata);
    }

}

