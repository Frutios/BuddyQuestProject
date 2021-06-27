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
       Sport soccer = sportService.findById(1L);
       Sport basketBall = sportService.findById(2L);
       User romain = userService.findById(1L);

       LocalDate currentDate = LocalDate.now();
       LocalTime currentTime = LocalTime.now();
       LocalDateTime dateDebut = LocalDateTime.of(currentDate, currentTime);

       Event soccerBarman = new Event();
       soccerBarman.setAgeMax((byte) 99);
       soccerBarman.setAgeMin((byte) 18);
       soccerBarman.setDescription("Les barmans de la place plume sont invités à un soccer géant!");
       soccerBarman.setNbPartnerMax(10);
       soccerBarman.setSport(soccer);
       soccerBarman.setPlace("Place plume");
       soccerBarman.setTitle("Match de foot des barmans");
       soccerBarman.setStartTime(dateDebut);
       soccerBarman.setUser(romain);   
       eventService.create(soccerBarman);

       Event soccerBoss = new Event();
       soccerBoss.setAgeMax((byte) 99);
       soccerBoss.setAgeMin((byte) 18);
       soccerBoss.setDescription("Les patrons de bars se retrouvent place plume pour savoir qui a la plus grosse");
       soccerBoss.setNbPartnerMax(10);
       soccerBoss.setSport(soccer);
       soccerBoss.setPlace("Place plume");
       soccerBoss.setTitle("Match de foot des patrons");
       soccerBoss.setStartTime(dateDebut);
       soccerBoss.setUser(romain);   
       eventService.create(soccerBoss);

       Event nbaATours = new Event();
       nbaATours.setAgeMax((byte) 99);
       nbaATours.setAgeMin((byte) 18);
       nbaATours.setDescription("Les joueurs NBA débarquent à Tours, viens montrer ton skill");
       nbaATours.setNbPartnerMax(10);
       nbaATours.setSport(basketBall);
       nbaATours.setPlace("Tours Nord");
       nbaATours.setTitle("Viens jouer avec des joueurs de NBA");
       nbaATours.setStartTime(dateDebut);
       nbaATours.setUser(romain);   
       eventService.create(nbaATours);
    }

    @Override
    public void seedDatabase() {
        seedSports();
        seedUsers();
        seedEvents();  
    }
    
}
