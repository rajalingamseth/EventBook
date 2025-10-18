package com.example.demo.Services;

import com.example.demo.ErrorHandling.CustomException;
import com.example.demo.Models.Events;
import com.example.demo.Models.Ticket;
import com.example.demo.Models.TicketDTO;
import com.example.demo.Repositories.TicketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String purchaseTickets(TicketDTO ticketDTO) {
        Events event =  eventService.getEventbyId(ticketDTO.getEventId());

        int remaining_tickets = event.getTickets_available()-ticketDTO.getTicketsBooked();
        event.setTickets_available(remaining_tickets);
        eventService.updateEvent(event);
        String ticketId = generateUniqueTicketCodes(ticketDTO.getEventId());

        ticketDTO.setTicketId(ticketId);
        Ticket ticket = objectMapper.convertValue(ticketDTO, Ticket.class);

        ticketRepository.save(ticket);

        return ticketId;
    }

    public boolean checkAvailability(int eventId, int numberofTickets) {
        Events event = eventService.getEventbyId(eventId);
        return event.getTickets_available() >= numberofTickets;
    }

    private String generateUniqueTicketCodes(int eventId) {
        return "EVT" + eventId + "-" +
                java.time.LocalDate.now().toString().replaceAll("-", "") + "-" +
                UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String availableTickets(TicketDTO ticketDTO){
        return String.valueOf(eventService.getEventbyId(ticketDTO.getEventId()).getTickets_available());
    }

}
