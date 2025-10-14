package com.example.demo.Services;

import com.example.demo.ErrorHandling.CustomException;
import com.example.demo.Models.Events;
import com.example.demo.Models.Ticket;
import com.example.demo.Models.TicketDTO;
import com.example.demo.Repositories.TicketRepository;
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


    public String purchaseTickets(TicketDTO ticketDTO) throws CustomException {
        Events event =  eventService.getEventbyId(ticketDTO.getEventId());
        if(event != null){
           int remaining_tickets = event.getTickets_available()-ticketDTO.getTicketsBooked();
           event.setTickets_available(remaining_tickets);
           eventService.updateEvent(event);
           String ticketId = generateUniqueTicketCodes(ticketDTO.getEventId());

           Ticket ticket = new Ticket(ticketId, ticketDTO.getUserId(), ticketDTO.getEventId(), ticketDTO.getTicketsBooked());

           ticketRepository.save(ticket);

            return ticketId;
        }
        return null;
    }

    public boolean checkAvailability(int eventId, int numberofTickets) throws CustomException {
        Events event = eventService.getEventbyId(eventId);
        return event.getTickets_available() >= numberofTickets;
    }

    private String generateUniqueTicketCodes(int eventId) {
        return "EVT" + eventId + "-" +
                java.time.LocalDate.now().toString().replaceAll("-", "") + "-" +
                UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
