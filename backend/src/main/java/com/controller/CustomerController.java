package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController implements ControllerGeneric<Customer>{

    @Autowired
    CustomerService customerService;

    @Override
    public List<Customer> getList() {
        return customerService.findAll();
    }

    @Override
    public Customer get(long id) {
        return customerService.findById(id);
    }

    @Override
    public void add(@RequestBody @Valid Customer obj) {
        customerService.save(obj);
    }

    @Override
    public void update(@RequestBody @Valid Customer obj) {
        customerService.update(obj);
    }

    @Override
    public void delete(long id) {
        customerService.deleteById(id);
    }
}
