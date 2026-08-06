package com.czo.restaurantes_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestaurantesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantesApiApplication.class, args);
	}

}
