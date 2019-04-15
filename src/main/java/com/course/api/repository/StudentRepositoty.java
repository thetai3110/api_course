package com.course.api.repository;

import com.course.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoty extends JpaRepository<Student, Integer> {
    Student findStudentByStudentName(String name);
    Student findStudentByCmnd(String cmnd);
    Student findStudentByIdStudent(Integer idStu);
    Student findStudentByEmail(String email);
    Student findStudentByStudentNameAndCmnd(String name, String cmnd);
}
