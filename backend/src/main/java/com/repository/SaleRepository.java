package com.repository;

import com.model.Product;
import com.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>, QuerydslPredicateExecutor<Sale> {
}
