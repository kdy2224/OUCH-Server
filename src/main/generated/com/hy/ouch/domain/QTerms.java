package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = -1506836816L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTerms terms = new QTerms("terms");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    public final EnumPath<com.hy.ouch.domain.enums.Agreement> agreement = createEnum("agreement", com.hy.ouch.domain.enums.Agreement.class);

    public final DatePath<java.time.LocalDate> agreementDate = createDate("agreementDate", java.time.LocalDate.class);

    public final StringPath body = createString("body");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.hy.ouch.domain.enums.TermEssential> termEssential = createEnum("termEssential", com.hy.ouch.domain.enums.TermEssential.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public final NumberPath<Float> version = createNumber("version", Float.class);

    public QTerms(String variable) {
        this(Terms.class, forVariable(variable), INITS);
    }

    public QTerms(Path<? extends Terms> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTerms(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTerms(PathMetadata metadata, PathInits inits) {
        this(Terms.class, metadata, inits);
    }

    public QTerms(Class<? extends Terms> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

