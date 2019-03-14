package com.course.api.service.serviceimpl;

import com.course.api.entity.Permission;
import com.course.api.repository.PermissionRepositoty;
import com.course.api.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepositoty permissionRepositoty;

    @Override
    public List<Permission> getAll() {
        return permissionRepositoty.findAll();
    }

    @Override
    public Permission getPermissionById(Integer idPer) {
        return permissionRepositoty.findPermissionByIdPer(idPer);
    }

    @Override
    public Permission addPermission(Permission permission) {
        permission.setCreatedDate(new Date());
        permission.setModifyDate(new Date());
        permissionRepositoty.save(permission);
        return permission;
    }

    @Override
    public Permission updatePermission(Permission permission) {
        permission.setModifyDate(new Date());
        permissionRepositoty.save(permission);
        return permission;
    }

    @Override
    public void removePermission(Permission permission) {
        permissionRepositoty.delete(permission);
    }
}
