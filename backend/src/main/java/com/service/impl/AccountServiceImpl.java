package com.service.impl;

import com.model.Account;
import com.repository.AccountRepository;
import com.service.AccountService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save(Account obj) {
        if (accountRepository.findById(obj.getUsername()).isPresent()) {
            throw new NullPointerException("Username already exist!");
        }
        accountRepository.save(obj);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(long id) {
        return null;
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow(() -> new NullPointerException("Account not found!"));
    }

    @Override
    public void deleteById(long id) {
    }

    public void setInactiveAccount(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Account not exist!"));

        account.setStatus(Account.ACTIVE);

        accountRepository.save(account);
    }

    @Override
    public void update(Account obj) {

    }
}
