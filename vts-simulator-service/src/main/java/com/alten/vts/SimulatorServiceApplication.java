package com.alten.vts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class SimulatorServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SimulatorServiceApplication.class, args);
	}
}
