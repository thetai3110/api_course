package com.course.api.controller;

import com.course.api.entity.Register;
import com.course.api.sendemail.Email;
import com.course.api.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/register")
public class RegisterControler {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Register>> getAllRegister() {
        try {
            List<Register> registers = registerService.getAll();
            if (registers.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Register>>(registers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Register> getRegisterById(@PathVariable(name = "id") Integer id) {
        try {
            Register register = registerService.getRegisterById(id);
            if (register==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Register>(register, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Register> addRegister(@RequestBody Register register) {
        try {
            if (register == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            Register register1 = registerService.addRegister(register);
            if(register1 != null)
                Email.send("Đăng ký học tại trung tâm",
                        "Đơn của bạn đã được chấp nhận, vui lòng hoàn tất thông tin trên đường link",
                        register1.getEmail(),register1.getIdRegister());
            return new ResponseEntity<Register>(register1, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Register> updateRegister(@PathVariable(name = "id") Integer id, @RequestBody Register register) {
        try {
            Register curRegister = registerService.getRegisterById(id);
            if (curRegister == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            register.setIdRegister(id);
            return new ResponseEntity<Register>(registerService.updateRegister(register), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteRegister(@PathVariable(name = "id") Integer id) {
        try {
            Register register = registerService.getRegisterById(id);
            if (register == null) return false;
            registerService.removeRegister(register);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
