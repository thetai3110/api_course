package com.course.api.repository;

import com.course.api.entity.SchoolDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDayRepository extends JpaRepository<SchoolDay, Integer> {
    SchoolDay findSchoolDayByIdSchoolDay(Integer idSchoolDay);
}
