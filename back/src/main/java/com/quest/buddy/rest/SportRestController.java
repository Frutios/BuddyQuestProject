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
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.quest.buddy.dtos.DecathlonSport;
import com.quest.buddy.dtos.DecathlonSports;
import com.quest.buddy.dtos.SportDto;
import com.quest.buddy.models.MySport;
import com.quest.buddy.models.Sport;
import com.quest.buddy.services.ImportServiceImp;
import com.quest.buddy.services.SportServiceImpl;

@RestController
public class SportRestController {

    @Autowired
    SportServiceImpl sportService;

    @Autowired
    ImportServiceImp importService;

    @GetMapping(value = "/api/sports", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SportDto>> getAll() {

        Iterable<SportDto> sports = sportService.getAllDto();
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Iterable<SportDto>>(sports,HttpStatus.OK);
        
    }

    @GetMapping(value = "/api/sports/generate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> generateSports(){
        final String uri = "https://sports.api.decathlon.com/sports";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(uri, String.class);

        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        DecathlonSports decathlonSport = gson.fromJson(jsonData, new TypeToken<DecathlonSports>(){}.getType());
        
        importService.importDecathlon(decathlonSport);
        return new ResponseEntity<>(null,HttpStatus.OK);
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
    public ResponseEntity<SportDto> create(@RequestBody SportDto sportToCreate) {
        SportDto createdSport = sportService.create(sportToCreate);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(createdSport,HttpStatus.OK);
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

    @GetMapping(value = "/api/sports/{id}/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<MySport>> getUsersFromSport(@PathVariable("id") long id) {
        Sport sport = sportService.findById(id);
        if(hasErrors()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Iterable<MySport>>(sport.getMyUsers(),HttpStatus.OK);
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
