package com.course.api.controller;

import com.course.api.entity.AccountPer;
import com.course.api.service.AccountPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acc-per")
public class AccountPerController {

    @Autowired
    private AccountPerService accountPerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AccountPer>> getAllAccPer(){
        try {
            List<AccountPer> accountPers = accountPerService.getAll();
            if(accountPers.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<AccountPer>>(accountPers,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountPer>> getAccPerByAccount(@PathVariable(name = "id") Integer id){
        try {
            List<AccountPer> accountPers = accountPerService.getAccountByAccount(id);
            if(accountPers.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<AccountPer>>(accountPers,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<AccountPer> addAccountPer(@RequestBody AccountPer accountPer){
        try {
            if(accountPerService==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<AccountPer>(accountPerService.addAccountPer(accountPer),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<AccountPer> updateAccountPer(@PathVariable(name = "id") Integer id, @RequestBody AccountPer accountPer){
        try {
            AccountPer accountPer1 = accountPerService.getAccountById(id);
            if(accountPer1==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            accountPer.setIdAccountPer(id);
            return new ResponseEntity<AccountPer>(accountPerService.updateAccountPer(accountPer),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteAccountPer(@PathVariable(name = "id") Integer id) {
        try {
            AccountPer accountPer = accountPerService.getAccountById(id);
            if (accountPer == null) return false;
            accountPerService.removeAccountPer(accountPer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
