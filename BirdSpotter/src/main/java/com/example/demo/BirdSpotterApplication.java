package com.example.demo;

import java.util.Collections;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
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
	
//	@Bean
//	public ServletContextInitializer servletContextInitializer() {
//		return new ServletContextInitializer() {
//			@Override
//			public void onStartup(ServletContext servletContext) throws ServletException{
//				servletContext.setSessionTrackingModes(
//						Collections.singleton(SessionTrackingMode.COOKIE));
//				SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
//				sessionCookieConfig.setHttpOnly(true);
//			} 
//		}; 
//	}

}
