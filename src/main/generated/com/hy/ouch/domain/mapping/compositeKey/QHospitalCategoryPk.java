package com.hy.ouch.domain.mapping.compositeKey;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHospitalCategoryPk is a Querydsl query type for HospitalCategoryPk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHospitalCategoryPk extends BeanPath<HospitalCategoryPk> {

    private static final long serialVersionUID = 134197970L;

    public static final QHospitalCategoryPk hospitalCategoryPk = new QHospitalCategoryPk("hospitalCategoryPk");

    public final NumberPath<Long> hospitalId = createNumber("hospitalId", Long.class);

    public final NumberPath<Long> medicalCategoryId = createNumber("medicalCategoryId", Long.class);

    public QHospitalCategoryPk(String variable) {
        super(HospitalCategoryPk.class, forVariable(variable));
    }

    public QHospitalCategoryPk(Path<? extends HospitalCategoryPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHospitalCategoryPk(PathMetadata metadata) {
        super(HospitalCategoryPk.class, metadata);
    }

}

