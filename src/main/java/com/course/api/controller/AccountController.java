package com.course.api.controller;

import com.course.api.entity.Account;
import com.course.api.entity.Employee;
import com.course.api.entity.Lecturers;
import com.course.api.entity.Student;
import com.course.api.service.AccountService;
import com.course.api.service.EmployeeService;
import com.course.api.service.LecturersService;
import com.course.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            if (account == null) return false;
            Student student = studentService.gettudentByAccount(id);
            if(student != null){
                student.setAccountStu(null);
                studentService.updateStudent(student);
            }
            Employee employee = employeeService.getEmployeeById(id);
            if(employee != null){
                employee.setAccountEmp(null);
                employeeService.updateEmployee(employee);
            }
            Lecturers lecturers = lecturersService.getLecturersById(id);
            if(lecturers != null){
                lecturers.setAccountLec(null);
                lecturersService.updateLecturers(lecturers);
            }
            accountService.removeAccount(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
