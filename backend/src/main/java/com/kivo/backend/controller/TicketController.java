package com.kivo.backend.controller;

import com.kivo.backend.service.TicketService;

import java.util.List;
import com.kivo.backend.model.Ticket;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kivo.backend.dto.CreateTicketRequest;


@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return this.ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return this.ticketService.getTicket(id);
    }
 
    @PostMapping
    public ResponseEntity<Ticket> createTicket(
        @RequestBody CreateTicketRequest request
    ) {
        Ticket ticket = this.ticketService.createTicket(
                request.title(),
                request.description(),
                request.priority()
        );

        URI location = URI.create("/api/tickets/" + ticket.getId());

        return ResponseEntity.created(location).body(ticket);
    }
}