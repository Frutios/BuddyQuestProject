package com.quest.buddy.rest;

import com.quest.buddy.models.Event;
import com.quest.buddy.models.Sport;
import com.quest.buddy.services.EventServiceImpl;
import com.quest.buddy.services.SportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EventRestController {
    @Autowired
    EventServiceImpl eventService;

    @GetMapping(value = "/api/event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Event>> getAll() {
        Iterable<Event> event = eventService.getAll();
        if(hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Iterable<Event>>(event,HttpStatus.OK);

    }

    public boolean hasErrors(){
        HashMap<String,String> errors = eventService.getErrors();

        boolean errorsFound = false;
        if(!errors.isEmpty())
        {
            errors.clear();
            errorsFound = true;
        }
        return errorsFound;
    }
}
