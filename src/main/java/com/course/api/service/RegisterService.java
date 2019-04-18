package com.course.api.service;

import com.course.api.entity.Register;

import java.util.List;

public interface RegisterService {
    List<Register> getAll() throws Exception;
    Register getRegisterById(Integer idReg) throws Exception;
    Register addRegister(Register register) throws Exception;
    Register updateRegister(Register register) throws Exception;
    void removeRegister(Register register) throws Exception;
}
