package com.example.demo.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TicketDTO {

    private int userId;
    private int eventId; //obj mapper
    private int ticketsBooked;

}
