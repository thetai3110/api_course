package com.course.api.service;

import com.course.api.entity.EducationProgram;

import java.util.List;

public interface EducationProgramService {
    List<EducationProgram> getAll() throws Exception;
    EducationProgram getEducationProgramById(Integer id) throws Exception;
    EducationProgram addEducationProgram(EducationProgram educationProgram) throws Exception;
    EducationProgram updateEducationProgram(EducationProgram educationProgram) throws Exception;
    void removeEducationProgram(EducationProgram educationProgram) throws Exception;
}
