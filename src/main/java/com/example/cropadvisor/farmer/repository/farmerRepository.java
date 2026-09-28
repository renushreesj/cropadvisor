package com.example.cropadvisor.farmer.repository;

import com.example.cropadvisor.farmer.entity.farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface farmerRepository extends JpaRepository<farmer, Long> {
}