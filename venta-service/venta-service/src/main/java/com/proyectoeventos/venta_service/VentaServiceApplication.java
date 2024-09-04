package com.proyectoeventos.venta_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class VentaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentaServiceApplication.class, args);
	}

}
