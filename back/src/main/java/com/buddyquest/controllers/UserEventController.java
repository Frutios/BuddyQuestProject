package com.buddyquest.controllers;

import com.buddyquest.services.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserEventController {

    @Autowired
    private UserEventService userEventService;
}
