package com.paul.book.management.provider;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//To extends SpringBootServletInitializer, and add ProviderBootApplication into SpringApplication.sources
public class ProviderSpringBootServletInitializer extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProviderBootApplication.class);
    }	
  
}
