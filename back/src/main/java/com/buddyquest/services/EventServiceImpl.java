package com.buddyquest.services;

import com.buddyquest.models.Event;
import com.buddyquest.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements BaseService<Event, Long> {
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

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
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
}
