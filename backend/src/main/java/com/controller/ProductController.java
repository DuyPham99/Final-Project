package com.controller;

import com.dto.ProductDto;
import com.github.dozermapper.core.Mapper;
import com.model.Product;
import com.model.ProductOption;
import com.repository.ProductRepository;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products", method = RequestMethod.GET)
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    Mapper mapper;

    @GetMapping
    List<ProductDto> getListProduct(){
        System.out.println(productService.findAll().size());
        return productService.findAll().stream()
                .map( x -> mapper.map(x, ProductDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    void addProduct(@RequestBody @Valid ProductDto productDto){
        productService.save(mapper.map(productDto, Product.class));
    }

    @PutMapping("/update")
    void updateProduct(@RequestBody Product product){

    }

    @GetMapping("/delete/{id}")
    void deleteProduct(@PathVariable long id){
        productService.deleteById(id);
    }
}
