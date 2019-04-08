package com.course.api.service.serviceimpl;

import com.course.api.entity.Account;
import com.course.api.entity.AccountPer;
import com.course.api.repository.AccountRepositoty;
import com.course.api.service.AccountPerService;
import com.course.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepositoty accountRepositoty;

    @Autowired
    private AccountPerService accountPerService;

    @Override
    public List<Account> getAll(){
        return accountRepositoty.findAll();
    }

    @Override
    public Account getAccountById(Integer id) throws Exception {
        return accountRepositoty.findAccountByIdAccount(id);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepositoty.findAccountByUsername(username);
    }

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        return accountRepositoty.findAccountByUsernameAndPass(username,password);
    }

    @Override
    public Account addAccount(Account account) {
        account.setCreatedDate(new Date());
        account.setModifyDate(new Date());
        accountRepositoty.save(account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        account.setModifyDate(new Date());
        accountRepositoty.save(account);
        return account;
    }

    @Override
    public void removeAccount(Account account) throws Exception {
        if(!accountPerService.getAccountByAccount(account.getIdAccount()).isEmpty()){
            for (AccountPer acc:
                    accountPerService.getAccountByAccount(account.getIdAccount())) {
                accountPerService.removeAccountPer(acc);
            }
        }
        accountRepositoty.delete(account);
    }


}
