package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.revature.controller")
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		return new InternalResourceViewResolver();
	}

}
