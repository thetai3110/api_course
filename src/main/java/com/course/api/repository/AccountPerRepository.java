package com.course.api.repository;

import com.course.api.entity.Account;
import com.course.api.entity.AccountPer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountPerRepository extends JpaRepository<AccountPer, Integer> {
    AccountPer findAccountPerByIdAccountPer(Integer idAccountPer);
    List<AccountPer> findAccountPerByIdAccount(Integer idAccount);
    List<AccountPer> findAccountPerByIdPer(Integer idPer);
}
