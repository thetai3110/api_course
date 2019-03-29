package com.course.api.controller;

import com.course.api.entity.Ca;
import com.course.api.service.CaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ca")
public class CaController {

    @Autowired
    private CaService caService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Ca>> getAllCa(){
        try {
            List<Ca> cas = caService.getAll();
            if(cas.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Ca>>(cas,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
