package com.hy.ouch.repository.visitHistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hy.ouch.domain.mapping.VisitHistory;

public interface VisitHistoryRepository extends JpaRepository<VisitHistory, Long> {
}
