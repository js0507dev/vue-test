package com.sjs.test.User.Repository;

import com.sjs.test.User.Domain.RoleVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleVo, Long> {
}
