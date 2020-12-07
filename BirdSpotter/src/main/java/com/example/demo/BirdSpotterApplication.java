package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;

@SpringBootApplication
public class BirdSpotterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdSpotterApplication.class, args);
	}
	
	@Bean
	public SpottedBirdService spottedBirdService() {
		return new SpottedBirdServiceImpl();
	}
	
}
