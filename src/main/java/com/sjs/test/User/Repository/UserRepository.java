package com.sjs.test.User.Repository;

import com.sjs.test.User.Domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVo, Long> {
}
