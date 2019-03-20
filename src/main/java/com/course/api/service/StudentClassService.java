package com.course.api.service;

import com.course.api.entity.StudentClass;

import java.util.List;

public interface StudentClassService {
    List<StudentClass> getAll() throws Exception;
    StudentClass getStudentClassById(Integer idStudentClass) throws Exception;
    StudentClass getStudentClassByStudentAndClass(Integer idStudent, Integer idClass) throws Exception;
    StudentClass addStudentClass(StudentClass studentClass) throws Exception;
    StudentClass updateStudentClass(StudentClass studentClass) throws Exception;
    void removeStudentClass(StudentClass studentClass) throws Exception;
}
