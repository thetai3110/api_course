package com.course.api.service;

import com.course.api.dto.LecturersDTO;
import com.course.api.entity.Lecturers;
import com.course.api.entity.Majors;

import java.util.List;

public interface LecturersService {
    List<Lecturers> getAll() throws Exception;
    Lecturers getLecturersById(Integer idLec) throws Exception;
    Lecturers getLecturersAccount(Integer idAccount) throws Exception;
    List<Lecturers> getByMajors(Integer idMajors) throws Exception;
    Lecturers addLecturers(LecturersDTO lecturersDTO) throws Exception;
    Lecturers updateLecturers(LecturersDTO lecturersDTO, Integer idLec) throws Exception;
    Lecturers updateLecturers(Lecturers lecturers) throws Exception;
    void removeLecturers(Lecturers lecturers) throws Exception;
}
