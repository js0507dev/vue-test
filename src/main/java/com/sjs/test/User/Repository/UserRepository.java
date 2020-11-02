package com.sjs.test.User.Repository;

import com.sjs.test.User.Domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVo, Long> {
    Optional<UserVo> findByEmail(String email);
}
