package com.example.demo.Controllers;

import com.example.demo.ErrorHandling.CustomException;
import com.example.demo.Models.EventDTO;
import com.example.demo.Models.Events;
import com.example.demo.Services.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EventBook")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("Events")
    public ResponseEntity<List<EventDTO>> getEventData(){
        return new ResponseEntity<>(eventService.getEventData(), HttpStatus.OK);
    };

    @PostMapping("addNewEvent")
    public ResponseEntity<String> addNewEvent(@Valid @RequestBody Events event){
        eventService.addEvent(event);
        return new ResponseEntity<>("Successfully added new event", HttpStatus.OK);
    }

    @DeleteMapping("deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable String id) throws CustomException {
        if (id == null || id.isBlank() || !id.matches("\\d+")) {
            throw new CustomException("Invalid parameter passed");
        }
        int eventId = Integer.parseInt(id);
        if(eventService.deleteEventById(eventId)){
            return new ResponseEntity<>("Successfully removed event", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Could not delete the event", HttpStatus.NOT_FOUND);
        }
    }

}
