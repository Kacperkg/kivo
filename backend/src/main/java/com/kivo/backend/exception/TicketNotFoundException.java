package com.kivo.backend.exception;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super("Ticket with id " + id + " was not found");
    }
}
