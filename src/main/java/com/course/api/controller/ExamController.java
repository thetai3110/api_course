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

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<Exam>> getExamByStatus(@PathVariable(name = "status") Integer status) {
        try {
            List<Exam> employees = examService.getExamByStatus(status);
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

    @RequestMapping(value = "/open/{idExam}", method = RequestMethod.GET)
    public boolean openExam(@PathVariable(name = "idExam") Integer id) {
        try {
            Exam exam = examService.getExamById(id);
            if(exam == null) return false;
            if(examService.openExam(id) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @RequestMapping(value = "/close/{idExam}", method = RequestMethod.GET)
    public boolean closeExam(@PathVariable(name = "idExam") Integer id) {
        try {
            Exam exam = examService.getExamById(id);
            if(exam == null) return false;
            if(examService.closeExam(id) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @RequestMapping(value = "/finish/{idExam}", method = RequestMethod.GET)
    public boolean finishExam(@PathVariable(name = "idExam") Integer id) {
        try {
            Exam exam = examService.getExamById(id);
            if(exam == null) return false;
            if(examService.finish(id) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
