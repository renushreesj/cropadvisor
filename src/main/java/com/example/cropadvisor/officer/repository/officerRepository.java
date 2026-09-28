package com.example.cropadvisor.officer.repository;

import com.example.cropadvisor.officer.entity.officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface officerRepository extends JpaRepository<officer, Long> {
}