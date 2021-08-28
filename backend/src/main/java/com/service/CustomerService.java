package com.service;

import com.model.Customer;

public interface CustomerService extends Service<Customer>{
    Customer findByPhoneNumber(String phoneNumber);
}
