package com.controller;

import com.dto.StockDto;
import com.github.dozermapper.core.Mapper;
import com.model.ProductOption;
import com.model.Stock;
import com.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stock")
public class StockController implements ControllerGeneric<StockDto> {

    @Autowired
    StockService stockService;

    @Autowired
    Mapper mapper;

    @Override
    public List<StockDto> getList() {
        return stockService.findAll().stream()
                .map(x -> mapper.map(x, StockDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StockDto get(long id) {
        return mapper.map(stockService.findById(id), StockDto.class);
    }

    @Override
    public void add(StockDto obj) {
        ProductOption productOption = new ProductOption();
        productOption.setIdProductOption(obj.getIdProductOption());
        obj.setProductOption(productOption);

        stockService.save(mapper.map(obj, Stock.class));
    }

    @Override
    public void update(StockDto obj) {
        stockService.update(mapper.map(obj, Stock.class));
    }

    @Override
    public void delete(long id) {
        stockService.deleteById(id);
    }
}
