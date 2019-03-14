package com.course.api.controller;

import com.course.api.entity.Employee;
import com.course.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try {
            List<Employee> employees = employeeService.getAll();
            if (employees.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            if (employee == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "idEmp") Integer idEmp, @RequestBody Employee employee) {
        try {
            Employee curEmp = employeeService.getEmployeeById(idEmp);
            if (curEmp == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            employee.setIdEmployee(idEmp);
            return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
