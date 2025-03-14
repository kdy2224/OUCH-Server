package com.hy.ouch.repository.hospital;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hy.ouch.domain.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	Hospital findByName(String name);
}
