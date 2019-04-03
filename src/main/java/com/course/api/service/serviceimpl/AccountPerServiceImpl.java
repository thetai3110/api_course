package com.course.api.service.serviceimpl;

import com.course.api.entity.AccountPer;
import com.course.api.repository.AccountPerRepository;
import com.course.api.service.AccountPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("accountPerService")
public class AccountPerServiceImpl implements AccountPerService {

    @Autowired
    private AccountPerRepository accountPerRepository;

    @Override
    public List<AccountPer> getAll() {
        return accountPerRepository.findAll();
    }

    @Override
    public AccountPer getAccountById(Integer id){
        return accountPerRepository.findAccountPerByIdAccountPer(id);
    }

    @Override
    public List<AccountPer> getAccountByAccount(Integer idAccount) {
        return accountPerRepository.findAccountPerByIdAccount(idAccount);
    }

    @Override
    public List<AccountPer> getAccountByPermission(Integer idPer) {
        return accountPerRepository.findAccountPerByIdPer(idPer);
    }

    @Override
    public AccountPer addAccountPer(AccountPer accountPer)  {
        accountPer.setCreatedDate(new Date());
        accountPer.setModifyDate(new Date());
        accountPerRepository.save(accountPer);
        return accountPer;
    }

    @Override
    public AccountPer updateAccountPer(AccountPer accountPer)  {
        accountPer.setModifyDate(new Date());
        accountPerRepository.save(accountPer);
        return accountPer;
    }

    @Override
    public void removeAccountPer(AccountPer accountPer) {
        accountPerRepository.delete(accountPer);
    }
}
