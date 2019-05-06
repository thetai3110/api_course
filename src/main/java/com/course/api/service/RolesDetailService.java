package com.course.api.service;

import com.course.api.entity.RolesDetail;

import java.util.List;

public interface RolesDetailService {
    List<RolesDetail> getAll() throws Exception;
    RolesDetail getRolesDetailById(Integer idRolesDetail) throws Exception;
    List<RolesDetail> getRolesDetailByRoles(Integer idRoles) throws Exception;
    RolesDetail addRolesDetail(RolesDetail rolesDetail) throws Exception;
    RolesDetail updateRolesDetail(RolesDetail rolesDetail) throws Exception;
    void removeRolesDetail(RolesDetail rolesDetail) throws Exception;
}
