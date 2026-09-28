package com.example.cropadvisor.region.service;

import com.example.cropadvisor.region.entity.region;
import com.example.cropadvisor.region.repository.regionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class regionService {

    private final regionRepository repo;

    public regionService(regionRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public region save(region r) {
        return repo.save(r);
    }

    // READ ALL
    public List<region> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public region getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public region update(Long id, region r) {

        region existing = repo.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setRegionName(r.getRegionName());

        return repo.save(existing);
    }
}