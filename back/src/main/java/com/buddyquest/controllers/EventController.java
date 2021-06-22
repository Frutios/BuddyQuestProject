package com.buddyquest.controllers;

import com.buddyquest.models.Event;
import com.buddyquest.models.User;
import com.buddyquest.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/listevent")
    public List<Event> allEvent(Model model) {
        List<Event> listEvent = eventService.getAll();
        model.addAttribute("listUser",listEvent);
        return listEvent;
    }
}
