package com.course.api.service;

import com.course.api.dto.ExamDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> getAll() throws Exception;
    Exam getExamByClass(Integer idClass) throws Exception;
    Exam getExamById(Integer idExam) throws Exception;
    List<Exam> getExamByStatus(Integer status) throws Exception;
    Exam addExam(ExamDTO examDTO) throws Exception;
    Exam updateExam(ExamDTO examDTO, Integer idExam) throws Exception;
    void removeExam(Exam exam) throws Exception;
    boolean openExam(Integer idExam) throws Exception;
    boolean closeExam(Integer idExam) throws Exception;
    boolean finish(Integer idExam) throws Exception;
}
