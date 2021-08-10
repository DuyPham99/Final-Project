package com.service.impl;

import com.model.Stock;
import com.repository.StockRepository;
import com.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public void save(Stock obj) {
        stockRepository.save(obj);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        if (stockRepository.findById(id).isPresent()) {
            Stock stock = stockRepository.getById(id);
            stock.setStatus(1);
            stockRepository.save(stock);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public Stock findById(long id) {
        return stockRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

    @Override
    public void update(Stock obj) {
        if (stockRepository.findById(obj.getIdStock()).isPresent()) {
            Stock stock = stockRepository.findById(obj.getIdStock()).get();

            if (obj.getAmount() > 0) {
                stock.setAmount(obj.getAmount());
            }
            if (obj.getDateInput() != null && !obj.getDateInput().equals(stock.getDateInput())){
                stock.setDateInput(obj.getDateInput());
            }
            if(obj.getStatus() != stock.getStatus()){
                stock.setStatus(obj.getStatus());
            }

            stockRepository.save(stock);
        } else {
            throw new NullPointerException();
        }
    }
}
