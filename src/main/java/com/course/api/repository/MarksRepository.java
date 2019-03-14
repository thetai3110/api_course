package com.course.api.repository;

import com.course.api.entity.Course;
import com.course.api.entity.Marks;
import com.course.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
    Marks findMarksByIdMarks(Integer idMarks);
    List<Marks> findMarksByCourse(Course course);
    List<Marks> findMarksByStudent(Student student);
}
