package com.muhammed.springbootredis.web.rest;

import com.muhammed.springbootredis.domain.Product;
import com.muhammed.springbootredis.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private Integer sayac = 0;

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() throws InterruptedException {
        if(sayac == 3){
            productService.clearCache();
            sayac = 0;
        }
        sayac++;
        return ResponseEntity.ok().body(productService.getAll());
    }
}
