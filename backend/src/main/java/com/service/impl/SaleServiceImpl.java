package com.service.impl;

import com.model.Sale;
import com.repository.SaleRepository;
import com.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @PersistenceContext
    EntityManager em;

    @Autowired
    SaleRepository saleRepository;

    @Override
    public void save(Sale obj) {
        saleRepository.save(obj);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public Sale findById(long id) {
        return saleRepository.findById(id).orElseThrow(() -> new NullPointerException("Element not found"));
    }

    @Override
    public void update(Sale obj) {
        Sale sale = saleRepository.findById(obj.getIdSale()).get();

        if (sale != null) {
            if (obj.getDiscount() != 0) {
                sale.setDiscount(obj.getDiscount());
            }
            if (obj.getDateStart() != null) {
                sale.setDateStart(obj.getDateStart());
            }
            if (obj.getDateEnd() != null) {
                sale.setDateEnd(obj.getDateEnd());
            }
        }

        saleRepository.save(sale);
    }
}
