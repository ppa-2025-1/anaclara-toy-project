package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.CriarChamadoTicketCase;
import com.example.demo.domain.dto.NewTicket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.entity.Ticket;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/tickets")
public class TicketController extends AbstractController{

    private final TicketRepository ticketRepository;
    private final CriarChamadoTicketCase ticketBusiness;

    public TicketController(TicketRepository ticketRepository, CriarChamadoTicketCase ticketBusiness){
        this.ticketRepository=ticketRepository;
        this.ticketBusiness=ticketBusiness;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewTicket(
        @Valid
        @RequestBody NewTicket newTicket) {
        
        ticketBusiness.criarChamado(newTicket);        
        
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(ticketRepository.findAll());
    }
    
    
}
