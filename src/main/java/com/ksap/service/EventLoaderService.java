package com.ksap.service;

import com.ksap.entity.EventLoader;
import com.ksap.repository.EventLoaderRepository;
import com.ksap.repository.StatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EventLoaderService {

    @Autowired
    private EventLoaderRepository eventLoaderRepository;

    @Autowired
    private StatusCodeRepository statusCodeRepository;

    public EventLoader saveEvent(EventLoader event) {
    	if (!statusCodeRepository.existsByCode(event.getStatusCode())) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Invalid STATUS_CODE: " + event.getStatusCode()
            );
        }
        return eventLoaderRepository.save(event);
    }

    public List<EventLoader> findAllEvents() {
        return eventLoaderRepository.findAll();
    }

    public Optional<EventLoader> findEventById(String id) {
        return eventLoaderRepository.findById(id);
    }

    public void deleteEvent(String id) {
        eventLoaderRepository.deleteById(id);
    }
}