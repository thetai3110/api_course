package com.course.api.service;

import com.course.api.dto.EmployeeDTO;
import com.course.api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll() throws Exception;
    Employee getEmployeeById(Integer idEmp) throws Exception;
    Employee getEmployeeByUsernameAndPass(String username, String pass) throws Exception;
    Employee addEmployee(Employee employee) throws Exception;
    Employee updateEmployee(Employee employee) throws Exception;
    void removeEmployee(Employee employee) throws Exception;
}
