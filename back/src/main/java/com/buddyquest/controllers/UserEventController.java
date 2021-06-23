package com.buddyquest.controllers;

import com.buddyquest.models.UserEvent;
import com.buddyquest.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserEventController {

    @Autowired
    private BaseService<UserEvent, Long> userEventService;
}
