package com.course.api.controller;

import com.course.api.dto.ExamDTO;
import com.course.api.entity.Exam;
import com.course.api.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Exam>> getAllExam() {
        try {
            List<Exam> employees = examService.getAll();
            if (employees.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Exam>>(employees, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Exam> getExamById(@PathVariable(name = "id") Integer id) {
        try {
            Exam exam = examService.getExamById(id);
            if (exam==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Exam>(exam, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Exam> addExam(@RequestBody ExamDTO examDTO) {
        try {
            if (examDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Exam>(examService.addExam(examDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Exam> updateExam(@PathVariable(name = "id") Integer id, @RequestBody ExamDTO examDTO) {
        try {
            Exam curExam = examService.getExamById(id);
            if (curExam == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Exam>(examService.updateExam(examDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteExam(@PathVariable(name = "id") Integer id) {
        try {
            Exam exam = examService.getExamById(id);
            if (exam == null) return false;
            examService.removeExam(exam);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
