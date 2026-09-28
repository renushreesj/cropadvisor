package com.example.cropadvisor.region.controller;

import com.example.cropadvisor.region.entity.region;
import com.example.cropadvisor.region.service.regionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/regions")
public class regionController {

    private final regionService service;

    public regionController(regionService service) {
        this.service = service;
    }

    @PostMapping
    public region save(@RequestBody region r) {
        return service.save(r);
    }

    @GetMapping
    public List<region> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public region getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}