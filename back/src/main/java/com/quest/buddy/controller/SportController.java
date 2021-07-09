package com.quest.buddy.controller;

import java.util.Arrays;

import com.quest.buddy.dtos.SportDto;
import com.quest.buddy.dtos.SportFilters;
import com.quest.buddy.models.Sport;
import com.quest.buddy.services.MySportServiceImpl;
import com.quest.buddy.services.SportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ "/backoffice/sports" })
public class SportController {
    @Autowired
    private SportServiceImpl sportService;

    @Autowired
    private MySportServiceImpl mySportService;

    @GetMapping
    public String main(@ModelAttribute("filters") SportFilters sportFilters, Model model, String filter) {
        Iterable<SportDto> sports;

        if (sportFilters != null && sportFilters.getName() != null && !sportFilters.getName().equals("")) {
            sports = sportService.findByName(sportFilters.getName());
        } else {
            sports = sportService.getAllDto();
        }
        model.addAttribute("sports", sports);

        if (sportFilters == null) {
            sportFilters = new SportFilters();
        }
        model.addAttribute("filters", sportFilters);
        return "views/sports";
    }

    @GetMapping({ "/details" })
    public String details(@RequestParam("id") Long id, Model model) {

        Sport sport = sportService.findById(id);
        model.addAttribute("sport", sport.toDto());
        return "views/sportDetails";
    }

    @PostMapping({ "/details" })
    public String update(@RequestParam("id") Long id, @ModelAttribute("sport") SportDto sportModel, Model model) {
        
        Sport sport = sportService.findById(sportModel.getId());
        sport.setActive(sportModel.getActive());

        sportService.update(sport);

        model.addAttribute("sport", sport.toDto());
        return "views/sportDetails";
    }

    @GetMapping("{details}")
    public String tab(@PathVariable String details, @RequestParam("id") Long sportId, Model model) {
        Sport sport = sportService.findById(sportId);
        switch (details) {
            case "events":
                model.addAttribute("events", sportService.getEventsForSport(sportId));
                return "/fragments/events";
            case "users":
                model.addAttribute("users", mySportService.findUserBySport(sport));
                return "/fragments/users";
        }
        return "error";
    }

    @GetMapping("/testCall")
    public String testCall(@PathVariable String tab) {
        if (Arrays.asList("tab1", "tab2", "tab3").contains(tab)) {
            return "_" + tab;
        }
        return "empty";
    }

}
