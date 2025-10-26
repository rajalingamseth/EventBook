package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty(message = "Username is required!")
    private String userName;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Email is invalid!")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8, max = 16)
    private String password;

    @NotNull(message = "Event date is required!")
    @PastOrPresent(message = "Cannot be future date!")
    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(
            name = "user_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_registered")
    )
    private Set<Events> events = new HashSet<>();

}
