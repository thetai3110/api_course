package com.course.api.controller;

import com.course.api.entity.Level;
import com.course.api.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Level> addLevel(@RequestBody Level level) {
        try {
            if (level == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Level>(levelService.addLevel(level), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Level> updateLevel(@PathVariable(name = "id") Integer id, @RequestBody Level level) {
        try {
            Level curLevel = levelService.getLevelById(id);
            if (curLevel == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            level.setIdLevel(id);
            return new ResponseEntity<Level>(levelService.updateLevel(level), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
