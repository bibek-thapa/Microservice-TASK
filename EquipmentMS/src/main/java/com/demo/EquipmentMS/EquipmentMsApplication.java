package com.demo.EquipmentMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@EnableCircuitBreaker
public class EquipmentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentMsApplication.class, args);
	}

}
