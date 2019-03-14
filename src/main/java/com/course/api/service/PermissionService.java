package com.course.api.service;

import com.course.api.entity.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAll() throws Exception;
    Permission getPermissionById(Integer idPer) throws Exception;
    Permission addPermission(Permission permission) throws Exception;
    Permission updatePermission(Permission permission) throws Exception;
    void removePermission(Permission permission) throws Exception;
}
