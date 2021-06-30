package com.quest.buddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.quest.buddy.dtos.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addUser(@ModelAttribute("user") UserDto userModel,  Model model) {
        
        userService.create(userModel);
        
        return "redirect:/users";
    }

    @GetMapping("/register")
    public String displayUserForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        return "views/useradd";
    }

    
    @GetMapping("")
    public String displayUserList(Model model){
        Iterable<UserDto> users;

        users = userService.getAll();

        model.addAttribute("users", users);
        
        return "views/userlist";
    }

    @GetMapping("/update")
    public String displayUpdateUser(@RequestParam(name = "id") Long id, Model model){

        UserDto userDto = userService.findById(id);

        model.addAttribute("user", userDto);

        return "views/userupdate";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam(name = "id") Long id,  @ModelAttribute("user") UserDto userModel, Model model ) {
        userService.update(userModel);

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id){
        userService.remove(id);
        
        return "redirect:/users";

    }
    
}
