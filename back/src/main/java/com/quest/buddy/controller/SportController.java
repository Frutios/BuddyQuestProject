package com.quest.buddy.controller;

import com.quest.buddy.services.SportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SportController {
    
    @Autowired
    private SportServiceImpl sportService;

    @GetMapping({"/sports"})
    public String displaySports(Model model) {
        model.addAttribute("sports", sportService.getAll());
        return "views/sports";
    }

    @GetMapping({"/sportDetails"})
    public String displaySport(@RequestParam("id") Long id, Model model) {
        model.addAttribute("sport", sportService.findById(id));
        return "views/sportDetails";
    }

}
