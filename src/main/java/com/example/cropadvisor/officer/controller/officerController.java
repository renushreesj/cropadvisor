package com.example.cropadvisor.officer.controller;

import com.example.cropadvisor.officer.entity.officer;
import com.example.cropadvisor.officer.service.officerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/officers")
@CrossOrigin
public class officerController {

    private final officerService service;

    public officerController(officerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<officer> save(
            @RequestBody officer o) {

        officer savedOfficer = service.save(o);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedOfficer);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<officer>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<officer> getById(
            @PathVariable Long id) {

        officer o = service.getById(id);

        if (o == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(o);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<officer> update(
            @PathVariable Long id,
            @RequestBody officer o) {

        officer updatedOfficer =
                service.update(id, o);

        if (updatedOfficer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedOfficer);
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