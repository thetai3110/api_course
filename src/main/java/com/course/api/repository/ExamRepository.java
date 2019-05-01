package com.course.api.repository;

import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
    Exam findExamByIdExam(Integer idExam);
    List<Exam> findExamByStatus(Integer status);
}
