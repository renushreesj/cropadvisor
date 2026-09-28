package com.example.cropadvisor.ticket.controller;

import com.example.cropadvisor.ticket.entity.ticket;
import com.example.cropadvisor.ticket.service.ticketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class ticketController {

    private final ticketService service;

    public ticketController(ticketService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ticket> save(
            @RequestBody ticket t) {

        ticket savedTicket = service.save(t);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedTicket);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ticket>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ticket> getById(
            @PathVariable Long id) {

        ticket t = service.getById(id);

        if (t == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(t);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ticket> update(
            @PathVariable Long id,
            @RequestBody ticket t) {

        ticket updatedTicket =
                service.update(id, t);

        if (updatedTicket == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTicket);
    }
}