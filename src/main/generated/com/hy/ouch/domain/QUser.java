package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 2029645186L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.hy.ouch.domain.enums.Gender> gender = createEnum("gender", com.hy.ouch.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final QLanguage language;

    public final StringPath loginId = createString("loginId");

    public final StringPath name = createString("name");

    public final QNation nation;

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final ListPath<SelfDiagnosis, QSelfDiagnosis> selfDiagnosisList = this.<SelfDiagnosis, QSelfDiagnosis>createList("selfDiagnosisList", SelfDiagnosis.class, QSelfDiagnosis.class, PathInits.DIRECT2);

    public final EnumPath<com.hy.ouch.domain.enums.UserStatus> status = createEnum("status", com.hy.ouch.domain.enums.UserStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<com.hy.ouch.domain.mapping.VisitHistory, com.hy.ouch.domain.mapping.QVisitHistory> visitHistoryList = this.<com.hy.ouch.domain.mapping.VisitHistory, com.hy.ouch.domain.mapping.QVisitHistory>createList("visitHistoryList", com.hy.ouch.domain.mapping.VisitHistory.class, com.hy.ouch.domain.mapping.QVisitHistory.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.language = inits.isInitialized("language") ? new QLanguage(forProperty("language")) : null;
        this.nation = inits.isInitialized("nation") ? new QNation(forProperty("nation")) : null;
    }

}

