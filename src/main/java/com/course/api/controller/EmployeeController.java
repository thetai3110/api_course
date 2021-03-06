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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Integer id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/username/{username}/{pass}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeByUserNameAndPass(@PathVariable(name = "username") String username,  @PathVariable(name = "pass") String pass) {
        try {
            Employee employee = employeeService.getEmployeeByUsernameAndPass(username, pass);
            if (employee==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") Integer idEmp, @RequestBody Employee employee) {
        try {
            Employee curEmp = employeeService.getEmployeeById(idEmp);
            if (curEmp == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            employee.setIdEmployee(idEmp);
            employee.setCreatedDate(curEmp.getCreatedDate());
            return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteEmployee(@PathVariable(name = "id") Integer id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) return false;
            employeeService.removeEmployee(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
