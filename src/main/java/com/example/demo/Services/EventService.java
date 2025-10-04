package com.example.demo.Services;


import com.example.demo.Models.EventDTO;
import com.example.demo.Models.Events;
import com.example.demo.Repositories.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<EventDTO> getEventData(){
        List<Events> listOfEvents =  eventRepository.findAll();
        return listOfEvents.stream().map(x -> objectMapper.convertValue(x, EventDTO.class)).toList();
    }

    public void addEvent(Events event){
         eventRepository.save(event);
    }

    public boolean deleteEventById(int id){
        if(eventRepository.findById(id).isPresent()){
            eventRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }
}

