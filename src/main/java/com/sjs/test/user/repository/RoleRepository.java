package com.sjs.test.user.repository;

import com.sjs.test.user.domain.RoleVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleVo, Long> {
}
