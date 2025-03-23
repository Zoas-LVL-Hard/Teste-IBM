package com.example.dummyjson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.dummyjson.config.ApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperties.class)
@EnableFeignClients(basePackages = "com.example.dummyjson.client")
public class DummyJsonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyJsonClientApplication.class, args);
    }
}
