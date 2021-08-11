package com.service;

import com.model.Account;

public interface AccountService extends Service<Account> {
    void setInactiveAccount(String id);
    Account findByUsername(String username);
    boolean isValidAccount(Account account);
}
