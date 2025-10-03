package com.example.demo.Controllers;

import com.example.demo.Models.Events;
import com.example.demo.Services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EventBook")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("Events")
    public List<Events> getEventData(){
        return null;
    }

    @PostMapping("addEvent")
    public String  addEvent(@Valid @RequestBody Events event){
        eventService.addEvent(event);
        return "Success";
    }
}
