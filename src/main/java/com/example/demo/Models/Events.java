package com.example.demo.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;
    @NotEmpty(message = "Name is required!")
    private String eventName;
    @NotNull(message = "Event date is required!")
    @Temporal(TemporalType.DATE)
    private Date eventDate;
    @NotNull(message = "Price is required!")
    private double price;
    @NotNull(message = "Availability is required!")
    private boolean available;

}
