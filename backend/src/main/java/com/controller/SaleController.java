package com.controller;

import com.dto.SaleDto;
import com.github.dozermapper.core.Mapper;
import com.model.ProductOption;
import com.model.Sale;
import com.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sale")
public class SaleController implements ControllerGeneric<SaleDto> {

    @Autowired
    Mapper mapper;

    @Autowired
    SaleService saleService;

    @Override
    public List<SaleDto> getList() {
        return saleService.findAll().stream()
                .map(x -> mapper.map(x, SaleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaleDto get(long id) {
        return mapper.map(saleService.findById(id), SaleDto.class);
    }

    @Override
    public void add(@RequestBody @Valid SaleDto obj) {
        ProductOption productOption = new ProductOption();
        productOption.setIdProductOption(obj.getIdProductOption());
        obj.setProductOption(productOption);

        saleService.save(mapper.map(obj, Sale.class));
    }

    @Override
    public void update(SaleDto obj) {
        saleService.update(mapper.map(obj, Sale.class));
    }

    @Override
    public void delete(long id) {
        saleService.deleteById(id);
    }
}
