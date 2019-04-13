package com.course.api.controller;

import com.course.api.entity.EducationProgram;
import com.course.api.service.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "education-program")
public class EducationProgramController {

    @Autowired
    private EducationProgramService educationProgramService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<EducationProgram>> getAllEducationProgram(){
        try {
            List<EducationProgram> educationPrograms = educationProgramService.getAll();
            if(educationPrograms.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<EducationProgram>>(educationPrograms,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EducationProgram> getEducationProgramById(@PathVariable(name = "id") Integer id){
        try {
            EducationProgram educationProgram = educationProgramService.getEducationProgramById(id);
            if(educationProgram == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<EducationProgram>(educationProgram,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<EducationProgram> addEducationProgram(@RequestBody EducationProgram educationProgram) {
        try {
            if (educationProgram == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<EducationProgram>(educationProgramService.addEducationProgram(educationProgram), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<EducationProgram> updateEducationProgram(@PathVariable(name = "id") Integer id, @RequestBody EducationProgram educationProgram) {
        try {
            EducationProgram curEducationProgram = educationProgramService.getEducationProgramById(id);
            if (curEducationProgram == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            educationProgram.setIdEdu(id);
            return new ResponseEntity<EducationProgram>(educationProgramService.updateEducationProgram(educationProgram), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
