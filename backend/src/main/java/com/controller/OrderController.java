package com.controller;

import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController implements ControllerGeneric<Order>{

    @Autowired
    OrderService orderService;

    @Override
    public List<Order> getList() {
        return null;
    }

    @Override
    public Order get(long id) {
        return null;
    }

    @Override
    public void add(Order obj) {
        orderService.save(obj);
    }

    @Override
    public void update(Order obj) {

    }

    @Override
    public void delete(long id) {

    }
}
