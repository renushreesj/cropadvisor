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

    // CREATE
    public farmer save(farmer f) {
        return repo.save(f);
    }

    // READ ALL
    public List<farmer> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public farmer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public farmer update(Long id, farmer f) {

        farmer existing = repo.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(f.getName());
        existing.setPhone(f.getPhone());
        existing.setLocation(f.getLocation());
        existing.setRegionId(f.getRegionId());

        return repo.save(existing);
    }

    // DELETE
    public boolean delete(Long id) {

        if (!repo.existsById(id)) {
            return false;
        }

        repo.deleteById(id);

        return true;
    }
}