package com.controller;

import com.model.Product;
import com.model.ProductOption;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/products", method = RequestMethod.GET)
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    List<Product> getListProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/add")
    void addProduct(@RequestBody @Valid Product product){
        productRepository.save(product);
    }

    @PutMapping("/update")
    void updateProduct(@RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    void deleteProduct(@PathVariable long id){
        productRepository.deleteById(id);
    }
}
