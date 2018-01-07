package com.ril.ipdr.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@Configuration
@ComponentScan
public class Application {

	@RequestMapping("/")
	String home() {
		return "Welcome to IPDR Rest API's";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
