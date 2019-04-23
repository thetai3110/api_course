package com.course.api.repository;

import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
    Exam findExamByIdExam(Integer idExam);
}
