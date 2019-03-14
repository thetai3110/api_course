package com.course.api.controller;

import com.course.api.entity.Course;
import com.course.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourse(){
        try {
            List<Course> courses = courseService.getAll();
            if(courses.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getCourseByLevel(@PathVariable(name = "id") Integer idLevel){
        try {
            List<Course> courses = courseService.getCourseByLevel(idLevel);
            if(courses.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        try {
            if(course==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Course>(courseService.addCourse(course),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Course> updateCourse(@PathVariable(name = "idCourse") Integer idCourse, @RequestBody Course course){
        try {
            Course curCourse = courseService.getCourseById(idCourse);
            if(curCourse==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            course.setIdCourse(idCourse);
            return new ResponseEntity<Course>(courseService.updateCourse(course),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
