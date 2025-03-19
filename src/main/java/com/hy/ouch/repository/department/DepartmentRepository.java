package com.hy.ouch.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.ouch.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByName(String name);
}
