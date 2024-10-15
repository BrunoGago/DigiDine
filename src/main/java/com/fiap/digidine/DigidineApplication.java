package com.fiap.digidine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fiap.digidine")
public class DigidineApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigidineApplication.class, args);
	}

}
