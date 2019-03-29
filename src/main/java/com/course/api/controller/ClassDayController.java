package com.course.api.controller;

import com.course.api.dto.ClassDayDTO;
import com.course.api.entity.ClassDay;
import com.course.api.service.ClassDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/class-day")
public class ClassDayController {

    @Autowired
    private ClassDayService classDayService;

    @RequestMapping(value = "/{idClass}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassDayDTO>> getClassDayByClass(@PathVariable(name = "idClass") Integer idClass){
        try {
            List<ClassDayDTO> classDayDTOS = classDayService.getClassDayByClass(idClass);
            if(classDayDTOS.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<ClassDayDTO>>(classDayDTOS,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ClassDay> addClassDay(@RequestBody ClassDayDTO classDayDTO){
        try {
            if(classDayDTO==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<ClassDay>(classDayService.addClassDay(classDayDTO),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<ClassDay> updateClassDay(@PathVariable(name = "id") Integer id, @RequestBody ClassDayDTO classDayDTO){
        try {
            ClassDay curClassDay = classDayService.getClassDayById(id);
            if(curClassDay==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            return new ResponseEntity<ClassDay>(classDayService.updateClassDay(classDayDTO,id),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteClassDay(@PathVariable(name = "id") Integer id) {
        try {
            ClassDay classDay = classDayService.getClassDayById(id);
            if (classDay == null) return false;
            classDayService.removeClassDay(classDay);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
