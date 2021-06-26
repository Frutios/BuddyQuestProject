package com.quest.buddy.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.quest.buddy.dtos.DecathlonSports;
import com.quest.buddy.models.Event;
import com.quest.buddy.models.Sport;
import com.quest.buddy.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ImportService")
public class ImportServiceImp implements ImportService {

    @Autowired
    SportServiceImpl sportService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    EventServiceImpl eventService;


    @Override
    public void importDecathlon(DecathlonSports sports) {
        
        sports.getData().forEach(decathlonSport -> {
            Sport newSport = new Sport();

            newSport.setName(decathlonSport.getAttributes().getName());
            newSport.setDescription(decathlonSport.getAttributes().getDescription());
            newSport.setIcon(decathlonSport.getAttributes().getIcon());

            sportService.create(newSport);
            
        });

    }

    public void seedSports() {
        final String uri = "https://sports.api.decathlon.com/sports";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(uri, String.class);

        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        DecathlonSports decathlonSport = gson.fromJson(jsonData, new TypeToken<DecathlonSports>(){}.getType());
        
        importDecathlon(decathlonSport);
        
    }

    public void seedUsers() {
       User romain = new User();

       romain.setFirstName("Romain");
       romain.setLastName("Tortevois");
       romain.setEmail("tortevois.romain@gmail.com");
       romain.setPassword("root");
       romain.setPseudonym("rotor");
       romain.setPhone("09080909");

       userService.create(romain);
    }

    public void seedEvents() {
       Event firstEvent = new Event();
       Sport soccer = sportService.findByName("Soccer");
       User romain = userService.findById(1L);

       LocalDate currentDate = LocalDate.now();
       LocalTime currentTime = LocalTime.now();
       LocalDateTime dateDebut = LocalDateTime.of(currentDate, currentTime);


       firstEvent.setAgeMax((byte) 99);
       firstEvent.setAgeMin((byte) 18);
       firstEvent.setDescription("Description first event");
       firstEvent.setNbPartnerMax(10);
       firstEvent.setSport(soccer);
       firstEvent.setPlace("Place plume");
       firstEvent.setTitle("Du sport entouré de bars");
       firstEvent.setStartTime(dateDebut);
       firstEvent.setUser(romain);
        
       eventService.create(firstEvent);
    }

    @Override
    public void seedDatabase() {
        seedSports();
        seedUsers();
        seedEvents();  
    }
    
}
