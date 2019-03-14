package com.course.api.repository;

import com.course.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepositoty extends JpaRepository<Account, Integer> {
    Account findAccountByUsername(String username);
    Account findAccountByUsernameAndPass(String username, String pass);
    Account findAccountByIdAccount(Integer idAccount);
}
