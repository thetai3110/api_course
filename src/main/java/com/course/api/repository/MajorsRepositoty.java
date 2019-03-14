package com.course.api.repository;

import com.course.api.entity.Majors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorsRepositoty extends JpaRepository<Majors, Integer> {
    Majors findMajorsByIdMajors(Integer idMajor);
}
