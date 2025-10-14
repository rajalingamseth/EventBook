package com.example.demo.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id; //composite key
    private String ticketId; //obj mapper
    private int userId;
    private int eventId; //obj mapper
    private int ticketsBooked; //obj mapper

    public Ticket(String ticketId, int userId, int eventId, int ticketsBooked){
        this.ticketId = ticketId;
        this.userId = userId;
        this.eventId = eventId;
        this.ticketsBooked = ticketsBooked;
    }

}
