package com.course.api.controller;

import com.course.api.dto.InfoStudentDTO;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Integer id) {
        try {
            Student stu= studentService.getStudentById(id);
            if (stu==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Student>(stu, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentByAcc(@PathVariable(name = "id") Integer id) {
        try {
            Student stu= studentService.gettudentByAccount(id);
            if (stu==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Student>(stu, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentByInvoice(@PathVariable(name = "id") Integer id) {
        try {
            List<Student> stu= studentService.getStudentByInvoice(id);
            if (stu==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Student>>(stu, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentByUsername(@PathVariable(name = "username") String username) {
        try {
            Student stu= studentService.getStudentByUsername(username);
            if (stu==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Student>(stu, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{name}/{cmnd}", method = RequestMethod.GET)
    public ResponseEntity<List<InfoStudentDTO>> getStudentByNameAndCMND(@PathVariable(name = "name") String name, @PathVariable(name = "cmnd") String cmnd) {
        try {
            List<InfoStudentDTO> stu= studentService.getInfoStudent(name, cmnd);
            if (stu.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<InfoStudentDTO>>(stu, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            if (student == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") Integer idStudent, @RequestBody Student student) {
        try {
            Student curStudent = studentService.getStudentById(idStudent);
            if (curStudent == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            student.setIdStudent(idStudent);
            student.setCreatedDate(studentService.getStudentById(idStudent).getCreatedDate());
            return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteStudent(@PathVariable(name = "id") Integer id) {
        try {
            Student curStudent = studentService.getStudentById(id);
            if (curStudent == null) return false;
            studentService.removeStudent(curStudent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
