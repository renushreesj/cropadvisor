package com.example.cropadvisor.officer.service;

import com.example.cropadvisor.officer.entity.officer;
import com.example.cropadvisor.officer.repository.officerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class officerService {

    private final officerRepository repo;

    public officerService(officerRepository repo) {
        this.repo = repo;
    }

    public officer save(officer o) {
        return repo.save(o);
    }

    public List<officer> getAll() {
        return repo.findAll();
    }

    public officer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}