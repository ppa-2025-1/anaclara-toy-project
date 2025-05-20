package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.domain.out.ITicketRepository;
import com.example.demo.repository.entity.Ticket;
import com.example.demo.repository.entity.User;

public interface TicketRepository extends ITicketRepository, BaseRepository<Ticket, Integer>{
    Optional<Ticket> findByUser(User user);

}
