package com.example.dummyjson.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductResponseIntegrationTest {

    @Test
    void testProductResponseGettersAndSetters() {
        // Cria uma lista de produtos de exemplo
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");
        product1.setDescription("Description 1");
        product1.setPrice(10.0);
        products.add(product1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");
        product2.setDescription("Description 2");
        product2.setPrice(20.0);
        products.add(product2);

        // Cria um objeto ProductResponse e define os valores
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(products);
        productResponse.setTotal(2);
        productResponse.setSkip(0);
        productResponse.setLimit(10);

        // Verifica se os getters retornam os valores corretos
        assertNotNull(productResponse.getProducts());
        assertEquals(2, productResponse.getProducts().size());
        assertEquals(2, productResponse.getTotal());
        assertEquals(0, productResponse.getSkip());
        assertEquals(10, productResponse.getLimit());

        // Verifica se os valores dos produtos estão corretos
        assertEquals(1L, productResponse.getProducts().get(0).getId());
        assertEquals("Product 1", productResponse.getProducts().get(0).getTitle());
        assertEquals("Description 1", productResponse.getProducts().get(0).getDescription());
        assertEquals(10.0, productResponse.getProducts().get(0).getPrice());

        assertEquals(2L, productResponse.getProducts().get(1).getId());
        assertEquals("Product 2", productResponse.getProducts().get(1).getTitle());
        assertEquals("Description 2", productResponse.getProducts().get(1).getDescription());
        assertEquals(20.0, productResponse.getProducts().get(1).getPrice());
    }
}
