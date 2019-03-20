package com.course.api.controller;

import com.course.api.entity.Level;
import com.course.api.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Level>> getAllLevel(){
        try {
            List<Level> levels = levelService.getAll();
            if(levels.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Level>>(levels,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
