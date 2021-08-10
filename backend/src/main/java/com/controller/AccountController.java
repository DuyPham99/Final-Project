package com.controller;

import com.dto.AccountDto;
import com.github.dozermapper.core.Mapper;
import com.model.Account;
import com.model.Role;
import com.service.AccountService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController implements ControllerGeneric<AccountDto>{

    @Autowired
    AccountService accountService;

    @Autowired
    Mapper mapper;

    @Override
    public List<AccountDto> getList() {
        return accountService.findAll().stream()
                .map(x -> mapper.map(x, AccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto get(long id) {
        return mapper.map(accountService.findById(id), AccountDto.class);
    }

    @GetMapping("/get/{username}")
    public AccountDto findByUsername(@PathVariable String username) {
        return mapper.map(accountService.findByUsername(username), AccountDto.class);
    }

    @Override
    public void add(AccountDto obj) {
        Role role = new Role();

        role.setIdRole(obj.getIdRole());
        obj.setRole(role);

        accountService.save(mapper.map(obj, Account.class));
    }

    @Override
    public void update(AccountDto obj) {

    }

    @Override
    public void delete(long id) {

    }

    @GetMapping("/ban/{username}")
    public void setInactiveAccount(@PathVariable String username) {
        accountService.setInactiveAccount(username);
    }
}
