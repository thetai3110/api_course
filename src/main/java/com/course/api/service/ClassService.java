package com.course.api.service;

import com.course.api.dto.ClassCourseStudentDTO;
import com.course.api.dto.ClassesDTO;
import com.course.api.entity.Clazz;

import java.util.List;

public interface ClassService {
    List<Clazz> getAll() throws Exception;
    Clazz getClassById(Integer idClazz) throws Exception;
    List<Clazz> getClassByCourse(Integer idCourse) throws Exception;
    List<Clazz> getClassByCourseAndStatus(Integer idCourse, Integer status) throws Exception;
    List<Clazz> getClassByLecturers(Integer idLec) throws Exception;
    List<Clazz> getClassByRoom(Integer idRoom) throws Exception;
    List<Clazz> getClassByStatus(Integer status) throws Exception;
    Clazz addClass(ClassesDTO classesDTO) throws Exception;
    Clazz updateClass(ClassesDTO classesDTO, Integer idClass) throws Exception;
    Clazz updateClass(Clazz clazz) throws Exception;
    void removeClass(Clazz clazz) throws Exception;
    boolean openClass(Integer id) throws Exception;
    boolean closeClass(Integer id) throws Exception;
    boolean cancelClass(Integer id) throws Exception;
    boolean finish(Integer id) throws Exception;
    boolean sendNotif(Integer idClass) throws Exception;
    void exportClass(Integer idClass, String fileName) throws Exception;
}
