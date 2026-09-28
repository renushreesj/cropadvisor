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

    public ticket save(ticket t) {
        return repo.save(t);
    }

    public List<ticket> getAll() {
        return repo.findAll();
    }

    public ticket getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}