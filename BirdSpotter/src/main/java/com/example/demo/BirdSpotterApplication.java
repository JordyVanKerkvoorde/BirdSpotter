package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;
import validator.NewSpotValidator;

@SpringBootApplication
public class BirdSpotterApplication {
	@Bean
	public NewSpotValidator newSpotValidation() {
		return new NewSpotValidator();
	}

	public static void main(String[] args) {
		SpringApplication.run(BirdSpotterApplication.class, args);
	}
	
	@Bean
	public SpottedBirdService spottedBirdService() {
		return new SpottedBirdServiceImpl();
	}
	

}
