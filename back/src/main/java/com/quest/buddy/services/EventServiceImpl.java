package com.quest.buddy.services;

import com.quest.buddy.models.Event;
import com.quest.buddy.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("EventService")
public class EventServiceImpl implements EventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void create(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void remove(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void update(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
}
