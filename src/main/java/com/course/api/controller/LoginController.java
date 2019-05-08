package com.course.api.controller;

import com.course.api.dto.UserDTO;
import com.course.api.entity.Employee;
import com.course.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean checkAccount(@RequestBody UserDTO userDTO){
        try{
            if(userDTO == null) return false;
            Employee employee = employeeService.getEmployeeByUsernameAndPass(userDTO.getUsername(), userDTO.getPass());
            if(employee != null) return true;
            else return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
