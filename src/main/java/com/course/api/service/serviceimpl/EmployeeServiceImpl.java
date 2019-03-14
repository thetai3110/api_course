package com.course.api.service.serviceimpl;

import com.course.api.entity.Employee;
import com.course.api.repository.EmployeeRepository;
import com.course.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer idEmp) {
        return employeeRepository.findEmployeeByIdEmployee(idEmp);
    }

    @Override
    public Employee addEmployee(Employee employee){
        employee.setCreatedDate(new Date());
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee){
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void removeEmployee(Employee employee){
        employeeRepository.delete(employee);
    }
}
