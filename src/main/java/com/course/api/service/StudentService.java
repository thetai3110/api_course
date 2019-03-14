package com.course.api.service;

import com.course.api.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll() throws Exception;
    Student getStudentById(Integer idStu) throws Exception;
    Student getStudentByName(String name) throws Exception;
    Student getStudentByCMND(String CMND) throws Exception;
    Student getStudentByEmail(String email) throws Exception;
    Student addStudent(Student student) throws Exception;
    Student updateStudent(Student student) throws Exception;
    void removeStudent(Student student) throws Exception;
}
