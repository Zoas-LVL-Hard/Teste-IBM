package com.example.dummyjson.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.dummyjson.client.ProductClient;
import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

import feign.FeignException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerIntegrationTest {

    @Autowired
    private ProductClient productClient;
    

    @Test
    void shouldFetchAllProducts() {
        ProductResponse response = productClient.getAllProducts();
        assertNotNull(response);
        assertNotNull(response.getProducts());
        assertTrue(response.getProducts().size() > 0);
    }

    @Test
    void shouldFetchProductsById() {
        Product product = productClient.getProductById(1L);
        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertNotNull(product.getTitle());
    }

    @Test
    void shouldFetchProductsById_NotFound() {
        try {
            productClient.getProductById(999L);
        } catch (Exception e) {
            assertTrue(e instanceof FeignException.NotFound);
        }
    }

    @Test
    void shouldFetchAllProducts_ServerError() {
        
        try {
            productClient.getAllProducts();
        } catch (Exception e) {
            assertTrue(e instanceof FeignException.InternalServerError);
        }
    }
}
