package com.example.dummyjson.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductClientIntegrationTest {

    @Autowired
    private ProductClient productClient;

    @Test
    void should_FetchAllProducts_WhenSuccessfully() {
        ProductResponse response = productClient.getAllProducts();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getProducts()).isNotEmpty();

    }

    @Test
    void should_FetchProductById_WhenSuccessfully() {
        Long productId = 1L;
        Product product = productClient.getProductById(productId);

        assertNotNull(product);
        assertEquals(productId, product.getId());

    }
}