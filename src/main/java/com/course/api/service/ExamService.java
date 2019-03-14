package com.course.api.service;

import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> getAll() throws Exception;
    Exam getExamByClass(Integer idClazz) throws Exception;
    Exam getExamById(Integer idExam) throws Exception;
    Exam addExam(Exam exam) throws Exception;
    Exam updateExam(Exam exam) throws Exception;
    void removeExam(Exam exam) throws Exception;
}
