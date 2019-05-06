package com.course.api.service.serviceimpl;

import com.course.api.entity.Roles;
import com.course.api.repository.RolesRepository;
import com.course.api.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rolesService")
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(Integer idRoles) {
        return rolesRepository.findRolesByIdRoles(idRoles);
    }

    @Override
    public Roles addRoles(Roles roles) {
        rolesRepository.save(roles);
        return roles;
    }

    @Override
    public Roles updateRoles(Roles roles) {
        rolesRepository.save(roles);
        return roles;
    }

    @Override
    public void removeRoles(Roles roles) {
        rolesRepository.delete(roles);
    }
}
