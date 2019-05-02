package com.course.api.controller;

import com.course.api.entity.ExamDetail;
import com.course.api.service.ExamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "exam-detail")
public class ExamDetailController {

    @Autowired
    private ExamDetailService examDetailService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ExamDetail>> getAllExamDetail() {
        try {
            List<ExamDetail> examDetails = examDetailService.getAll();
            if (examDetails.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<ExamDetail>>(examDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ExamDetail> getExamDetailById(@PathVariable(name = "id") Integer id) {
        try {
            ExamDetail examDetail = examDetailService.getExamDetailById(id);
            if (examDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<ExamDetail>(examDetail, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/exam/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ExamDetail>> getExamDetailByExam(@PathVariable(name = "id") Integer id) {
        try {
            List<ExamDetail> examDetail = examDetailService.getExamDetailByExam(id);
            if (examDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<ExamDetail>>(examDetail, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ExamDetail> addExamDetail(@RequestBody ExamDetail examDetail) {
        try {
            if (examDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<ExamDetail>(examDetailService.addExamDetail(examDetail), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/multi/add", method = RequestMethod.POST)
    public ResponseEntity<List<ExamDetail>> addMultiExamDetail(@RequestBody List<ExamDetail> examDetails) {
        try {
            if (examDetails.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<ExamDetail>>(examDetailService.addMultiExamDetail(examDetails), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<ExamDetail> updateExamDetail(@PathVariable(name = "id") Integer id, @RequestBody ExamDetail examDetail) {
        try {
            ExamDetail curExamDetail = examDetailService.getExamDetailById(id);
            if (curExamDetail == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            examDetail.setIdExamDetail(id);
            return new ResponseEntity<ExamDetail>(examDetailService.updateIExamDetail(examDetail), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteExamDetail(@PathVariable(name = "id") Integer id) {
        try {
            ExamDetail examDetail = examDetailService.getExamDetailById(id);
            if (examDetail == null) return false;
            examDetailService.removeExamDetail(examDetail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
