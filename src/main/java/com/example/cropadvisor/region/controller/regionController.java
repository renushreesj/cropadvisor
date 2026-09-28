package com.example.cropadvisor.region.controller;

import com.example.cropadvisor.region.entity.region;
import com.example.cropadvisor.region.service.regionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
@CrossOrigin
public class regionController {

    private final regionService service;

    public regionController(regionService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<region> save(
            @RequestBody region r) {

        region savedRegion = service.save(r);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedRegion);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<region>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<region> getById(
            @PathVariable Long id) {

        region r = service.getById(id);

        if (r == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(r);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<region> update(
            @PathVariable Long id,
            @RequestBody region r) {

        region updatedRegion =
                service.update(id, r);

        if (updatedRegion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedRegion);
    }
}