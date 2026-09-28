package com.example.cropadvisor.officer.controller;

import com.example.cropadvisor.officer.entity.officer;
import com.example.cropadvisor.officer.service.officerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/officers")
public class officerController {

    private final officerService service;

    public officerController(officerService service) {
        this.service = service;
    }

    @PostMapping
    public officer save(@RequestBody officer o) {
        return service.save(o);
    }

    @GetMapping
    public List<officer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public officer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}