package com.dev.spring.instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients("com.in28minutes.springboot.microservice.example.currencyconversion")
@EnableDiscoveryClient
public class SpringBootMicroserviceInstantMoneyLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceInstantMoneyLoanApplication.class, args);
	}
}
