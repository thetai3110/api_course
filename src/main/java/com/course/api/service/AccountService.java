package com.course.api.service;

import com.course.api.entity.Account;
import com.course.api.entity.Student;

import java.util.List;

public interface AccountService {
    List<Account> getAll() throws Exception;
    Account getAccountById(Integer id) throws Exception;
    Account getAccountByUsername(String username) throws Exception;
    Account getAccountByUsernameAndPassword(String username, String password) throws Exception;
    Account addAccount(Account account) throws Exception;
    Account updateAccount(Account account) throws Exception;
    void removeAccount(Account account) throws Exception;
}