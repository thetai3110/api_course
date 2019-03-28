package com.course.api.repository;

import com.course.api.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
    StudentClass findStudentClassByIdStudentClass(Integer idStudentClass);
    StudentClass findStudentClassByIdStudentAndIdClass(Integer idStudent, Integer idClass);
    List<StudentClass> findStudentClassByIdClass(Integer idClass);
}
