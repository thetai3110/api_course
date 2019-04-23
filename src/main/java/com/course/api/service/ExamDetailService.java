package com.course.api.service;

import com.course.api.entity.ExamDetail;

import java.util.List;

public interface ExamDetailService {
    List<ExamDetail> getAll() throws Exception;
    ExamDetail getExamDetailById(Integer idExamDetail) throws Exception;
    List<ExamDetail> getExamDetailByExam(Integer id) throws Exception;
    ExamDetail addExamDetail(ExamDetail examDetail) throws Exception;
    ExamDetail updateIExamDetail(ExamDetail examDetail) throws Exception;
    void removeExamDetail(ExamDetail examDetail) throws Exception;
}
