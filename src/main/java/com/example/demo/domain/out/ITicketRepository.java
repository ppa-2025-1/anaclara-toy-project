package com.example.demo.domain.out;

import java.util.Optional;

import com.example.demo.repository.entity.Ticket;
import com.example.demo.repository.entity.User;

public interface ITicketRepository {
    Optional<Ticket> findByUser(User user);
    Ticket save(Ticket ticket);
}
