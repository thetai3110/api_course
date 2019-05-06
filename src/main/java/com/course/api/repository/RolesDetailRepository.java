package com.course.api.repository;

import com.course.api.entity.RolesDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesDetailRepository extends JpaRepository<RolesDetail, Integer> {
    RolesDetail findRolesDetailByIdRolesDetail(Integer idRolesDetail);
    List<RolesDetail> findRolesDetailByIdRoles(Integer idRoles);
}
