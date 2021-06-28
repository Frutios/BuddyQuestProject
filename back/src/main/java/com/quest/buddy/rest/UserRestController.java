package com.quest.buddy.rest;

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

import com.quest.buddy.models.User;
import com.quest.buddy.services.UserServiceImpl;

@RestController
public class UserRestController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<User>> getAll() {

        Iterable<User> users = userService.getAll();
        if (hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@PathVariable("id") long id) {
        User userFound = userService.findById(id);
        if(hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }

    @PostMapping(value = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        userService.create(userToCreate);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(userToCreate,HttpStatus.OK);
    }

    @PutMapping(value = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody User userToUpdate) {
        userService.update(userToUpdate);
        
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/api/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> remove(@PathVariable("id") long id) {
        userService.remove(id);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean hasErrors(){
        HashMap<String,String> errors = userService.getErrors();

        boolean errorsFound = false;
        if(!errors.isEmpty())
        {
            errors.clear();
            errorsFound = true;
        }
        return errorsFound;
    }
}
