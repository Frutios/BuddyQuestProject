package com.quest.buddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/backoffice/"})
public class HomeController {

    @GetMapping
    public String displayHomePage() {
        return "views/home";

    }

    @GetMapping("login")
    public String login() {
        return "views/login";

    }

}
