package com.course.api.controller;

import com.course.api.dto.AccountDTO;
import com.course.api.dto.UserDTO;
import com.course.api.entity.Account;
import com.course.api.entity.Student;
import com.course.api.model.ResponseModel;
import com.course.api.service.AccountService;
import com.course.api.service.RegisterAccountService;
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

    @Autowired
    private RegisterAccountService registerAccountService;

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
    @RequestMapping(value = "/check-register/{username}", method = RequestMethod.GET)
    public boolean checkRegister(@PathVariable(name = "username") String username){
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
    public ResponseEntity<ResponseModel> doRegister(@RequestBody UserDTO userDTO) throws ParseException {
        //Tài khoản mới
        try {
            if(userDTO == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<ResponseModel>(registerAccountService.register(userDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
