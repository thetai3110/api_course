package com.course.api.controller;

import com.course.api.entity.UserRoles;
import com.course.api.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user-roles")
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserRoles>> getAllUserRoles() {
        try {
            List<UserRoles> userRoles = userRolesService.getAll();
            if (userRoles.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<UserRoles>>(userRoles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserRoles> getUserRolesById(@PathVariable(name = "id") Integer id) {
        try {
            UserRoles userRoles = userRolesService.getUserRolesById(id);
            if (userRoles == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<UserRoles>(userRoles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/roles/{idRoles}", method = RequestMethod.GET)
    public ResponseEntity<List<UserRoles>> getUserRolesByRoles(@PathVariable(name = "idRoles") Integer idRoles) {
        try {
            List<UserRoles> userRoles = userRolesService.getUserRolesByRoles(idRoles);
            if (userRoles.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<UserRoles>>(userRoles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/employee/{idEmp}", method = RequestMethod.GET)
    public ResponseEntity<List<UserRoles>> getUserRolesByEmployee(@PathVariable(name = "idEmp") Integer idEmp) {
        try {
            List<UserRoles> userRoles = userRolesService.getUserRolesByEmployee(idEmp);
            if (userRoles.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<UserRoles>>(userRoles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserRoles> addUserRoles(@RequestBody UserRoles userRoles) {
        try {
            if (userRoles == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<UserRoles>(userRolesService.addUserRoles(userRoles), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<UserRoles> updateUserRoles(@PathVariable(name = "id") Integer id, @RequestBody UserRoles userRoles) {
        try {
            UserRoles curUserRoles = userRolesService.getUserRolesById(id);
            if (curUserRoles == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            userRoles.setIdUserRoles(id);
            return new ResponseEntity<UserRoles>(userRolesService.updateUserRoles(userRoles), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteUserRoles(@PathVariable(name = "id") Integer id) {
        try {
            UserRoles userRoles = userRolesService.getUserRolesById(id);
            if (userRoles == null) return false;
            userRolesService.removeUserRoles(userRoles);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
