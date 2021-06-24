package com.quest.buddy.rest;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import com.quest.buddy.models.Sport;
import com.quest.buddy.services.SportServiceImpl;

@RestController
public class SportRestController {

    @Autowired
    SportServiceImpl sportService;

    @Autowired
    

    @GetMapping(value = "/api/sports", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Sport>> getAll() {

        Iterable<Sport> sports = sportService.getAll();
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Iterable<Sport>>(sports,HttpStatus.OK);
        
    }

    @GetMapping(value = "/api/sports/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sport> getById(@PathVariable("id") long id) {
        Sport sportFound = sportService.findById(id);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sportFound,HttpStatus.OK);
    }

    @PostMapping(value = "/api/sports", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sport> create(@RequestBody Sport sportToCreate) {
        sportService.create(sportToCreate);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(sportToCreate,HttpStatus.OK);
    }

    @PutMapping(value = "/api/sports", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Sport sportToUpdate) {
        sportService.update(sportToUpdate);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/api/sports/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> remove(@PathVariable("id") long id) {
        sportService.remove(id);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean hasErrors(){
        HashMap<String,String> errors = sportService.getErrors();

        boolean errorsFound = false;
        if(!errors.isEmpty())
        {
            errors.clear();
            errorsFound = true;
        }
        return errorsFound;
    }

}
