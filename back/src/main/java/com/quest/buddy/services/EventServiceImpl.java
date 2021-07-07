package com.quest.buddy.services;

import com.quest.buddy.dtos.EventDto;
import com.quest.buddy.models.Event;
import com.quest.buddy.models.User;
import com.quest.buddy.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service("EventService")
public class EventServiceImpl implements EventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ErrorServiceImp errorService;

    @Override
    public void create(Event event) {
        if(existName(event.getTitle())){
            errorService.AddError("Event", "Event already" + event.getTitle() + " exist");
        }
        else
        {
            eventRepository.save(event);
        }
    }

    @Override
    public void remove(Long id) {

        if(existId(id)){
            try {
                eventRepository.deleteById(id);
            } catch (Exception e) {
                errorService.AddError("Event", "Error deleting Event with id " + id );
            }
        }
        else
        {
            errorService.AddError("Event", "No Event with id " + id + " to remove" );
        }

    }

    @Override
    public void update(Event event) {

        try {
            eventRepository.save(event);
        } catch (Exception e) {
            errorService.AddError("Sport", "Error updating " + event.getTitle() );
        }

    }

    @Override
    public Iterable<Event> getAll() {
        Iterable<Event> event = null;
        try {
            event = eventRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("Event", "Error getting Event" );
        }
        return event;
    }
    public Iterable<EventDto> getAllDto() {

        Iterable<Event> event = null;
        try {
            event = eventRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("Event", "Error getting Event" );
        }

        return toListDto(event);
    }
    @Override
    public Event findById(Long id) {
        Event event = null;
        try {
            event = eventRepository.findById(id).orElse(null);
        } catch (Exception e) {
            errorService.AddError("Sport", "Error getting sport with id " + id );
        }
        return event;
    }
    public Iterable<Event> findEventByUser(User user) {

        Iterable<Event> event = null;
        try {
            event = eventRepository.findEventByUser(user);
        } catch (Exception e) {
            errorService.AddError("Event", "Error getting Event" );
        }

        return event;
    }
    public Iterable<Event> findByTitleContaining(String title) {

        Iterable<Event> listEvent = null;
        try {
            listEvent = eventRepository.findByTitleContaining(title);
        } catch (Exception e) {
            errorService.AddError("Event", "Error getting Event" );
        }

        return listEvent;
    }
    public boolean existName(String title){

            boolean existTitle = false;
            try {
                existTitle = !eventRepository.findEventByTitle(title).isEmpty();
            } catch (Exception e) {
                errorService.AddError("Event", "Error while finding event with title " + title );
            }
            return existTitle;

        }
    public boolean existId(Long id){
        Optional<Event> eventExist = null;
        try {
            eventExist= eventRepository.findById(id);
        } catch (Exception e) {
            errorService.AddError("Event", "Error while finding Event with id " + id );
        }
        return eventExist.isPresent();

    }

    public HashMap<String,String> getErrors(){
        return errorService.getErrors();
    }

    public static Iterable<EventDto> toListDto(Iterable<Event> events ){
        List<EventDto> eventDtos=StreamSupport.stream(events.spliterator(), false)
                .map(event ->event.toDto())
                .collect(Collectors.toList());

        return eventDtos;
    }
}
