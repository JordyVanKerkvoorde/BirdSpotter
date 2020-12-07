package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//http.httpBasic();
		http.formLogin()
			.defaultSuccessUrl("/birdspotting", true);
			//.loginPage("/login").permitAll();
		
		http.authorizeRequests()
			.antMatchers("/*").hasRole("SPOTTER")
			.antMatchers("*/newbirdspotting").hasRole("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and().csrf();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("spotter").password("{noop}RedDuck007").roles("SPOTTER").and()
			.withUser("admin").password("{noop}eagle").roles("SPOTTER", "ADMIN");
	}
}
