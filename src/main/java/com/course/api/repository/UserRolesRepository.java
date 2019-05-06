package com.course.api.repository;

import com.course.api.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
    UserRoles findUserRolesByIdUserRoles(Integer idUserRoles);
    List<UserRoles> findUserRolesByIdRoles(Integer idRoles);
    List<UserRoles> findUserRolesByIdEmployee(Integer idEmployee);
}
