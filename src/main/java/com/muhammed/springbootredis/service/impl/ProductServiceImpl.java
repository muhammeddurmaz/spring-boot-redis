package com.muhammed.springbootredis.service.impl;

import com.muhammed.springbootredis.domain.Product;
import com.muhammed.springbootredis.repository.ProductRepository;
import com.muhammed.springbootredis.service.ProductService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Cacheable(cacheNames = "product")
    public List<Product> getAll() throws InterruptedException {
        Thread.sleep(4000);
        return productRepository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "product")
    public void clearCache() {
        System.out.println("Cache temizlendi");
    }
}
