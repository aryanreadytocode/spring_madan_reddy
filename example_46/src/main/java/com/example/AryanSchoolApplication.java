package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.proxy")
@SpringBootApplication
public class AryanSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(AryanSchoolApplication.class, args);
	}

}
