package com.course.api.service;

import com.course.api.dto.EmployeeDTO;
import com.course.api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll() throws Exception;
    Employee getEmployeeById(Integer idEmp) throws Exception;
    Employee getEmployeeAccount(Integer idAccount) throws Exception;
    Employee addEmployee(EmployeeDTO employeeDTO) throws Exception;
    Employee updateEmployee(EmployeeDTO employeeDTO, Integer idEmployee) throws Exception;
    Employee updateEmployee(Employee employee) throws Exception;
    void removeEmployee(Employee employee) throws Exception;
}
