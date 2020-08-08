package com.dev.spring.verify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@AutoConfigureAfter(DBInitializerConfig.class)
public class SpringMicroserviceVerifyCustomerFunds {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceVerifyCustomerFunds.class, args);
	}
}
