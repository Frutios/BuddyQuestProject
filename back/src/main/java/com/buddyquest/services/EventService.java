package com.buddyquest.services;

import com.buddyquest.models.Event;

import java.util.List;

public interface EventService {
    void createEvent(Event event);
    void removeEvent(Long id);
    void updateEvent(Event event);
    List<Event> getAll();
    Event findEvent(Long id);
}
