package com.example.demo.Services;


import com.example.demo.Models.Events;
import com.example.demo.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Events> getEventData(){
        return null;
    }

    public void addEvent(Events event){
         eventRepository.save(event);
    }
}
