package com.course.api.controller;

import com.course.api.dto.ClassStudentDTO;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student-class")
public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @RequestMapping(value = "/{idClass}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassStudentDTO>> getStudentByClass(@PathVariable(name = "idClass") Integer idClass){
        try {
            List<ClassStudentDTO> students = studentClassService.getStudentByClass(idClass);
            if(students.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<ClassStudentDTO>>(students,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
