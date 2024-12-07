package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSymptomCategory is a Querydsl query type for SymptomCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSymptomCategory extends EntityPathBase<SymptomCategory> {

    private static final long serialVersionUID = 1197485104L;

    public static final QSymptomCategory symptomCategory = new QSymptomCategory("symptomCategory");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSymptomCategory(String variable) {
        super(SymptomCategory.class, forVariable(variable));
    }

    public QSymptomCategory(Path<? extends SymptomCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSymptomCategory(PathMetadata metadata) {
        super(SymptomCategory.class, metadata);
    }

}

