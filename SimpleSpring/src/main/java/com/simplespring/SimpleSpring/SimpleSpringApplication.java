package com.simplespring.SimpleSpring;

import com.simplespring.SimpleSpring.models.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class SimpleSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringApplication.class, args);
	}

	@GetMapping("/") // main content
	public String hello()
	{
		return List.of(new Model("Bowhead Whale", "Black", LocalDate.of(2023, Month.JUNE, 1), 372)).toString();
	}
}
