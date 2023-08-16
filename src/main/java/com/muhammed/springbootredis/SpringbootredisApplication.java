package com.muhammed.springbootredis;

import com.muhammed.springbootredis.domain.Product;
import com.muhammed.springbootredis.repository.ProductRepository;
import com.muhammed.springbootredis.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Arrays;
import java.util.stream.Stream;


@SpringBootApplication
@EnableCaching
public class SpringbootredisApplication implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final ProductService productService;

	public SpringbootredisApplication(ProductRepository productRepository, ProductService productService) {
		this.productRepository = productRepository;
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootredisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Product product = new Product(1L,"product1",1);
		Product product2 = new Product(2L,"product2",2);
		Product product3 = new Product(3L,"product3",3);
		Product product4 = new Product(4L,"product4",4);
		Product product5 = new Product(5L,"product5",5);

		Stream.of(product,product2,product3,product4,product5).map(productService::save);

//		List<Product> list = productRepository.saveAll(Arrays.asList(product,product2,product3,product4,product5));

//		System.out.println(list);
	}

}
