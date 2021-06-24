package com.quest.buddy.controller;

import com.quest.buddy.models.Event;
import com.quest.buddy.rest.EventRestController;
import com.quest.buddy.services.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/event")
    public String displayEvent(Model model) {

       Iterable<Event> listEvent= eventService.getAll();
        model.addAttribute("listEvent",listEvent);
        return "/views/event";
    }
}
