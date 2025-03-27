package com.hy.ouch.repository.hospital;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.ouch.domain.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	Optional<Hospital> findByName(String name);
}
