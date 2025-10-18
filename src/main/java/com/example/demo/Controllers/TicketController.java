package com.example.demo.Controllers;


import com.example.demo.ErrorHandling.CustomException;
import com.example.demo.Models.Events;
import com.example.demo.Models.TicketDTO;
import com.example.demo.Services.EventService;
import com.example.demo.Services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EventBook")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("buyTickets")
    public ResponseEntity<String> buyTickets( @Valid @RequestBody TicketDTO ticketDTO) {
        if(ticketService.checkAvailability(ticketDTO.getEventId(), ticketDTO.getTicketsBooked())){
           String bookingId  = ticketService.purchaseTickets(ticketDTO);
           return new ResponseEntity<>("Booking Successful! - " + bookingId, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Sorry! " +  ticketService.availableTickets(ticketDTO) + " tickets available for this event", HttpStatus.BAD_REQUEST);
        }
    }

}
