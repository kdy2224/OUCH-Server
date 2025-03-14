package com.hy.ouch.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hy.ouch.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByName(String name);
}
