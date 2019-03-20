package com.course.api.controller;

import com.course.api.entity.Majors;
import com.course.api.service.MajorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/majors")
public class MajorsController {

    @Autowired
    private MajorsService majorsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Majors>> getAllMajors(){
        try {
            List<Majors> majors = majorsService.getAll();
            if(majors.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Majors>>(majors,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
