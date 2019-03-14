package com.course.api.service;

import com.course.api.entity.Majors;

import java.util.List;

public interface MajorsService {
    List<Majors> getAll() throws Exception;
    Majors getMajorsById(Integer idMajors) throws Exception;
    Majors addMajors(Majors majors) throws Exception;
    Majors updateMajors(Majors majors) throws Exception;
    void removeMajors(Majors majors) throws Exception;
}
