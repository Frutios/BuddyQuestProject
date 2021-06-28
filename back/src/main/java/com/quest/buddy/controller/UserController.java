package com.quest.buddy.controller;

import com.quest.buddy.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quest.buddy.services.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping({ "/users"})
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user,  Model model) {
        model.addAttribute("user", user);
        userService.create(user);
        
        return "views/userlist";
    }

    @GetMapping("/register")
    public String displayUserForm(Model model){
        model.addAttribute("user", new User());

        return "views/useradd";
    }

    
    @GetMapping("")
    public String displayUserList(Model model){
        model.addAttribute("users", userService.getAll());
        
        return "views/userlist";
    }

    @GetMapping("/update")
    public String displayUpdateUser(@RequestParam(name = "id") Long id, Model model){

        model.addAttribute("user", userService.findById(id));

        return "views/userupdate";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam(name = "id") Long id, @ModelAttribute("user") User user, Model model ) {
        
        User userDatabase = userService.findById(user.getId());

        userDatabase.setFirstName(user.getFirstName());
        userDatabase.setLastName(user.getLastName());
        userDatabase.setPhone(user.getPhone());

        userService.update(userDatabase);

        return "redirect:userlist";
    }
    
}
