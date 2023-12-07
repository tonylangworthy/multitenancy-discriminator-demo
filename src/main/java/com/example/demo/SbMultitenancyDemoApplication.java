package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SbMultitenancyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMultitenancyDemoApplication.class, args);
	}

}
