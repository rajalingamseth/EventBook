package com.example.demo.Controllers;

import com.example.demo.Models.EventDTO;
import com.example.demo.Models.Events;
import com.example.demo.Services.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/EventBook")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("Events")
    public List<EventDTO> getEventData(){
        List<Events> list =  eventService.getEventData();
        return list.stream().map(x -> objectMapper.convertValue(x, EventDTO.class)).toList();
    };

    @PostMapping("addEvent")
    public String addEvent(@Valid @RequestBody Events event){
        eventService.addEvent(event);
        return "Success";
    }


}
