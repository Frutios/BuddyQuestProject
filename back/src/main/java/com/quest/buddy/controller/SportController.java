package com.quest.buddy.controller;

import com.quest.buddy.dtos.SportDto;
import com.quest.buddy.dtos.SportFilters;
import com.quest.buddy.models.Sport;
import com.quest.buddy.services.SportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SportController {
    
    @Autowired
    private SportServiceImpl sportService;

    @GetMapping({"/sports"})
    public String displaySports(@ModelAttribute("filters") SportFilters sportFilters,Model model,String filter) {
    
       Iterable<SportDto> sports;
       
       if(sportFilters!= null  && sportFilters.getName() != null && !sportFilters.getName().equals("")){
        sports = sportService.getSportsByKeyWord(sportFilters.getName());
       }else
       {
        sports = sportService.getAllDto();
       }
       model.addAttribute("sports",sports);
       
       if(sportFilters == null){
        sportFilters = new SportFilters();
       }
       model.addAttribute("filters",sportFilters);

        return "views/sports";
    }
    
    @GetMapping({"/sports/details"})
    public String displaySport(@RequestParam("id") Long id, Model model) {

        Sport sport = sportService.findById(id);

        model.addAttribute("sport", sport.toDto());
        model.addAttribute("events", sportService.getEventsForSport(id));
        // model.addAttribute("users", sportService.getUsersForSport(id));
        return "views/sportDetails";
    }

    @PostMapping({"/sports/details"})
    public String updateSport(@RequestParam("id") Long id,@ModelAttribute("sport") SportDto sportModel,Model model) {

        Sport sport = sportService.findById(sportModel.getId());
        sport.setActive(sportModel.getActive());

        sportService.update(sport);

        model.addAttribute("sport", sport.toDto());
        model.addAttribute("events", sportService.getEventsForSport(id));
        model.addAttribute("users", sportService.getUsersForSport(id));
        return "views/sportDetails";
    }

}
