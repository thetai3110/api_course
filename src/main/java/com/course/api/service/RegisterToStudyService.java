package com.course.api.service;

import com.course.api.dto.StudentDTO;
import com.course.api.model.ResponseModel;

import java.util.List;

public interface RegisterToStudyService {
    ResponseModel register(Integer idReg, List<StudentDTO> studentDTOs) throws Exception;
}
