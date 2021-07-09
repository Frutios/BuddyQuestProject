package com.quest.buddy.controller;

import com.quest.buddy.models.Event;
import com.quest.buddy.models.User;
import com.quest.buddy.services.EventServiceImpl;
import com.quest.buddy.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping({ "/backoffice/"})
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
    @Autowired
    private EventServiceImpl eventService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String displayHomePage(HttpServletRequest req, Model model) {
        User user = userService.findByUserId(2l);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);


        Iterable<Event> listEvent= eventService.getAll();
        model.addAttribute("listEvent",listEvent);
        return "/views/event";
    }

    @GetMapping("login")
    public String login() {
        return "views/login";

    }

}
