package com.quest.buddy.controller;
import com.quest.buddy.dtos.EventDto;
import com.quest.buddy.models.*;
import com.quest.buddy.services.*;
import com.quest.buddy.models.Event;
import com.quest.buddy.models.Localisation;
import com.quest.buddy.models.Gender;
import com.quest.buddy.services.EventServiceImpl;
import com.quest.buddy.services.LocalisationServiceImpl;
import com.quest.buddy.services.GenderServiceImpl;
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
    private MySportServiceImpl mySportService;

    @Autowired
    private LocalisationServiceImpl localisationService;

    @Autowired
    private GenderServiceImpl sexeService;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/")
    public String displayEvent(HttpServletRequest req,Model model) {

        User user = userService.findById(2l);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);


        Iterable<Event> listEvent= eventService.getAll();
        model.addAttribute("listEvent",listEvent);
        return "/views/event";
    }
    @PostMapping("/")
    public String resercheEvent(String filtre) {
        return "redirect:/";
    }



    @GetMapping("/eventadd")
    public String event(HttpServletRequest req,Model model) {
        User user = userService.findById(2l);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        Iterable<MySport> listMySport= mySportService.findMySportByUserId(user.getId());
        Iterable<Localisation> listLocalisation= localisationService.getAll();
        List<Gender> listGender = sexeService.getAll();
        model.addAttribute("listMySport",listMySport);
        model.addAttribute("listLocalisation",listLocalisation);
        model.addAttribute("listGender",listGender);
        return "/auth/eventadd";
    }
    @PostMapping("/eventadd")
        public String createEvent(HttpServletRequest req,@ModelAttribute EventDto eventDto) {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        eventDto.setUserId(user.getId());
        eventDto.setSportId(1l);

        Event event = eventDto.modelMapperCreate(eventDto);

        try{
            eventService.create(event);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/eventadd";

    }


}
