package com.course.api.service;

import com.course.api.entity.Marks;

import java.util.List;

public interface MarksService {
    List<Marks> getAll() throws Exception;
    Marks getMarksById(Integer idMarks) throws Exception;
    List<Marks> getMarksByCourse(Integer idCourse) throws Exception;
    List<Marks> getMarksByStudent(Integer idStudent) throws Exception;
    Marks addMarks(Marks marks) throws Exception;
    Marks updateMarks(Marks marks) throws Exception;
    void removeMarks(Marks marks) throws Exception;
}
