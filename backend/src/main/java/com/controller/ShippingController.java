package com.controller;

import com.model.Shipping;
import com.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController implements ControllerGeneric<Shipping> {

    @Autowired
    ShippingService shippingService;

    @Override
    public List<Shipping> getList() {
        return shippingService.findAll();
    }

    @Override
    public Shipping get(long id) {
        return shippingService.findById(id);
    }

    @Override
    public void add(@RequestBody @Valid Shipping obj) {
        shippingService.save(obj);
    }

    @Override
    public void update(@RequestBody @Valid Shipping obj) {
        shippingService.update(obj);
    }

    @Override
    public void delete(long id) {
        shippingService.deleteById(id);
    }
}
