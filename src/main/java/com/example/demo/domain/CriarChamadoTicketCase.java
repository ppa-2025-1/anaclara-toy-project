package com.example.demo.domain;

import java.sql.Time;
import java.util.Set;

import com.example.demo.domain.dto.NewTicket;
import com.example.demo.domain.dto.NewUser;
import com.example.demo.domain.out.ITicketRepository;
import com.example.demo.domain.out.IUserRepository;
import com.example.demo.repository.entity.Ticket;

import jakarta.validation.Valid;

@UseCase
public class CriarChamadoTicketCase {
    private IUserRepository userRepository;
    private ITicketRepository ticketRepository;
    private Set<String> defaultRoles;

    public CriarChamadoTicketCase(IUserRepository userRepository, ITicketRepository ticketRepository, Set<String> defaultRoles){
        this.userRepository=userRepository;
        this.ticketRepository=ticketRepository;
        this.defaultRoles=defaultRoles;
    }

    public void criarChamado(NewTicket newTicket){
        if(newTicket.status()!="NOVO" || newTicket.status()!="ANDAMENTO" || newTicket.status()!="RESOLVIDO" || newTicket.status()!="CANCELADO"){
            throw new IllegalArgumentException("Status inválido", null);
        }
        Ticket ticket=new Ticket();
        ticket.setAction(newTicket.action());
        ticket.setObject(newTicket.object());
        ticket.setDetails(newTicket.details());
        ticket.setStatus(newTicket.status());
        ticket.setUser(newTicket.user());
        ticketRepository.save(ticket);
    }
}
