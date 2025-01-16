package com.hy.ouch.domain.mapping.compositeKey;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDiagnosisSymptomPK is a Querydsl query type for DiagnosisSymptomPK
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QDiagnosisSymptomPK extends BeanPath<DiagnosisSymptomPK> {

    private static final long serialVersionUID = 161046354L;

    public static final QDiagnosisSymptomPK diagnosisSymptomPK = new QDiagnosisSymptomPK("diagnosisSymptomPK");

    public final NumberPath<Long> selfDiagnosisId = createNumber("selfDiagnosisId", Long.class);

    public final NumberPath<Long> symptomCategoryId = createNumber("symptomCategoryId", Long.class);

    public QDiagnosisSymptomPK(String variable) {
        super(DiagnosisSymptomPK.class, forVariable(variable));
    }

    public QDiagnosisSymptomPK(Path<? extends DiagnosisSymptomPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiagnosisSymptomPK(PathMetadata metadata) {
        super(DiagnosisSymptomPK.class, metadata);
    }

}

