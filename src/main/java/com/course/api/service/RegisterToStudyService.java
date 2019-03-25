package com.course.api.service;

import com.course.api.dto.StudentClassDTO;
import com.course.api.model.ResponseModel;

public interface RegisterToStudyService {
    ResponseModel register(StudentClassDTO studentClassDTO) throws Exception;
}
