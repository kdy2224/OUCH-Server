package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSummary is a Querydsl query type for Summary
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSummary extends EntityPathBase<Summary> {

    private static final long serialVersionUID = -1100269937L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSummary summary = new QSummary("summary");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    public final StringPath contents = createString("contents");

    public final StringPath contents_summary = createString("contents_summary");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.hy.ouch.domain.mapping.QVisitHistory visitHistory;

    public QSummary(String variable) {
        this(Summary.class, forVariable(variable), INITS);
    }

    public QSummary(Path<? extends Summary> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSummary(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSummary(PathMetadata metadata, PathInits inits) {
        this(Summary.class, metadata, inits);
    }

    public QSummary(Class<? extends Summary> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.visitHistory = inits.isInitialized("visitHistory") ? new com.hy.ouch.domain.mapping.QVisitHistory(forProperty("visitHistory"), inits.get("visitHistory")) : null;
    }

}

