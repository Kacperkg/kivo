package com.kivo.backend.service;

import org.springframework.stereotype.Service;
import com.kivo.backend.repository.TicketRepository;

import java.util.List;

import com.kivo.backend.exception.TicketNotFoundException;
import com.kivo.backend.model.Priority;
import com.kivo.backend.model.Ticket;
import com.kivo.backend.model.TicketStatus;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    public Ticket getTicket(Long id) {
        return this.ticketRepository
                .findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }

    public Ticket createTicket(String title, String description, Priority priority) {
        Ticket ticket = new Ticket(title, description, priority);
        return this.ticketRepository.save(ticket);
    }

    public Ticket updateStatus(Long id, TicketStatus newStatus) {
        Ticket ticket = this.getTicket(id);

        ticket.changeStatus(newStatus);

        return this.ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        this.ticketRepository.delete(this.getTicket(id));
    }

    public Ticket updateTicket(
        Long id,
        String newTitle,
        String newDescription,
        Priority newPriority
    ) {
        Ticket ticket = this.getTicket(id);

        ticket.updateDetails(newTitle, newDescription, newPriority);

        return this.ticketRepository.save(ticket);
    }
}
