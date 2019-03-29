package com.course.api.controller;

import com.course.api.dto.ClassStudentDTO;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<StudentClass> addStudentClass(@RequestBody StudentClass studentClass){
        try {
            if(studentClass==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<StudentClass>(studentClassService.addStudentClass(studentClass),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<StudentClass> updateStudentClass(@PathVariable(name = "id") Integer id, @RequestBody StudentClass studentClass){
        try {
            StudentClass curStudentClass = studentClassService.getStudentClassById(id);
            if(curStudentClass==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
           studentClass.setIdStudentClass(id);
            return new ResponseEntity<StudentClass>(studentClassService.updateStudentClass(studentClass),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteStudentClass(@PathVariable(name = "id") Integer id) {
        try {
            StudentClass studentClass = studentClassService.getStudentClassById(id);
            if (studentClass == null) return false;
            studentClassService.removeStudentClass(studentClass);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
