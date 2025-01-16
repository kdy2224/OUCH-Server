package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNation is a Querydsl query type for Nation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNation extends EntityPathBase<Nation> {

    private static final long serialVersionUID = 357285694L;

    public static final QNation nation = new QNation("nation");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QNation(String variable) {
        super(Nation.class, forVariable(variable));
    }

    public QNation(Path<? extends Nation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNation(PathMetadata metadata) {
        super(Nation.class, metadata);
    }

}

