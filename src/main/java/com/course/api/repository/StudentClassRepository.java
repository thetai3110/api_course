package com.course.api.repository;

import com.course.api.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
    StudentClass findStudentClassByIdStudentClass(Integer idStudentClass);
    StudentClass findStudentClassByIdStudentAndIdClass(Integer idStudent, Integer idClass);
}
