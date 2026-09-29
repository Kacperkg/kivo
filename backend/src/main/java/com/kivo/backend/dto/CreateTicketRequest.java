package com.kivo.backend.dto;

import com.kivo.backend.model.Priority;
public record CreateTicketRequest(
    String title,
    String description,
    Priority priority
) {
    
}
