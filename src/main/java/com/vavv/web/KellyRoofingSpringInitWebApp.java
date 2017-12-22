package com.vavv.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class KellyRoofingSpringInitWebApp {

	public static void main(String[] args) {
		SpringApplication.run(KellyRoofingSpringInitWebApp.class, args);
	}

	@PostConstruct
	void postInit() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}

