package com.service.impl;

import com.model.Account;
import com.repository.AccountRepository;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void save(Account obj) {
        if (accountRepository.findById(obj.getUsername()).isPresent()) {
            throw new NullPointerException("Username already exist!");
        }
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));

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
    public boolean isValidAccount(Account account) {
        String enCodePassword = passwordEncoder.encode(account.getPassword());
        Account accountCheck = accountRepository.findByUsername(account.getUsername())
                .orElseThrow(() -> new NullPointerException("Account doesn't exist!"));

        return accountCheck.getPassword().equals(enCodePassword);
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
