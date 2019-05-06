package com.course.api.service.serviceimpl;

import com.course.api.entity.UserRoles;
import com.course.api.repository.UserRolesRepository;
import com.course.api.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRolesService")
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public List<UserRoles> getAll() {
        return userRolesRepository.findAll();
    }

    @Override
    public UserRoles getUserRolesById(Integer idRolesDetail) {
        return userRolesRepository.findUserRolesByIdUserRoles(idRolesDetail);
    }

    @Override
    public List<UserRoles> getUserRolesByRoles(Integer idRoles) {
        return userRolesRepository.findUserRolesByIdRoles(idRoles);
    }

    @Override
    public List<UserRoles> getUserRolesByEmployee(Integer idEmp) {
        return userRolesRepository.findUserRolesByIdEmployee(idEmp);
    }

    @Override
    public UserRoles addUserRoles(UserRoles rolesDetail) {
        userRolesRepository.save(rolesDetail);
        return rolesDetail;
    }

    @Override
    public UserRoles updateUserRoles(UserRoles rolesDetail) {
        userRolesRepository.save(rolesDetail);
        return rolesDetail;
    }

    @Override
    public void removeUserRoles(UserRoles rolesDetail) {
        userRolesRepository.delete(rolesDetail);
    }
}
