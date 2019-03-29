package com.course.api.controller;

import com.course.api.entity.Lesson;
import com.course.api.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> getAllLesson(){
        try {
            List<Lesson> lessons = lessonService.getAll();
            if(lessons.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Lesson>>(lessons,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> getLessonById(@PathVariable(name = "id") Integer id){
        try {
            Lesson lesson = lessonService.getLessonById(id);
            if(lesson==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Lesson>(lesson,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> getLessonByCourse(@PathVariable(name = "id") Integer id){
        try {
            List<Lesson> lessons = lessonService.getByCourse(id);
            if(lessons.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Lesson>>(lessons,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson){
        try {
            if(lesson==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Lesson>(lessonService.addLesson(lesson),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Lesson> updateLesson(@PathVariable(name = "id") Integer id, @RequestBody Lesson lesson){
        try {
            Lesson curLesson = lessonService.getLessonById(id);
            if(curLesson==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            lesson.setIdLesson(id);
            return new ResponseEntity<Lesson>(lessonService.updateLesson(lesson),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteLesson(@PathVariable(name = "id") Integer id) {
        try {
            Lesson lesson = lessonService.getLessonById(id);
            if (lesson == null) return false;
            lessonService.removeLesson(lesson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
