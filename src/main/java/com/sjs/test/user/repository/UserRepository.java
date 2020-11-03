package com.sjs.test.user.repository;

import com.sjs.test.user.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVo, Long> {
    Optional<UserVo> findByEmail(String email);
}
