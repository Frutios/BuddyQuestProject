package com.quest.buddy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.quest.buddy.services.ImportServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseSetupController {

    @Autowired
    ImportServiceImp importService;

    @GetMapping(value = "/api/database/seed")
    public ResponseEntity<Void> generateSports(){
        importService.seedDatabase();
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
