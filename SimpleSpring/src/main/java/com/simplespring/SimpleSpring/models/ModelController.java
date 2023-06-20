package com.simplespring.SimpleSpring.models;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class ModelController {
    @GetMapping("/") // main content
    public String getModels() {
        return List.of(new Model("Bowhead Whale", "Black", LocalDate.of(2023, Month.JUNE, 1),
                372)).toString();
    }
}
