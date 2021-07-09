package com.quest.buddy.controller;

import com.quest.buddy.models.Event;
import com.quest.buddy.models.User;
import com.quest.buddy.models.UserEvent;
import com.quest.buddy.services.EventServiceImpl;
import com.quest.buddy.services.UserEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/backoffice/userevent"})
public class UserEventController {

    @Autowired
    private UserEventServiceImpl userEventService;

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping
    public String displayUserEvent(HttpServletRequest req, @RequestParam("id") Long id, Model model) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Boolean isExist =  userEventService.existEventUserId(id,user.getId());
        Event event= eventService.findById(id);
        Iterable<UserEvent> listUserEvent= userEventService.getEventAll(id);
        model.addAttribute("listUserEvent",listUserEvent);
        model.addAttribute("event",event);
        model.addAttribute("isExist",isExist);
        return "/auth/eventUser";
    }
    @PostMapping
    public String displayUserEvent(HttpServletRequest req,@ModelAttribute("event") Event event,Model model) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        user.setId(user.getId());


        Boolean isExist =  userEventService.existEventUserId(event.getId(),user.getId());


        try {
            if(isExist){
                UserEvent userEvent = userEventService.findEventUser(event.getId(),user.getId());
                userEventService.remove(userEvent.getId());
            }else{
                UserEvent userEvent= new UserEvent(user,event);
                userEventService.create(userEvent);
            }

        }catch (Exception e){

        }
        return "redirect:/userevent?id=" +event.getId();
    }
}
