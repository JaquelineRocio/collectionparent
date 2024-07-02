package com.collection.tablon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TablonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablonApplication.class, args);
	}

}
