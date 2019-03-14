package com.course.api.service;

import com.course.api.entity.Course;
import com.course.api.entity.Level;

import java.util.List;

public interface CourseService {
    List<Course> getAll() throws Exception;
    List<Course> getCourseByLevel(Integer idLevel) throws Exception;
    Course getCourseById(Integer idCouese) throws Exception;
    Course addCourse(Course course) throws Exception;
    Course updateCourse(Course course) throws Exception;
    void removeCourse(Course course) throws Exception;
}
