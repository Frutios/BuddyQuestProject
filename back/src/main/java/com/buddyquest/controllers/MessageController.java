package com.buddyquest.controllers;

import com.buddyquest.models.Message;
import com.buddyquest.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private BaseService<Message, Long> messageService;
}
