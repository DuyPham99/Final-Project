package com.service.impl;

import com.model.ProductOption;
import com.repository.ProductOptionRepository;
import com.service.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductOptionServiceImpl implements ProductOptionService {
    @Autowired
    ProductOptionRepository productOptionRepository;


    @Override
    public void save(ProductOption product) {

    }

    @Override
    public void saveAll(List<ProductOption> products) {
        productOptionRepository.saveAll(products);
    }

    @Override
    public List<ProductOption> findAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public ProductOption findById(long id) {
        return null;
    }
}
