package com.course.api.service.serviceimpl;

import com.course.api.entity.RolesDetail;
import com.course.api.repository.RolesDetailRepository;
import com.course.api.service.RolesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rolesDetailService")
public class RolesDetailServiceImpl implements RolesDetailService {

    @Autowired
    private RolesDetailRepository rolesDetailRepository;

    @Override
    public List<RolesDetail> getAll() {
        return rolesDetailRepository.findAll();
    }

    @Override
    public RolesDetail getRolesDetailById(Integer idRolesDetail) {
        return rolesDetailRepository.findRolesDetailByIdRolesDetail(idRolesDetail);
    }

    @Override
    public List<RolesDetail> getRolesDetailByRoles(Integer idRoles) {
        return rolesDetailRepository.findRolesDetailByIdRoles(idRoles);
    }

    @Override
    public RolesDetail addRolesDetail(RolesDetail rolesDetail) {
        rolesDetailRepository.save(rolesDetail);
        return rolesDetail;
    }

    @Override
    public RolesDetail updateRolesDetail(RolesDetail rolesDetail) {
        rolesDetailRepository.save(rolesDetail);
        return rolesDetail;
    }

    @Override
    public void removeRolesDetail(RolesDetail rolesDetail) {
        rolesDetailRepository.delete(rolesDetail);
    }
}
