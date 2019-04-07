package com.course.api.controller;

import com.course.api.dto.CourseDTO;
import com.course.api.entity.Course;
import com.course.api.service.CourseService;
import com.course.api.service.LevelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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

    @Autowired
    private LevelService levelService;

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
    public ResponseEntity<Course> getCourseById(@PathVariable(name = "id") Integer id){
        try {
            Course courses = courseService.getCourseById(id);
            if(courses==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Course>(courses,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Course> addCourse(@RequestBody CourseDTO courseDTO){
        try {
            if(courseDTO==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            if(!courseDTO.getImage().equals("")){
                String[] img = courseDTO.getImage().split("fakepath");
                courseDTO.setImage(img[1]);
            }else{
                courseDTO.setImage("");
            }
            return new ResponseEntity<Course>(courseService.addCourse(courseDTO),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Course> updateCourse(@PathVariable(name = "id") Integer idCourse, @RequestBody CourseDTO courseDTO){
        try {
            Course curCourse = courseService.getCourseById(idCourse);
            if(curCourse==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            if(!courseDTO.getImage().equals("")){
                String[] img = courseDTO.getImage().split("fakepath");
                courseDTO.setImage(img[1]);
            }else{
                String img = curCourse.getImage() == null || curCourse.getImage().equals("") ? "" : curCourse.getImage();
                courseDTO.setImage(img);
            }
            return new ResponseEntity<Course>(courseService.updateCourse(courseDTO, idCourse),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteCourse(@PathVariable(name = "id") Integer id) {
        try {
            Course course = courseService.getCourseById(id);
            if (course == null) return false;
            courseService.removeCourse(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
