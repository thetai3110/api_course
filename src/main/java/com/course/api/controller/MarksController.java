package com.course.api.controller;

import com.course.api.entity.Marks;
import com.course.api.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Marks>> getAllMarks() {
        try {
            List<Marks> marks = marksService.getAll();
            if (marks.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Marks> getMarksById(@PathVariable(name = "id") Integer id) {
        try {
            Marks marks = marksService.getMarksById(id);
            if (marks == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Marks>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Marks>> getMarksByStudent(@PathVariable(name = "id") Integer id) {
        try {
            List<Marks> marks = marksService.getMarksByStudent(id);
            if (marks == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Marks>> getMarksByClass(@PathVariable(name = "id") Integer id) {
        try {
            List<Marks> marks = marksService.getMarksByClass(id);
            if (marks == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/class-marks/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Marks>> getMarksByClassAndMarks(@PathVariable(name = "id") Integer id) {
        try {
            List<Marks> marks = marksService.getMarksByClassAndMark(id);
            if (marks == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/class-student/{id}/{idStu}", method = RequestMethod.GET)
    public ResponseEntity<Marks> getMarksByClassAndMarks(@PathVariable(name = "id") Integer id, @PathVariable(name = "idStu") Integer idStu) {
        try {
            Marks marks = marksService.getMarksByClassAndStudent(id, idStu);
            if (marks == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Marks>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
        try {
            if (marks == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Marks>(marksService.addMarks(marks), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Marks> updateMarks(@PathVariable(name = "id") Integer id, @RequestBody Marks marks) {
        try {
            Marks curMarks = marksService.getMarksById(id);
            if (curMarks == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            marks.setIdMarks(id);
            return new ResponseEntity<Marks>(marksService.updateMarks(marks), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteMarks(@PathVariable(name = "id") Integer id) {
        try {
            Marks curMarks = marksService.getMarksById(id);
            if (curMarks == null) return false;
            marksService.removeMarks(curMarks);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/save/{id}/{marks}", method = RequestMethod.GET)
    public ResponseEntity<Marks> save(@PathVariable(name = "id") Integer id, @PathVariable(name = "marks") Float marks) {
        try {
            Marks marks1 = marksService.save(marks, id);
            if (marks1 == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Marks>(marks1, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/saveall", method = RequestMethod.POST)
    public ResponseEntity<List<Marks>> save(@RequestBody List<String> data) {
        try {
            List<Marks> marks = marksService.saveALl(data);
            if (marks.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
