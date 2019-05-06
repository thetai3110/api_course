package com.course.api.repository;

import com.course.api.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findRolesByIdRoles(Integer id);
}
