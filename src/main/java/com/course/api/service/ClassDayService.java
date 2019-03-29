package com.course.api.service;

import com.course.api.dto.ClassDayDTO;
import com.course.api.entity.Ca;
import com.course.api.entity.ClassDay;
import com.course.api.entity.SchoolDay;

import java.util.List;

public interface ClassDayService {
    List<ClassDay> getAll() throws Exception;
    ClassDay getClassDayById(Integer idClassDay) throws Exception;
    List<ClassDay> getClassDayBySchoolDay(Integer idSd) throws Exception;
    List<ClassDay> getClassDayByCa(Integer idCa) throws Exception;
    List<ClassDayDTO> getClassDayByClass(Integer idClass) throws Exception;
    ClassDay addClassDay(ClassDayDTO classDayDTO) throws Exception;
    ClassDay updateClassDay(ClassDayDTO classDayDTO, Integer idClassDay) throws Exception;
    void removeClassDay(ClassDay classDay) throws Exception;
}
