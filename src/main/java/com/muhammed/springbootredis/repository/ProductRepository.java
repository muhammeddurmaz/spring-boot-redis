package com.muhammed.springbootredis.repository;

import com.muhammed.springbootredis.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
