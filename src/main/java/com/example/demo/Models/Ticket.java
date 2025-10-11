package com.example.demo.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id; //composite key
    private String ticketId; //obj mapper
    private int customerId; //composite key
    private int eventId; //obj mapper
    private int ticketsBooked; //obj mapper

}
