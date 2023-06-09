package com.simplespring.SimpleSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringApplication.class, args);
	}

	@GetMapping("/") // main content
	public String hello()
	{
		return "hello world";
	}
}
