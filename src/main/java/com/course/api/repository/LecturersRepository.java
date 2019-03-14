package com.course.api.repository;

import com.course.api.entity.Lecturers;
import com.course.api.entity.Majors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LecturersRepository extends JpaRepository<Lecturers, Integer> {
    List<Lecturers> findLecturersByMajors(Majors majors);
    Lecturers findLecturersByIdLecturers(Integer idLec);
}
