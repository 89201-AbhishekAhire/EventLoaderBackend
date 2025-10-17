package com.ksap.controller;

import com.ksap.entity.EventLoader;
import com.ksap.service.EventLoaderService;
import com.ksap.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*") 
public class EventLoaderController {

    @Autowired
    private EventLoaderService eventLoaderService;

    @Autowired
    private SessionService sessionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<EventLoader> createEvents(
            @RequestHeader(value = "X-Session-Id", required = false) String sessionId,
            @RequestBody List<EventLoader> events) {

        // Validate session id
        if (!sessionService.validate(sessionId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid or missing session id");
        }

        Set<String> allowedAliasValues = Set.of(
            "UPSC", "GATE", "MPSC", "JEE", "CET", "CAT"
        );
        List<EventLoader> savedEvents = new java.util.ArrayList<>();
        for (EventLoader event : events) {
            //System.out.println("SHIPMENT_ID from request = " + event.getSHIPMENT_ID());
            try {
                int shipmentId = Integer.parseInt(event.getSHIPMENT_ID());
                if (shipmentId < 1001 || shipmentId > 1050) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "SHIPMENT_ID must be between 1001 and 1050");
                }
            } catch (NumberFormatException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "SHIPMENT_ID must be a valid number");
            }
            if (!allowedAliasValues.contains(event.getSERVPROV_ALIAS_VALUE())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "SERVPROV_ALIAS_VALUE must be one of: " + allowedAliasValues);
            }
            savedEvents.add(eventLoaderService.saveEvent(event));
        }
        return savedEvents;
    }

 
    @GetMapping
    public List<EventLoader> getAllEvents() {
        return eventLoaderService.findAllEvents();
    }

 
    @GetMapping("/{id}")
    public EventLoader getEventById(@PathVariable String id) {
        return eventLoaderService.findEventById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
    }

 
    @PutMapping("/{id}")
    public EventLoader updateEvent(@PathVariable String id, @RequestBody EventLoader updatedEvent) {
        eventLoaderService.findEventById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        updatedEvent.setSHIPMENT_ID(id); // Ensure the ID is set correctly
        return eventLoaderService.saveEvent(updatedEvent);
    }

 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable String id) {
        eventLoaderService.deleteEvent(id);
    }

    
    @GetMapping("/session")
    public Map<String, String> getSessionId() {
        return Map.of("sessionId", sessionService.getSessionId());
    }
}