package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QNotification is a Querydsl query type for Notification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotification extends EntityPathBase<Notification> {

	private static final long serialVersionUID = 1788339106L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QNotification notification = new QNotification("notification");

	public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

	public final StringPath contents = createString("contents");

	//inherited
	public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final BooleanPath isConfirmed = createBoolean("isConfirmed");

	//inherited
	public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

	public final QUser user;

	public QNotification(String variable) {
		this(Notification.class, forVariable(variable), INITS);
	}

	public QNotification(Path<? extends Notification> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QNotification(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QNotification(PathMetadata metadata, PathInits inits) {
		this(Notification.class, metadata, inits);
	}

	public QNotification(Class<? extends Notification> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
	}

}

