package com.course.api.controller;

import com.course.api.entity.Permission;
import com.course.api.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Permission>> getAllPermission(){
        try {
            List<Permission> permissions = permissionService.getAll();
            if(permissions.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Permission>>(permissions,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Permission> getPermissionById(@PathVariable(name = "id") Integer id){
        try {
            Permission permission = permissionService.getPermissionById(id);
            if(permission==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Permission>(permission,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Permission> addPermission(@RequestBody Permission permission){
        try {
            if(permission==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Permission>(permissionService.addPermission(permission),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Permission> updatePermission(@PathVariable(name = "id") Integer id, @RequestBody Permission permission){
        try {
            Permission curLesson = permissionService.getPermissionById(id);
            if(curLesson==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            permission.setIdPer(id);
            return new ResponseEntity<Permission>(permissionService.updatePermission(permission),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deletePermission(@PathVariable(name = "id") Integer id) {
        try {
            Permission permission = permissionService.getPermissionById(id);
            if (permission == null) return false;
            permissionService.removePermission(permission);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
