package com.services.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScApplication.class, args);
	}

}
