package com.quest.buddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class messageController {


    @GetMapping("/message")
    public String displayMessage(Model model) {
        return "/auth/message";
    }

    @PostMapping("/message")
    public String resercheMessage(HttpServletRequest req, String filter) {
        return "redirect:/message";
    }

}
