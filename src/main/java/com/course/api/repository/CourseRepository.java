package com.course.api.repository;

import com.course.api.entity.Course;
import com.course.api.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCourseByLevel(Level level);
    Course findCourseByIdCourse(Integer idCourse);
}
