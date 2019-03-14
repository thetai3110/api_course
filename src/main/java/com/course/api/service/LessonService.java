package com.course.api.service;

import com.course.api.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll() throws Exception;
    List<Lesson> getByCourse(Integer idCourse) throws Exception;
    Lesson getByCourseAndDay(Integer idCourse, String days) throws Exception;
    Lesson getLessonById(Integer idLesson) throws Exception;
    Lesson addLesson(Lesson lesson) throws Exception;
    Lesson updateLesson(Lesson lesson) throws Exception;
    void removeLesson(Lesson lesson) throws Exception;
}
