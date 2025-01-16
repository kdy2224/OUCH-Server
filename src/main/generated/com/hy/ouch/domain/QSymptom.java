package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSymptom is a Querydsl query type for Symptom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSymptom extends EntityPathBase<Symptom> {

    private static final long serialVersionUID = -985645806L;

    public static final QSymptom symptom = new QSymptom("symptom");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSymptom(String variable) {
        super(Symptom.class, forVariable(variable));
    }

    public QSymptom(Path<? extends Symptom> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSymptom(PathMetadata metadata) {
        super(Symptom.class, metadata);
    }

}

