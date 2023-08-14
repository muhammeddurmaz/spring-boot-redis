package com.muhammed.springbootredis.service.impl;

import com.muhammed.springbootredis.domain.Product;
import com.muhammed.springbootredis.repository.ProductRepository;
import com.muhammed.springbootredis.service.ProductService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CacheManager cacheManager;

    public ProductServiceImpl(ProductRepository productRepository, CacheManager cacheManager) {
        this.productRepository = productRepository;
        this.cacheManager = cacheManager;
    }

    @Override
    @Cacheable(cacheNames = "product",key = "#product.name")
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

    @Override
    public List<Product> getProducts() throws InterruptedException {
        Thread.sleep(6000);
        return productRepository.findAll();
    }

    @Override
    public void clearCacheProducts() {
//        Objects.requireNonNull(cacheManager.getCache("product")).evict("product");
//        Cache productCache = cacheManager.getCache("product");
        Product product2 = new Product(2L,"product2",2);
//        if (productCache != null) {
//            productCache.evictIfPresent(product2);
//        }
        Objects.requireNonNull(cacheManager.getCache("product")).evict(2L);
        System.out.println("product temizlendi");
    }


}
