package com.example.dummyjson.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductIntegrationTest {

    
    @Test
    void testProductGettersAndSetters() {
        Long expectId = 1L;
        String expectedTitle = "Uma letra";
        String expectedDescription = "Uma letra qualquer";
        Double expectedPrice = 2.1;

        Product product = new Product();
        product.setId(expectId);
        product.setTitle(expectedTitle);
        product.setDescription(expectedDescription);
        product.setPrice(expectedPrice);

        assertEquals(expectId, product.getId());
        assertEquals(expectedTitle, product.getTitle());
        assertEquals(expectedDescription, product.getDescription());
        assertEquals(expectedPrice, product.getPrice());
    }
}
