package com.service.impl;

import com.model.Account;
import com.model.Shipping;
import com.repository.ShippingRepository;
import com.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    @Override
    public void save(Shipping obj) {
        obj.setStatus(Shipping.SHIPPING_STATUS.PROCESSING.getValue());
        shippingRepository.save(obj);
    }

    @Override
    public List<Shipping> findAll() {
        return shippingRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        shippingRepository.deleteById(id);
    }

    @Override
    public Shipping findById(long id) {
        return shippingRepository.findById(id).orElseThrow(() -> new NullPointerException("Shipping not exist!"));
    }

    @Override
    public void update(Shipping obj) {
        Shipping shipping = shippingRepository.getById(obj.getIdShipping());

        if(!obj.getDescription().isEmpty()){
            shipping.setDescription(obj.getDescription());
        }

        if(obj.getStartTime() != null){
            shipping.setStartTime(obj.getStartTime());
        }

        if(obj.getEndTime() != null){
            shipping.setEndTime(obj.getEndTime());
        }

        if(!obj.getShipType().isEmpty()){
            shipping.setShipType(obj.getShipType());
        }

        if(obj.getStatus() != 0){
            shipping.setStatus(obj.getStatus());
        }

        shippingRepository.save(obj);
    }
}
