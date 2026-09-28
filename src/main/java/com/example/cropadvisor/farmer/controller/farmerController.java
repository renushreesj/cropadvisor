package com.example.cropadvisor.farmer.controller;

import com.example.cropadvisor.farmer.entity.farmer;
import com.example.cropadvisor.farmer.service.farmerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
public class farmerController {

    private final farmerService service;

    public farmerController(farmerService service) {
        this.service = service;
    }

    @PostMapping
    public farmer save(@RequestBody farmer f) {
        return service.save(f);
    }

    @GetMapping
    public List<farmer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public farmer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);}}
