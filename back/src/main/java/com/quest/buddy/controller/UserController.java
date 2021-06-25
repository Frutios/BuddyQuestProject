package com.quest.buddy.controller;

import com.quest.buddy.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quest.buddy.services.UserService;



@Controller
public class UserController {



    @PostMapping("/add-user")
    public void addUser(@ModelAttribute User user,  Model model) {
        model.addAttribute("user", user);
        userService.create(user);
        
    }

    @GetMapping("/register")
    public String displayUserForm(Model model){
        model.addAttribute("user", new User());

        return "views/adduser";
    }

    
    @GetMapping("/users")
    public String displayUserList(Model model){
        model.addAttribute("users", userService.getAll());
        
        return "views/userlist";
    }



    
}
