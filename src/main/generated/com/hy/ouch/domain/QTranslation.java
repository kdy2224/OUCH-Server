package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranslation is a Querydsl query type for Translation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTranslation extends EntityPathBase<Translation> {

    private static final long serialVersionUID = 1800070426L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTranslation translation = new QTranslation("translation");

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final EnumPath<com.hy.ouch.domain.enums.EntityType> entityType = createEnum("entityType", com.hy.ouch.domain.enums.EntityType.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QLanguage language;

    public final StringPath value = createString("value");

    public QTranslation(String variable) {
        this(Translation.class, forVariable(variable), INITS);
    }

    public QTranslation(Path<? extends Translation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTranslation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTranslation(PathMetadata metadata, PathInits inits) {
        this(Translation.class, metadata, inits);
    }

    public QTranslation(Class<? extends Translation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.language = inits.isInitialized("language") ? new QLanguage(forProperty("language")) : null;
    }

}

