package com.service;

import com.model.ProductOption;

import java.util.List;

public interface ProductOptionService extends Service<ProductOption>{
    void save(ProductOption product);
    void saveAll(List<ProductOption> products);
    List<ProductOption> findAll();
    void deleteById(long id);
}
