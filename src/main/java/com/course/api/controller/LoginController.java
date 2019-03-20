package com.course.api.controller;

import com.course.api.dto.AccountDTO;
import com.course.api.dto.UserDTO;
import com.course.api.entity.Account;
import com.course.api.entity.Student;
import com.course.api.service.AccountService;
import com.course.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;

    //Kiểm tra tài khoản khi đăng nhập
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean doLogin(@RequestBody AccountDTO accountDTO){
        try {
            Account account = accountService.getAccountByUsernameAndPassword(accountDTO.getUsername(),accountDTO.getPass());
            if(account != null) return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Kiểm tra tài khoản đăng kí đã tồn tại chưa
    @RequestMapping(value = "/check-register", method = RequestMethod.POST)
    public boolean checkRegister(@RequestParam(name = "username") String username){
        try {
            Account account = accountService.getAccountByUsername(username);
            if(account != null) return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Đăng ký người dùng
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> doRegister(@RequestBody UserDTO userDTO) throws ParseException {
        //Tài khoản mới
        if(userDTO == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Account newAcc = new Account();
        newAcc.setUsername(userDTO.getUsername());
        newAcc.setPass(userDTO.getPass());
        //Người dùng mới
        Student newStu = new Student();
        newStu.setAccountStu(newAcc);
        newStu.setStudentName(userDTO.getName());
        newStu.setCmnd(userDTO.getCmnd());
        newStu.setStudentDate(userDTO.getDate());
        newStu.setSex(Integer.parseInt(userDTO.getSex()));
        newStu.setAddress(userDTO.getAddress());
        newStu.setEmail(userDTO.getEmail());
        newStu.setPhone(userDTO.getPhone());
        newStu.setJob(userDTO.getJob());
        try {
            accountService.addAccount(newAcc);
            studentService.addStudent(newStu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
