package com.hy.ouch.repository.nation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.ouch.domain.Nation;

@Repository
public interface NationRepository extends JpaRepository<Nation, Long> {
}
