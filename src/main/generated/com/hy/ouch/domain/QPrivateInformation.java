package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrivateInformation is a Querydsl query type for PrivateInformation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPrivateInformation extends EntityPathBase<PrivateInformation> {

    private static final long serialVersionUID = -462181088L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrivateInformation privateInformation = new QPrivateInformation("privateInformation");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QPrivateInformation(String variable) {
        this(PrivateInformation.class, forVariable(variable), INITS);
    }

    public QPrivateInformation(Path<? extends PrivateInformation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrivateInformation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrivateInformation(PathMetadata metadata, PathInits inits) {
        this(PrivateInformation.class, metadata, inits);
    }

    public QPrivateInformation(Class<? extends PrivateInformation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

