package com.course.api.service;

import com.course.api.entity.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> getAll() throws Exception;
    Roles getRolesById(Integer idRoles) throws Exception;
    Roles addRoles(Roles roles) throws Exception;
    Roles updateRoles(Roles roles) throws Exception;
    void removeRoles(Roles roles) throws Exception;
}
