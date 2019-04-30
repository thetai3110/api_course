package com.course.api.service;

import com.course.api.dto.CourseDTO;
import com.course.api.entity.Course;
import com.course.api.entity.Level;

import java.util.List;

public interface CourseService {
    List<Course> getAll() throws Exception;
    List<Course> getCourseByLevel(Integer idLevel) throws Exception;
    List<Course> getCourseByStatus(Integer status) throws Exception;
    List<Course> getCourseByEducation(Integer idEdu) throws Exception;
    List<Course> getCourseByEducationAndStastus(Integer idEdu, Integer status) throws Exception;
    List<Course> getCourseByEducationAndStastusAndLevel(Integer idEdu, Integer status, Integer idLevel) throws Exception;
    List<Course> getCourseByLevelAndEducation(Integer idLevel, Integer idEdu) throws Exception;
    Course getCourseById(Integer idCouese) throws Exception;
    Course addCourse(CourseDTO courseDTO) throws Exception;
    Course updateCourse(CourseDTO courseDTO, Integer idCourse) throws Exception;
    void removeCourse(Course course) throws Exception;
}
