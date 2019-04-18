package com.course.api.repository;

import com.course.api.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
    Register findRegisterByIdRegister(Integer idReg);
}
