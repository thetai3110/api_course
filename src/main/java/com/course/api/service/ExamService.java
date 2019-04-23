package com.course.api.service;

import com.course.api.dto.ExamDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> getAll() throws Exception;
    Exam getExamByCourse(Integer idCourse) throws Exception;
    Exam getExamById(Integer idExam) throws Exception;
    Exam addExam(ExamDTO examDTO) throws Exception;
    Exam updateExam(ExamDTO examDTO, Integer idExam) throws Exception;
    void removeExam(Exam exam) throws Exception;
}
