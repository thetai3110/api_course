package com.course.api.service;

import com.course.api.entity.AccountPer;

import java.util.List;

public interface AccountPerService {

    List<AccountPer> getAll() throws Exception;
    AccountPer getAccountById(Integer id) throws Exception;
    List<AccountPer> getAccountByAccount(Integer idAccount) throws Exception;
    List<AccountPer> getAccountByPermission(Integer idPer) throws Exception;
    AccountPer addAccountPer(AccountPer accountPer) throws Exception;
    AccountPer updateAccountPer(AccountPer accountPer) throws Exception;
    void removeAccountPer(AccountPer accountPer) throws Exception;

}
