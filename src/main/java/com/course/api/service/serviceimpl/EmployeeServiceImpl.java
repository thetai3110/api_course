package com.course.api.service.serviceimpl;

import com.course.api.dto.EmployeeDTO;
import com.course.api.entity.Employee;
import com.course.api.repository.AccountRepositoty;
import com.course.api.repository.EmployeeRepository;
import com.course.api.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepositoty accountRepositoty;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer idEmp) {
        return employeeRepository.findEmployeeByIdEmployee(idEmp);
    }

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<EmployeeDTO, Employee>() {
            @Override
            protected void configure() {
                skip().setIdEmployee(null);
            }
        });
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setAccountEmp(accountRepositoty.findAccountByIdAccount(employeeDTO.getIdAccount()));
        employee.setCreatedDate(new Date());
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO, Integer idEmployee){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<EmployeeDTO, Employee>() {
            @Override
            protected void configure() {
                skip().setIdEmployee(null);
            }
        });
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setIdEmployee(idEmployee);
        employee.setAccountEmp(accountRepositoty.findAccountByIdAccount(employeeDTO.getIdAccount()));
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void removeEmployee(Employee employee){
        employeeRepository.delete(employee);
    }
}
