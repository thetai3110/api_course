package com.course.api.repository;

import com.course.api.entity.ExamDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamDetailRepository extends JpaRepository<ExamDetail, Integer> {
    ExamDetail findExamDetailByIdExamDetail(Integer idExamDetail);
    List<ExamDetail> findExamDetailsByIdExam(Integer idExam);
}
