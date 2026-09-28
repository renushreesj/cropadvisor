package com.example.cropadvisor.ticket.repository;

import com.example.cropadvisor.ticket.entity.ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ticketRepository extends JpaRepository<ticket, Long> {
}