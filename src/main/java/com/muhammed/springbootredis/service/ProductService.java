package com.muhammed.springbootredis.service;

import com.muhammed.springbootredis.domain.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> getAll() throws InterruptedException;

    void clearCache();
}
