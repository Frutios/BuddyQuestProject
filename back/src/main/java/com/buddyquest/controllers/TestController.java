package com.buddyquest.controllers;

import com.buddyquest.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public User user() {
		return new User();
	}
}