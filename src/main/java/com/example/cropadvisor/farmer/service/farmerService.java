package com.example.cropadvisor.farmer.service;

import com.example.cropadvisor.farmer.entity.farmer;
import com.example.cropadvisor.farmer.repository.farmerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class farmerService {

    private final farmerRepository repo;

    public farmerService(farmerRepository repo) {
        this.repo = repo;
    }

    public farmer save(farmer f) {
        return repo.save(f);
    }

    public List<farmer> getAll() {
        return repo.findAll();
    }

    public farmer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}