package com.course.api.service;

import com.course.api.dto.StudentDTO;
import com.course.api.entity.Student;
import com.course.api.model.ResponseModel;

import java.util.List;

public interface StudentService {
    List<Student> getAll() throws Exception;
    Student getStudentById(Integer idStu) throws Exception;
    Student gettudentByAccount(Integer idAccount) throws Exception;
    Student getStudentByUsername(String username) throws Exception;
    Student getStudentByName(String name) throws Exception;
    Student getStudentByCMND(String CMND) throws Exception;
    Student getStudentByCMNDAndName(String CMND, String name) throws Exception;
    Student getStudentByEmail(String email) throws Exception;
    List<Student> getStudentByInvoice(Integer idInvoice) throws Exception;
    Student addStudent(StudentDTO studentDTO) throws Exception;
    List<Student> addMultiStudent(List<StudentDTO> studentDTOS) throws Exception;
    Student updateStudent(StudentDTO studentDTO, Integer idStudent) throws Exception;
    Student updateStudent(Student student) throws Exception;
    void removeStudent(Student student) throws Exception;
}
