package com.controller;

import com.dto.OrderDto;
import com.github.dozermapper.core.Mapper;
import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController implements ControllerGeneric<OrderDto>{

    @Autowired
    OrderService orderService;

    @Autowired
    Mapper mapper;

    @Override
    public List<OrderDto> getList() {
        return null;
    }

    @Override
    public OrderDto get(long id) {
        return null;
    }

    @Override
    public void add(OrderDto obj) {
        orderService.save(mapper.map(obj, Order.class));
    }

    @Override
    public void update(OrderDto obj) {

    }

    @Override
    public void delete(long id) {
        orderService.deleteById(id);
    }
}
