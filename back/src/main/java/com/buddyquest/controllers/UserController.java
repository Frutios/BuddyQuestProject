package com.buddyquest.controllers;

import java.util.List;

import com.buddyquest.models.User;
import com.buddyquest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
    private UserService userService;

	@GetMapping("/users")
	public List<User> user() {
		return userService.getAll();
	}
}