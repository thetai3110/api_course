package com.course.api.controller;

import com.course.api.entity.SchoolDay;
import com.course.api.service.SchoolDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schoolday")
public class SchoolDayController {

    @Autowired
    private SchoolDayService schoolDayService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<SchoolDay>> getAllSchoolDay(){
        try {
            List<SchoolDay> schoolDays = schoolDayService.getAll();
            if(schoolDays.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<SchoolDay>>(schoolDays,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
