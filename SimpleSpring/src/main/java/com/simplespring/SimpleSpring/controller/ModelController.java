package com.simplespring.SimpleSpring.controller;

import com.simplespring.SimpleSpring.model.Model;
import com.simplespring.SimpleSpring.repo.Repository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class ModelController {
    @Autowired // reference to an object created at the initialization stage
    private Repository repository;


    @GetMapping("/") // an instruction for GET HTTP method for the main content
    public List<Model> getAllModels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable(value = "id") Integer ID) {
        Model model = repository.findById(ID).orElseThrow();
        return ResponseEntity.ok().body(model);
    }

    @PostMapping("/")
    public ResponseEntity<String> createModel(@Valid @RequestBody Model model) {
        if (model.getSpecies() == "") {
            return ResponseEntity.badRequest().body("Species cannot be empty!");
        }
        if (model.getColour() == "") {
            return ResponseEntity.badRequest().body("Colour cannot be empty!");
        }
        if (model.getWeight() <= 0) {
            return ResponseEntity.badRequest().body("Weight must be greater than 0");
        }

        repository.save(model);
        return ResponseEntity.ok().body(model.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable(value = "id") Integer Id) {
        Model model = repository.findById(Id).orElseThrow();
        repository.delete(model);
        return ResponseEntity.ok().body("Deleted record " + Id);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAll() {
        repository.deleteAll();
        return ResponseEntity.ok().body("Deleted all records");
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
