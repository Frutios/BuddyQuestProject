package com.buddyquest.controllers;

import com.buddyquest.models.Sport;
import com.buddyquest.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SportController {

    @Autowired
    private BaseService<Sport,Long> sportService;
}
