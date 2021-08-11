package com.service.impl;

import com.model.Customer;
import com.repository.CustomerRepository;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(Customer obj) {
        obj.setStatus(Customer.STATUS.ACTIVE.getValue());

        customerRepository.save(obj);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

    @Override
    public void update(Customer obj) {
        Customer customer = this.findById(obj.getIdCustomer());

        if (obj.getStatus() != 0) {
            customer.setStatus(obj.getStatus());
        }

        if (!obj.getAddress().isEmpty()) {
            customer.setAddress(obj.getAddress());
        }

        if (!obj.getName().isEmpty()) {
            customer.setName(obj.getName());
        }

        if (!obj.getPhone_number().isEmpty()) {
            customer.setPhone_number(obj.getPhone_number());
        }

        customerRepository.save(customer);
    }
}
