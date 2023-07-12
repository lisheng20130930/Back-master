package com.qp.ots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAdminApplication.class, args);
	}

}
