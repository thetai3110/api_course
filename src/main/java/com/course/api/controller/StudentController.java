package com.course.api.controller;

import com.course.api.dto.StudentDTO;
import com.course.api.entity.Student;
import com.course.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudent() {
        try {
            List<Student> students = studentService.getAll();
            if (students.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO studentDTO) {
        try {
            if (studentDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Student>(studentService.addStudent(studentDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "idStudent") Integer idStudent, @RequestBody Student student) {
        try {
            Student curStudent = studentService.getStudentById(idStudent);
            if (curStudent == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            student.setIdStudent(idStudent);
            return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
