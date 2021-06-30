package com.quest.buddy.controller;


import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.services.*;

import com.quest.buddy.models.Event;
import com.quest.buddy.models.Localisation;
import com.quest.buddy.models.Gender;
import com.quest.buddy.models.Sport;
import com.quest.buddy.services.EventServiceImpl;
import com.quest.buddy.services.LocalisationServiceImpl;
import com.quest.buddy.services.GenderServiceImpl;
import com.quest.buddy.services.SportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private SportServiceImpl sportService;

    @Autowired
    private LocalisationServiceImpl localisationService;

    @Autowired
    private GenderServiceImpl sexeService;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/event")
    public String displayEvent(HttpServletRequest req,Model model) {

        UserDto user = userService.findById(2l);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);


        Iterable<Event> listEvent= eventService.getAll();
        model.addAttribute("listEvent",listEvent);
        return "/views/event";
    }

    @GetMapping("/eventadd")
    public String event(Model model) {
        Iterable<Sport> listSport= sportService.getAll();
        Iterable<Localisation> listLocalisation= localisationService.getAll();
        List<Gender> listGender = sexeService.getAll();
        model.addAttribute("listSport",listSport);
        model.addAttribute("listLocalisation",listLocalisation);
        model.addAttribute("listGender",listGender);
        return "/auth/eventadd";
    }
    @PostMapping("/eventadd")
        public String createEvent(@ModelAttribute Event event, Model model) {
        return "/auth/eventadd";
    }

    @PostMapping("/event")
    public String resercheEvent(String filtre) {
        return "redirect:/event";
    }
}
