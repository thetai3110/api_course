package com.course.api.service;

import com.course.api.dto.UserDTO;
import com.course.api.model.ResponseModel;

public interface RegisterAccountService {
    ResponseModel register(UserDTO userDTO) throws Exception;
}
