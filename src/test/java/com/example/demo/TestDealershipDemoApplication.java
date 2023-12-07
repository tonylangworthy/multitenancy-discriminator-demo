package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestDealershipDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(SbMultitenancyDemoApplication::main)
                .with(TestContainerConfig.class)
                .run(args);
    }
}
