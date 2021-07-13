package com.quest.buddy.services;


import java.io.InputStreamReader;
import java.io.Reader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quest.buddy.dtos.City;
import com.quest.buddy.dtos.DecathlonSports;
import com.quest.buddy.dtos.FakeUsers;
import com.quest.buddy.models.Event;
import com.quest.buddy.models.Localisation;
import com.quest.buddy.models.MySport;
import com.quest.buddy.models.Sport;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import com.quest.buddy.dtos.UserDto;

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

    @Autowired 
    MySportServiceImpl mySportService;

    @Autowired
    LocalisationServiceImpl localisationService;



    public void importDecathlon(DecathlonSports sports) {
        
        sports.getData().forEach(decathlonSport -> {
            Sport newSport = new Sport();

            newSport.setName(decathlonSport.getAttributes().getName());
            newSport.setDescription(decathlonSport.getAttributes().getDescription());
            newSport.setIcon(decathlonSport.getAttributes().getIcon());

            sportService.create(newSport);
            
        });

    }

    public void importFakeUsers(FakeUsers fakeUsers) {
        Lorem lorem = LoremIpsum.getInstance();
        fakeUsers.getResults().forEach(fakeUser -> {
            UserDto userDto = new UserDto();

            userDto.setDescription(lorem.getWords(5, 10));
            userDto.setEmail(fakeUser.getEmail());
            userDto.setPassword(fakeUser.getEmail());
            userDto.setFirstName(fakeUser.getName().getFirst());
            userDto.setLastName(fakeUser.getName().getLast());
            userDto.setPhone(fakeUser.getPhone().replace("-", "").replace(" ", ""));
            userDto.setUserName(fakeUser.getName().getFirst() + fakeUser.getName().getLast());
            userDto.setPseudonym(fakeUser.getName().getFirst());
            
            userService.create(userDto);
            
        });

    }

    public void seedSportUsers(){
        Sport soccer = sportService.findById(1L);
        Sport basketBall = sportService.findById(2L);
        UserDto romain = userService.findById(1L);

        MySport romainsoccer = new MySport();
        romainsoccer.setSport(soccer);
        romainsoccer.setUser(romain.toSource());
        romainsoccer.setLevel(30L);
        mySportService.create(romainsoccer);

        MySport romainBasketBall = new MySport();
        romainsoccer.setSport(basketBall);
        romainsoccer.setUser(romain.toSource());
        romainsoccer.setLevel(30L);
        mySportService.create(romainBasketBall);

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
       
        final String uri = "https://randomuser.me/api/?results=1000";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(uri, String.class);

        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        FakeUsers fakeUsers = gson.fromJson(jsonData, new TypeToken<FakeUsers>(){}.getType());
        
        importFakeUsers(fakeUsers);
        
    }
    
    public void seedLocalisations(){
        try {
            Reader reader =  new InputStreamReader(this.getClass()
            .getResourceAsStream("/cities.json"));
        
            // convert JSON file to map
            List<City> citys = new Gson().fromJson(reader, new TypeToken<List<City>>() {}.getType());

            citys.forEach(city->{
                Localisation localisation = new Localisation();
                localisation.setCity(city.name);
                localisation.setCountry("France");
                localisation.setLatitude(city.gps_lat);
                localisation.setLongitude(city.gps_lng);

                localisationService.create(localisation);
            });
        
            // close reader
            reader.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }

    private int getRandomForEntity(int low, int high){
        Random entityRandom = new Random();
        int result = entityRandom.nextInt(high-low) + low;
        return result;
    }

    private void generateFakeEvent(){
        Lorem lorem = LoremIpsum.getInstance();

        var sportId = getRandomForEntity(1,693);
        Sport sport = sportService.findById((long) sportId);
        var userId = getRandomForEntity(1,945);
        UserDto user = userService.findById((long)userId);

        var localisationId = getRandomForEntity(1,34000);
        Localisation localisation = localisationService.findById((long)localisationId);

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime dateDebut = LocalDateTime.of(currentDate, currentTime);
        LocalDateTime endDate = LocalDateTime.of(currentDate, currentTime).plusHours(5);

        Event event = new Event();
        event.setAgeMax((byte) 99);
        event.setAgeMin((byte) 18);
        event.setDescription(lorem.getWords(5,10));
        event.setNbPartnerMax(10);
        event.setSport(sport);
        event.setDateEventCreate(dateDebut);
        event.setEndTime(endDate);
        event.setLocalisation(localisation);
        event.setPlace(lorem.getWords(4));
        event.setTitle(lorem.getWords(4));
        event.setStartTime(dateDebut);
        event.setUser(user.toSource());   
        eventService.create(event);
    }

    public void seedEvents() {
        for(int i = 0; i <1000; i++){
            generateFakeEvent();
        }
    }

    @Override
    public void seedDatabase() {
        seedLocalisations();
        seedSports();
        seedUsers();
        seedEvents();  
        seedSportUsers();
    }
    
}
