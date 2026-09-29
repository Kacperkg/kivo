package com.kivo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kivo.backend.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    
}
