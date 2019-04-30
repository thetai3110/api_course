package com.course.api.repository;

import com.course.api.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
    Marks findMarksByIdMarks(Integer idMarks);
}
