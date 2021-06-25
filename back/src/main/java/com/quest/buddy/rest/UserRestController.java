package com.quest.buddy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.buddy.models.User;
import com.quest.buddy.services.UserServiceImpl;

@RestController
public class UserRestController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAll() {
        return userService.getAll();
    }

}
