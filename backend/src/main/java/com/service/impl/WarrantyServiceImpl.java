package com.service.impl;

import com.model.Warranty;
import com.repository.WarrantyRepository;
import com.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    WarrantyRepository warrantyRepository;

    @Override
    public void save(Warranty warranty) {
        warrantyRepository.save(warranty);
    }

    @Override
    public List<Warranty> findAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Warranty findById(long id) {

        return null;
    }
}
