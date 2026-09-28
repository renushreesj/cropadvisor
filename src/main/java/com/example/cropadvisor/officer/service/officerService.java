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

    // CREATE
    public officer save(officer o) {
        return repo.save(o);
    }

    // READ ALL
    public List<officer> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public officer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public officer update(Long id, officer o) {

        officer existing = repo.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(o.getName());
        existing.setPhone(o.getPhone());
        existing.setSpecialization(o.getSpecialization());
        existing.setRegionId(o.getRegionId());

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