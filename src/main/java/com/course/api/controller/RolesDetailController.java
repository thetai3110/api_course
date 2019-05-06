package com.course.api.controller;

import com.course.api.entity.RolesDetail;
import com.course.api.service.RolesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles-detail")
public class RolesDetailController {

    @Autowired
    private RolesDetailService rolesDetailService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RolesDetail>> getAllRolesDetail() {
        try {
            List<RolesDetail> rolesDetails = rolesDetailService.getAll();
            if (rolesDetails.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<RolesDetail>>(rolesDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RolesDetail> getRolesDetailById(@PathVariable(name = "id") Integer id) {
        try {
            RolesDetail rolesDetail = rolesDetailService.getRolesDetailById(id);
            if (rolesDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<RolesDetail>(rolesDetail, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/roles/{idRoles}", method = RequestMethod.GET)
    public ResponseEntity<List<RolesDetail>> getRolesDetailByRoles(@PathVariable(name = "idRoles") Integer idRoles) {
        try {
            List<RolesDetail> rolesDetails = rolesDetailService.getRolesDetailByRoles(idRoles);
            if (rolesDetails.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<RolesDetail>>(rolesDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<RolesDetail> addRolesDetail(@RequestBody RolesDetail rolesDetail) {
        try {
            if (rolesDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<RolesDetail>(rolesDetailService.addRolesDetail(rolesDetail), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<RolesDetail> updateRolesDetail(@PathVariable(name = "id") Integer id, @RequestBody RolesDetail rolesDetail) {
        try {
            RolesDetail curRolesDetail = rolesDetailService.getRolesDetailById(id);
            if (curRolesDetail == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            rolesDetail.setIdRolesDetail(id);
            return new ResponseEntity<RolesDetail>(rolesDetailService.updateRolesDetail(rolesDetail), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteRoles(@PathVariable(name = "id") Integer id) {
        try {
            RolesDetail rolesDetail = rolesDetailService.getRolesDetailById(id);
            if (rolesDetail == null) return false;
            rolesDetailService.removeRolesDetail(rolesDetail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
