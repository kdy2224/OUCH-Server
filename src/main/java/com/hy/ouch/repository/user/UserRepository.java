package com.hy.ouch.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.ouch.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
