package com.course.api.service;

import com.course.api.entity.Marks;

import java.util.List;

public interface MarksService {
    List<Marks> getAll() throws Exception;
    Marks getMarksById(Integer idMarks) throws Exception;
    List<Marks> getMarksByClass(Integer idClass) throws Exception;
    List<Marks> getMarksByClassAndMark(Integer idClass) throws Exception;
    List<Marks> getMarksByStudent(Integer idStudent) throws Exception;
    Marks getMarksByClassAndStudent(Integer idClass, Integer idStudent) throws Exception;
    Marks addMarks(Marks marks) throws Exception;
    Marks updateMarks(Marks marks) throws Exception;
    void removeMarks(Marks marks) throws Exception;
    Marks save(Float marks, Integer id) throws Exception;
    List<Marks> saveALl(List<String> data) throws Exception;
}
