package com.service;

import com.model.Product;

import java.util.List;

public interface Service<T> {
    void save(T obj);
    List<T> findAll();
    void deleteById(long id);
    T findById(long id);
    void update(T obj);
}
