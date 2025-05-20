package com.example.demo.domain.dto;
import com.example.demo.repository.entity.Ticket;
import com.example.demo.repository.entity.User;

public record NewTicket (
    String action,
    String object,
    String details,
    String status,
    User user
){}
