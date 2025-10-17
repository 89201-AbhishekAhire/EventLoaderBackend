package com.ksap.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.UUID;

@Service
public class SessionService {

    private volatile String sessionId;

    @PostConstruct
    public void init() {
        regenerateSession();
    }

    public synchronized String getSessionId() {
        return sessionId;
    }

    public synchronized String regenerateSession() {
        this.sessionId = UUID.randomUUID().toString();
        return this.sessionId;
    }

    public synchronized boolean validate(String incomingSessionId) {
        if (incomingSessionId == null) return false;
        return incomingSessionId.equals(this.sessionId);
    }
}