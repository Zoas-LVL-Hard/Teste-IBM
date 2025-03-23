package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dummyjson.dto.Product;

import feign.FeignException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    void shouldFetchAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }

    @Test
    void shouldFetchProductsById() {
        Product product = productService.getProductById(1L);
        assertNotNull(product);
        assertNotNull(product.getTitle());
    }

    @Test
    void shouldFetchProductsById_NotFound() {
        Exception exception = assertThrows(FeignException.NotFound.class, () -> {
            productService.getProductById(999L);
        });
        assertNotNull(exception);
    }

    @Test
    void shouldFetchProductsById_InvalidId() {
        Exception exception = assertThrows(FeignException.NotFound.class, () -> {
            productService.getProductById(-1L);
        });
        assertNotNull(exception);
    }

}
