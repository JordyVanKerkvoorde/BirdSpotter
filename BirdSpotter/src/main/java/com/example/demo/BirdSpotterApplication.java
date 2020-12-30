package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;
import validator.NewSpotValidator;

@SpringBootApplication
public class BirdSpotterApplication implements WebMvcConfigurer{
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
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("403");
	}

}
