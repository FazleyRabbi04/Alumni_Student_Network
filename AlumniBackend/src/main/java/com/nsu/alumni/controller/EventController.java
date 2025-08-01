package com.nsu.alumni.controller;

import com.nsu.alumni.model.Event;
import com.nsu.alumni.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {

    private final EventRepository eventRepo;

    public EventController(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepo.save(event);
    }
}
