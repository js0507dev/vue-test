package com.sjs.test.User.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Entity(name = "role")
public class RoleVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotEmpty
    private String roleName;

/*
    @ManyToMany(mappedBy = "role")
    private List<UserVo> users;
*/
}
