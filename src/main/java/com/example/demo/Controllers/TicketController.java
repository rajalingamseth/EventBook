package com.example.demo.Controllers;


import com.example.demo.ErrorHandling.CustomException;
import com.example.demo.Models.Events;
import com.example.demo.Services.EventService;
import com.example.demo.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/EventBook")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("buyTickets")
    public ResponseEntity<String> buyTickets(@RequestParam int eventId, @RequestParam  int numberofTickets) throws CustomException {
        if(ticketService.checkAvailability(eventId, numberofTickets)){
           String bookingId  = ticketService.purchaseTickets(eventId, numberofTickets);
           return new ResponseEntity<>("Booking Successful! - " + bookingId, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Tickets not available", HttpStatus.BAD_REQUEST);
        }

    }
}
