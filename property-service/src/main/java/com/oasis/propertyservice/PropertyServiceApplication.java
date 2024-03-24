package com.oasis.propertyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.oasis.propertyservice.repo")
public class PropertyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertyServiceApplication.class, args);
	}
}
