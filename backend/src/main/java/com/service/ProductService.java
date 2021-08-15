package com.service;

import com.dto.ProductDto;
import com.model.Product;

import java.util.List;

public interface ProductService extends Service<Product>{
    List<Product> findAllByBrandName(String name);
}
