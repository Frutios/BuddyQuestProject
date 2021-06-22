package com.buddyquest.controllers;

import com.buddyquest.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SportController {

    @Autowired
    private SportService sportService;
}
