package com.buddyquest.controllers;

import com.buddyquest.models.Localisation;
import com.buddyquest.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalisationController {
    @Autowired
    BaseService<Localisation, Long> locatisationService;


}
