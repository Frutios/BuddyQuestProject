package com.quest.buddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SportController {

    @GetMapping({"/sports",})
    public String displayHomePage(Model model) {
        return "views/sports";
    }

}
