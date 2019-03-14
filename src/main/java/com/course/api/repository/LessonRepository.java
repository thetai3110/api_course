package com.course.api.repository;

import com.course.api.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findLessonByIdCourse(Integer idCourse);
    Lesson findLessonByIdCourseAndDays(Integer idCourse, String days);
    Lesson findLessonByIdLesson(Integer idLesson);
}
