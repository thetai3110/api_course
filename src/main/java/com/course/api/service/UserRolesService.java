package com.course.api.service;

import com.course.api.entity.UserRoles;

import java.util.List;

public interface UserRolesService {
    List<UserRoles> getAll() throws Exception;
    UserRoles getUserRolesById(Integer idRolesDetail) throws Exception;
    List<UserRoles> getUserRolesByRoles(Integer idRoles) throws Exception;
    List<UserRoles> getUserRolesByEmployee(Integer idEmp) throws Exception;
    UserRoles addUserRoles(UserRoles rolesDetail) throws Exception;
    UserRoles updateUserRoles(UserRoles rolesDetail) throws Exception;
    void removeUserRoles(UserRoles rolesDetail) throws Exception;
}
