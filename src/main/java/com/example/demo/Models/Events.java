package com.example.demo.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    @FutureOrPresent(message = "Date must be in the future or present")
    private LocalDate eventDate;

    @NotNull(message = "Price is required!")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private double price;

    @NotNull(message = "Availability is required!")
    private boolean available;

}
