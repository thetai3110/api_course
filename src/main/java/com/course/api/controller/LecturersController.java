package com.course.api.controller;

import com.course.api.dto.LecturersDTO;
import com.course.api.entity.Lecturers;
import com.course.api.service.LecturersService;
import com.course.api.service.MajorsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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

    @Autowired
    private MajorsService majorsService;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lecturers> getLecturersById(@PathVariable(name = "id") Integer id) {
        try {
            Lecturers lecturers = lecturersService.getLecturersById(id);
            if (lecturers == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Lecturers>(lecturers, HttpStatus.OK);
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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Lecturers> updateLecturers(@PathVariable(name = "id") Integer idLec, @RequestBody Lecturers lecturers) {
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteStudent(@PathVariable(name = "id") Integer id) {
        try {
            Lecturers lecturers = lecturersService.getLecturersById(id);
            if (lecturers == null) return false;
            lecturersService.removeLecturers(lecturers);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
