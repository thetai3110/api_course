package com.course.api.controller;

import com.course.api.entity.Roles;
import com.course.api.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Roles>> getAllRoles() {
        try {
            List<Roles> roles = rolesService.getAll();
            if (roles.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Roles>>(roles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Roles> getRolesById(@PathVariable(name = "id") Integer id) {
        try {
            Roles roles = rolesService.getRolesById(id);
            if (roles == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Roles>(roles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Roles> addRoles(@RequestBody Roles roles) {
        try {
            if (roles == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Roles>(rolesService.addRoles(roles), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Roles> updateRoles(@PathVariable(name = "id") Integer id, @RequestBody Roles roles) {
        try {
            Roles curRoles = rolesService.getRolesById(id);
            if (curRoles == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            roles.setIdRoles(id);
            return new ResponseEntity<Roles>(rolesService.updateRoles(roles), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteRoles(@PathVariable(name = "id") Integer id) {
        try {
            Roles roles = rolesService.getRolesById(id);
            if (roles == null) return false;
            rolesService.removeRoles(roles);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
