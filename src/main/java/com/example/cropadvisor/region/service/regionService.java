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

    public region save(region r) {
        return repo.save(r);
    }

    public List<region> getAll() {
        return repo.findAll();
    }

    public region getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}