package com.controller;

import com.dto.ProductDto;
import com.github.dozermapper.core.Mapper;
import com.model.Brand;
import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products", method = RequestMethod.GET)
public class ProductController implements ControllerGeneric<ProductDto> {

    @Autowired
    Mapper mapper;

    @Autowired
    ProductService productService;

    @Override
    public List<ProductDto> getList() {
        return productService.findAll().stream()
                .map(x -> mapper.map(x, ProductDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/brand/{brand}")
    public List<ProductDto> getListProductsByBrand(@PathVariable String brand) {
        return productService.findAllByBrandName(brand).stream()
                .map(x -> mapper.map(x, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto get(@PathVariable long id) {
        return mapper.map(productService.findById(id), ProductDto.class);
    }

    @Override
    public void add(ProductDto obj) {
        obj.setBrand(new Brand());
        obj.getBrand().setId_brand(obj.getBrandId());
        productService.save(mapper.map(obj, Product.class));
    }

    @Override
    public void update(ProductDto obj) {
        productService.update(mapper.map(obj, Product.class));
    }

    @Override
    public void delete(long id) {
        productService.deleteById(id);
    }

//
//    @GetMapping
//    List<ProductDto> getListProduct(){
//        System.out.println(productService.findAll().size());
//        return productService.findAll().stream()
//                .map( x -> mapper.map(x, ProductDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @PostMapping("/add")
//    void addProduct(@RequestBody @Valid ProductDto productDto){
//        productDto.setBrand(new Brand());
//        productDto.getBrand().setId_brand(productDto.getBrandId());
//        productService.save(mapper.map(productDto, Product.class));
//    }
//
//    @PutMapping("/update")
//    void updateProduct(@RequestBody ProductDto productDto){
//        productService.update(mapper.map(productDto, Product.class));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    void deleteProduct(@PathVariable long id){
//        productService.deleteById(id);
//    }
}
