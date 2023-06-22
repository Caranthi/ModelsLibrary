package com.simplespring.SimpleSpring.models;

import com.simplespring.SimpleSpring.repo.Repository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ModelController {
    @Autowired // reference to an object created at the initialization stage
    private Repository repository;

    /*@GetMapping("/") // main content
    public String getModels() {
        return List.of(new Model("Bowhead Whale", "Black", LocalDate.of(2023, Month.JUNE, 1),
                372)).toString();
    }*/

    @GetMapping("/") // an instruction for GET HTTP method for the main content
    public List<Model> getAllModels()
    {
        return repository.findAll();
    }

    @GetMapping("test")
    public String test()
    {
        ArrayList<Model> list = (ArrayList<Model>) getAllModels();
        return list.toString();
    }

    @GetMapping("/add")
    public void add()
    {
        Model model = new Model("a", "a", "a", 1);
        repository.save(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable(value = "id") Integer ID)
    {
        Model model = repository.findById(ID).orElseThrow();
        return ResponseEntity.ok().body(model); // ResponseEntity - object in a database
    }

    @PostMapping("/")
    public Model createModel(@Valid @RequestBody Model model)
    {
        return repository.save(model);
    }
}
