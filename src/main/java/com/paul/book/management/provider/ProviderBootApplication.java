package com.paul.book.management.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

@EnableDubbo
@MapperScan({"com.paul.book.management.provider.mapper"})
@SpringBootApplication
public class ProviderBootApplication
{
	public static void main(String[] args) {
		ConfigurableApplicationContext springCtx = 
				SpringApplication.run(ProviderBootApplication.class);	
	}

}
