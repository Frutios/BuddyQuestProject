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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({ "/backoffice/events"})
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


    @GetMapping
    public String displayEvent(HttpServletRequest req,Model model,String title) {

        User user = userService.findByUserId(2l);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        Iterable<Event> listEvent =new ArrayList<>();

       //
        if(title ==null){
          listEvent= eventService.getAll();
        }else{
           listEvent= eventService.findByTitleContaining(title);
        }


        model.addAttribute("listEvent",listEvent);
        return "/views/event";
    }

    @GetMapping("/filtreEvent")
    public String resercheEvent(String title,Model model) {
        Iterable<Event> listEvent= eventService.findByTitleContaining(title);
        model.addAttribute("listEvent",listEvent);
        return "/views/event";
    }
    
    @GetMapping("/add")
    public String event(HttpServletRequest req,Model model) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Iterable<MySport> listMySport= mySportService.findMySportByUserId(user.getId());
        Iterable<Localisation> listLocalisation= localisationService.getAll();
        List<Gender> listGender = sexeService.getAll();
        model.addAttribute("listMySport",listMySport);
        model.addAttribute("listLocalisation",listLocalisation);
        model.addAttribute("listGender",listGender);
        return "/auth/eventadd";
    }

        @PostMapping("/add")
        public String createEvent(HttpServletRequest req,@ModelAttribute EventDto eventDto) {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        eventDto.setUserId(user.getId());
        Event event = eventDto.modelMapperCreate(eventDto);

        try{
            eventService.create(event);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/backoffice/events/myevent";

    }
    @GetMapping("/myevent")
    public String displayMyEvent(HttpServletRequest req,Model model) {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Iterable<Event> mylistEvent= eventService.findEventByUser(user);
        model.addAttribute("mylistEvent",mylistEvent);
        return "/auth/myevent";
    }

    @GetMapping("/eventDelete")
    public String myEventDelete(HttpServletRequest req,Model model) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        try{
           //Trouver id
            Long eventId = Long.parseLong(req.getParameter("id"));
            //Delete event
            eventService.remove(eventId);
            //list event

        }catch (Exception e){}

        Iterable<Event> mylistEvent= eventService.findEventByUser(user);
        model.addAttribute("mylistEvent",mylistEvent);

        return "/auth/myevent";
    }

    @GetMapping("/eventModify")
    public String myEventModify(HttpServletRequest req,Model model) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        try{
            //Trouver id
            Long eventId = Long.parseLong(req.getParameter("id"));
            Event event = eventService.findById(eventId);
            //list outres
            Iterable<MySport> listMySport= mySportService.findMySportByUserId(user.getId());
            Iterable<Localisation> listLocalisation= localisationService.getAll();
            List<Gender> listGender = sexeService.getAll();
            model.addAttribute("listMySport",listMySport);
            model.addAttribute("listLocalisation",listLocalisation);
            model.addAttribute("listGender",listGender);
            model.addAttribute("event",event);
        }catch (Exception e){}
        return "/auth/eventUpdate";
    }

    @PostMapping("/eventModify")
    public String myEventModify(HttpServletRequest req,@ModelAttribute EventDto eventDto) {
        Long eventId = Long.parseLong(req.getParameter("id"));
        Event eventOrig = eventService.findById(eventId);
        Event eventFinal = eventDto.modelMapperUpdate(eventDto,eventOrig);
        try{
            eventService.update(eventFinal);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/backoffice/events/myevent";

    }

    @GetMapping("/eventFinalize")
    public String myEventFinalize(HttpServletRequest req,Model model) {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        try{
            //Trouver id
            Long eventId = Long.parseLong(req.getParameter("id"));
            Event event = eventService.findById(eventId);
            //Modify state= 2 finalize
            event.setState((byte)2);
            //update event
            eventService.update(event);
            //list event

        }catch (Exception e){}

        Iterable<Event> mylistEvent= eventService.findEventByUser(user);
        model.addAttribute("mylistEvent",mylistEvent);

        return "/auth/myevent";
    }
    @GetMapping("/eventActive")
    public String myEventActive(HttpServletRequest req,Model model) {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        try{
            //Trouver id
            Long eventId = Long.parseLong(req.getParameter("id"));
            Event event = eventService.findById(eventId);
            //Modify state= 2 finalize
            event.setState((byte)1);
            //update event
            eventService.update(event);
            //list event

        }catch (Exception e){}

        Iterable<Event> mylistEvent= eventService.findEventByUser(user);
        model.addAttribute("mylistEvent",mylistEvent);

        return "/auth/myevent";
    }

}
