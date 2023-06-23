package com.simplespring.SimpleSpring.models;

import com.simplespring.SimpleSpring.repo.Repository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

import java.util.List;


@RestController
public class ModelController {
    @Autowired // reference to an object created at the initialization stage
    private Repository repository;


    @GetMapping("/") // an instruction for GET HTTP method for the main content
    public List<Model> getAllModels() {
        return repository.findAll();
    }


    @GetMapping("/add")
    public void addModel() {
        Model model = new Model("a", "a", "a", 1);
        repository.save(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable(value = "id") Integer ID) {
        Model model = repository.findById(ID).orElseThrow();
        return ResponseEntity.ok().body(model); // ResponseEntity - object in a database
    }

    @PostMapping("/")
    public Model createModel(@Valid @RequestBody Model model) {
        return repository.save(model);
    }

    @DeleteMapping("/{id}")
    public String deleteModel(@PathVariable(value = "id") Integer Id) {
        Model model = repository.findById(Id).orElseThrow();
        repository.delete(model);
        String response = new String("Deleted");
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable(value = "id") Integer id, @Valid @RequestBody Model newModel) {
        Model oldModel = repository.findById(id).orElseThrow();
        oldModel.setSpecies(newModel.getSpecies());
        oldModel.setColour(newModel.getColour());
        oldModel.setFirstAppearance(newModel.getFirstAppearance());
        oldModel.setWeight(newModel.getWeight());
        Model updatedModel = repository.save(oldModel);
        return ResponseEntity.ok(updatedModel);
    }
}
