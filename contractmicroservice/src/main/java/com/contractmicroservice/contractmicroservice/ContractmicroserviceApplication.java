package com.contractmicroservice.contractmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContractmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractmicroserviceApplication.class, args);
	}

        @Bean
        @LoadBalanced
        public RestTemplate restTemplate(){
        return new RestTemplate();
        }
}
