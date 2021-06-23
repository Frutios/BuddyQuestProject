package com.buddyquest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SportController {

    @Autowired
    private SportService sportService;
}
