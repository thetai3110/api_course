package com.course.api.repository;

import com.course.api.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepositoty extends JpaRepository<Permission, Integer> {
    Permission findPermissionByIdPer(Integer idPer);
}
