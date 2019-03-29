package com.course.api.controller;

import com.course.api.entity.Account;
import com.course.api.service.AccountService;
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
}
