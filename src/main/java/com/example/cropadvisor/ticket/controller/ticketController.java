package com.example.cropadvisor.ticket.controller;

import com.example.cropadvisor.ticket.entity.ticket;
import com.example.cropadvisor.ticket.service.ticketService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class ticketController {

    private final ticketService service;

    public ticketController(ticketService service) {
        this.service = service;
    }

    @PostMapping
    public ticket save(@RequestBody ticket t) {
        return service.save(t);
    }

    @GetMapping
    public List<ticket> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ticket getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}