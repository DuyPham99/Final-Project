package com.service.impl;

import com.model.Product;
import com.repository.BrandRepository;
import com.repository.ProductRepository;
import com.service.ProductOptionService;
import com.service.ProductService;
import com.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public void save(Product product) {

        productRepository.findById(product.getIdProduct()).ifPresent(x -> {
            throw new DuplicateKeyException("The id already exist!");
        });

        product.getWarranty().setProduct(product);
        product.getProductOptions().forEach(x -> {
            x.setProduct(product);
        });
        product.setProductOptions(product.getProductOptions());

        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByBrandName(String name){
        return productRepository.findAllByBrandName(name, PageRequest.ofSize(8));
    }

    @Override
    public void deleteById(long id) {
        Product product = productRepository.getById(id);
        product.setStatus(1);
        productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public void update(Product obj) {
        Optional<Product> product =  productRepository.findById(obj.getIdProduct());
        if (product.isPresent()) {
            if(!obj.getName().isEmpty()){
                product.get().setName(obj.getName());
            }

            if(!obj.getDescription().isEmpty()){
                product.get().setDescription(obj.getDescription());
            }

            if(obj.getPublished() != null){
                product.get().setPublished(obj.getPublished());
            }

            productRepository.save(product.get());
        } else {
            throw new NullPointerException();
        }
    }
}
