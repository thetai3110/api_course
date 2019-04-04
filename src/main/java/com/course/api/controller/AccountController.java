package com.course.api.controller;

import com.course.api.entity.*;
import com.course.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LecturersService lecturersService;

    @Autowired
    private AccountPerService accountPerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllAccount() {
        try {
            List<Account> accounts = accountService.getAll();
            if (accounts.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable(name = "id") Integer id) {
        try {
            Account account = accountService.getAccountById(id);
            if (account==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        try {
            if (account == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Account> updateAccount(@PathVariable(name = "id") Integer idAccount, @RequestBody Account account) {
        try {
            Account curAccount = accountService.getAccountById(idAccount);
            if (curAccount == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            account.setIdAccount(idAccount);
            return new ResponseEntity<Account>(accountService.updateAccount(account), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteAccount(@PathVariable(name = "id") Integer id) {
        try {
            Account account = accountService.getAccountById(id);
            if (account == null)
                return false;
            else {
                if (studentService.gettudentByAccount(id) != null) {
                    Student student = studentService.gettudentByAccount(id);
                    student.setAccountStu(null);
                    studentService.updateStudent(student);
                }
                if (employeeService.getEmployeeAccount(id) != null) {
                    Employee employee = employeeService.getEmployeeAccount(id);
                    employee.setAccountEmp(null);
                    employeeService.updateEmployee(employee);
                }
                if (lecturersService.getLecturersAccount(id) != null) {
                    Lecturers lecturers = lecturersService.getLecturersAccount(id);
                    lecturers.setAccountLec(null);
                    lecturersService.updateLecturers(lecturers);
                }
                if(!accountPerService.getAccountByAccount(id).isEmpty()){
                    for (AccountPer accPer: accountPerService.getAccountByAccount(id)
                         ) {
                        accountPerService.removeAccountPer(accPer);
                    }
                }
                accountService.removeAccount(account);
                return true;
            }
        } catch (NoResultException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
