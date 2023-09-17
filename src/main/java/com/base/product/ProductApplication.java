package com.base.product;

import com.base.product.entity.Product;
import com.base.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                var product = Product.builder()
                        .name("test product 1")
                        .number("t1234GUOP")
                        .price(BigDecimal.valueOf(13.5))
                        .quantity(23)
                        .build();
                productRepository.save(product);
                logger.info("product created: " + product.getId());
            }
        };
    }

}
