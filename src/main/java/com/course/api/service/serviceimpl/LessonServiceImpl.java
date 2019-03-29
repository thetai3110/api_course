package com.course.api.service.serviceimpl;

import com.course.api.entity.Lesson;
import com.course.api.repository.LessonRepository;
import com.course.api.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("lessonService")
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> getByCourse(Integer idCourse) {
        return lessonRepository.findLessonByIdCourse(idCourse);
    }

    @Override
    public Lesson getByCourseAndDay(Integer idCourse, String day) {
        return lessonRepository.findLessonByIdCourseAndDays(idCourse,day);
    }

    @Override
    public Lesson getLessonById(Integer idLesson) {
        return lessonRepository.findLessonByIdLesson(idLesson);
    }

    @Override
    public Lesson addLesson(Lesson lesson) {
        lesson.setCreatedDate(new Date());
        lesson.setModifyDate(new Date());
        lessonRepository.save(lesson);
        return lesson;
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        lesson.setModifyDate(new Date());
        lessonRepository.save(lesson);
        return lesson;
    }

    @Override
    public void removeLesson(Lesson lesson) {
        lessonRepository.delete(lesson);
    }
}
