package com.hy.ouch.repository.selfDiagnosis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.ouch.domain.SelfDiagnosis;

@Repository
public interface SelfDiagnosisRepository extends JpaRepository<SelfDiagnosis, Long> {

	List<SelfDiagnosis> findAllByUserId(Long userId);
}
