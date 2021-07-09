package com.quest.buddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "/backoffice/message"})
public class MessageController{ 
    
    @GetMapping
    public String displayMessage(Model model) {
        return "/auth/message";
    }

    @PostMapping
    public String resercheMessage(HttpServletRequest req, String filter) {
        return "redirect:/message";
    }

}
