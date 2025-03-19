package com.hy.ouch.repository.hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.ouch.domain.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	Hospital findByName(String name);
}
