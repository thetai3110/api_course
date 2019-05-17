package com.course.api.service.serviceimpl;

import com.course.api.entity.Register;
import com.course.api.entity.Sales;
import com.course.api.repository.RegisterRepository;
import com.course.api.repository.SalesRepository;
import com.course.api.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<Register> getAll() {
        return registerRepository.findAll();
    }

    @Override
    public Register getRegisterById(Integer idReg) {
        return registerRepository.findRegisterByIdRegister(idReg);
    }

    @Override
    public Register addRegister(Register register) {
        register.setCreatedDate(new Date());
        register.setModifyDate(new Date());
        if(register.getIdSale() != null && !register.getIdSale().equals("")){
            Sales sales = salesRepository.findSalesByCode(register.getIdSale());
            sales.setStatus(0);
            salesRepository.save(sales);
        }
        registerRepository.save(register);
        return register;
    }

    @Override
    public Register updateRegister(Register register) {
        register.setModifyDate(new Date());
        registerRepository.save(register);
        return register;
    }

    @Override
    public void removeRegister(Register register) {
        registerRepository.delete(register);
    }
}
