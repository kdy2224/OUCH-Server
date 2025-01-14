package com.hy.ouch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import javax.annotation.processing.Generated;

import com.querydsl.core.types.Path;

/**
 * QMedicalCategory is a Querydsl query type for MedicalCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicalCategory extends EntityPathBase<MedicalCategory> {

	private static final long serialVersionUID = 452505752L;

	public static final QMedicalCategory medicalCategory = new QMedicalCategory("medicalCategory");

	public final com.hy.ouch.domain.common.QBaseEntity _super = new com.hy.ouch.domain.common.QBaseEntity(this);

	//inherited
	public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final StringPath name = createString("name");

	//inherited
	public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

	public QMedicalCategory(String variable) {
		super(MedicalCategory.class, forVariable(variable));
	}

	public QMedicalCategory(Path<? extends MedicalCategory> path) {
		super(path.getType(), path.getMetadata());
	}

	public QMedicalCategory(PathMetadata metadata) {
		super(MedicalCategory.class, metadata);
	}

}

