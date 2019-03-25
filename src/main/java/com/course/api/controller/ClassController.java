package com.course.api.controller;

import com.course.api.dto.ClassesDTO;
import com.course.api.entity.Clazz;
import com.course.api.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/follow-course/{idCourse}", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClassesByCourse(@PathVariable(name = "idCourse") Integer idCourse){
        try {
            List<Clazz> classes = classService.getClassByCourse(idCourse);
            if(classes.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Clazz>>(classes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/follow-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Clazz> getClassesById(@PathVariable(name = "id") Integer idClass){
        try {
            Clazz classes = classService.getClassById(idClass);
            if(classes==null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Clazz>(classes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getAllClass() {
        try {
            List<Clazz> clazzes = classService.getAll();
            if (clazzes.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Clazz>>(clazzes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Clazz> addClass(@RequestBody ClassesDTO classesDTO) {
        try {
            if (classesDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Clazz>(classService.addClass(classesDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Clazz> updateClass(@PathVariable(name = "idClazz") Integer idClazz, @RequestBody Clazz clazz) {
        try {
            Clazz curClazz = classService.getClassById(idClazz);
            if (curClazz == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            clazz.setIdClass(idClazz);
            return new ResponseEntity<Clazz>(classService.updateClass(clazz), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
