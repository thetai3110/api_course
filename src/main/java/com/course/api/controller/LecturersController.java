package com.course.api.controller;

import com.course.api.entity.Lecturers;
import com.course.api.service.LecturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lecturers")
public class LecturersController {

    @Autowired
    private LecturersService lecturersService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Lecturers>> getAllLecturers() {
        try {
            List<Lecturers> lecturers = lecturersService.getAll();
            if (lecturers.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Lecturers>>(lecturers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Lecturers> addLecturers(@RequestBody Lecturers lecturers) {
        try {
            if (lecturers == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Lecturers>(lecturersService.addLecturers(lecturers), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Lecturers> updateLecturers(@PathVariable(name = "idLec") Integer idLec, @RequestBody Lecturers lecturers) {
        try {
            Lecturers curLec = lecturersService.getLecturersById(idLec);
            if (curLec == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            lecturers.setIdLecturers(idLec);
            return new ResponseEntity<Lecturers>(lecturersService.updateLecturers(lecturers), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
