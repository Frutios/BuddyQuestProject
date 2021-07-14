package com.quest.buddy.rest;

import com.quest.buddy.dtos.EventDto;
import com.quest.buddy.models.Event;
import com.quest.buddy.models.User;
import com.quest.buddy.services.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class EventRestController {
    @Autowired
    EventServiceImpl eventService;

    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Event>> getAll() {
        Iterable<Event> event = eventService.getAll();
        if(hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Iterable<Event>>(event,HttpStatus.OK);
    }
    @PostMapping("/events")
    public Boolean createEvent(HttpServletRequest req, @RequestBody EventDto eventDto){
     //   HttpSession session = req.getSession();
        //User user = (User)session.getAttribute("user");
        eventDto.setUserId(2l);
        Event event = eventDto.modelMapperCreate(eventDto);

        try{
            eventService.create(event);
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
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
