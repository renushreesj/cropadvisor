package com.example.cropadvisor.farmer.controller;

import com.example.cropadvisor.farmer.entity.farmer;
import com.example.cropadvisor.farmer.service.farmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
@CrossOrigin
public class farmerController {

    private final farmerService service;

    public farmerController(farmerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<farmer> save(@RequestBody farmer f) {

        farmer savedFarmer = service.save(f);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedFarmer);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<farmer>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<farmer> getById(
            @PathVariable Long id) {

        farmer f = service.getById(id);

        if (f == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(f);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<farmer> update(
            @PathVariable Long id,
            @RequestBody farmer f) {

        farmer updatedFarmer =
                service.update(id, f);

        if (updatedFarmer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedFarmer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        boolean deleted =
                service.delete(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}