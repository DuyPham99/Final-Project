package com.service.impl;

import com.github.dozermapper.core.Mapper;
import com.model.Order;
import com.model.Payment;
import com.model.Shipping;
import com.repository.OrderRepository;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ShippingService shippingService;

    @Autowired
    AccountService accountService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    Mapper mapper;

    @Override
    public void save(Order obj) {
        Shipping shipping = new Shipping();

        try {
            shipping = (Shipping) shipping.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        obj.setStatus(0);
        obj.setShipping(shipping);
        obj.setAccount(accountService.findByUsername(obj.getAccount().getUsername()));
        obj.setCustomer(customerService.findById(obj.getCustomer().getIdCustomer()));

        orderRepository.save(obj);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

    @Override
    public void update(Order obj) {

    }
}
