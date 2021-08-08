package com.service.impl;

import com.dto.ProductDto;
import com.model.Product;
import com.repository.BrandRepository;
import com.repository.ProductRepository;
import com.service.ProductOptionService;
import com.service.ProductService;
import com.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ProductOptionService productOptionService;

    @Autowired
    WarrantyService warrantyService;

    @Override
    public void save(Product productDto) {
        Product product = new Product();

        productDto.getWarranty().setProduct(product);
        productDto.getProductOptions().forEach(x -> {
            x.setProduct(product);
        });
        product.setProductOptions(productDto.getProductOptions());

        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(NullPointerException::new);
    }


}
