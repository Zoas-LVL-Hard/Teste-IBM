package com.example.dummyjson.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiPropertiesIntegrationTest {

    @Autowired
    private ApiProperties apiProperties;

    @Test
    void testApiProperties() {
        assertNotNull(apiProperties);
        assertEquals("https://dummyjson.com/products", apiProperties.getUrl());
    }
}
