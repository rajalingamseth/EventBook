package com.example.demo.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TicketDTO {

    private String ticketId;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer eventId;
    @Min(1)
    private int ticketsBooked;

}
