package com.example.cropadvisor.ticket.service;

import com.example.cropadvisor.ticket.entity.ticket;
import com.example.cropadvisor.ticket.repository.ticketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ticketService {

    private final ticketRepository repo;

    public ticketService(ticketRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public ticket save(ticket t) {
        return repo.save(t);
    }

    // READ ALL
    public List<ticket> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public ticket getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public ticket update(Long id, ticket t) {

        ticket existing = repo.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setCropName(t.getCropName());
        existing.setSymptoms(t.getSymptoms());
        existing.setStatus(t.getStatus());
        existing.setRecommendation(t.getRecommendation());
        existing.setFarmerId(t.getFarmerId());
        existing.setOfficerId(t.getOfficerId());

        return repo.save(existing);
    }
}