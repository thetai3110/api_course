package com.course.api.service;

import com.course.api.entity.SchoolDay;

import java.util.List;

public interface SchoolDayService {
    List<SchoolDay> getAll() throws Exception;
    SchoolDay getSchoolDayById(Integer idSchoolDay) throws Exception;
    SchoolDay addSchoolDay(SchoolDay schoolDay) throws Exception;
    SchoolDay updateSchoolDay(SchoolDay schoolDay) throws Exception;
    void removeSchoolDay(SchoolDay schoolDay) throws Exception;
}
