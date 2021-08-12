package com.service.impl;

import com.model.Payment;
import com.repository.PaymentRepository;
import com.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void save(Payment obj) {
        paymentRepository.save(obj);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment findById(long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

    @Override
    public void update(Payment obj) {
        Payment payment = this.findById(obj.getIdPayment());

        if (!obj.getType().isEmpty()) {
            payment.setType(obj.getType());
        }

        if (!obj.getDescription().isEmpty()){
            payment.setDescription(obj.getDescription());
        }

        if (obj.getDateTime() != null){
            payment.setDateTime(obj.getDateTime());
        }

        paymentRepository.save(payment);
    }
}
