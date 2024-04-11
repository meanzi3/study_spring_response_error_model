package com.example.error_and_response_model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ErrorAndResponseModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorAndResponseModelApplication.class, args);
	}

}
