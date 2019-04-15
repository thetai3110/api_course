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
    public ResponseEntity<Student> getStudentByNameAndCMND(@PathVariable(name = "name") String name, @PathVariable(name = "cmnd") String cmnd) {
        try {
            Student stu= studentService.getStudentByCMNDAndName(cmnd, name);
            if (stu==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Student>(stu, HttpStatus.OK);
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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") Integer idStudent, @RequestBody StudentDTO studentDTO) {
        try {
            Student curStudent = studentService.getStudentById(idStudent);
            if (curStudent == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            if(!studentDTO.getImage().equals("")){
                String[] img = studentDTO.getImage().split("fakepath");
                studentDTO.setImage(img[1]);
            }else{
                String img = curStudent.getImage() == null || curStudent.getImage().equals("") ? "" : curStudent.getImage();
                studentDTO.setImage(img);
            }
            return new ResponseEntity<Student>(studentService.updateStudent(studentDTO, idStudent), HttpStatus.OK);
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
