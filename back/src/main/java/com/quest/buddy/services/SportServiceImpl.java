package com.quest.buddy.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.quest.buddy.dtos.EventDto;
import com.quest.buddy.dtos.SportDto;
import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.Sport;
import com.quest.buddy.repository.SportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SportService")
public class SportServiceImpl implements SportService {
    
    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private ErrorServiceImp errorService;


    @Override
    public void remove(Long id) {

        if(exist(id)){
            try {
                sportRepository.deleteById(id);
            } catch (Exception e) {
                errorService.AddError("Sport", "Error deleting sport with id " + id );
            }
        }
        else
        {
            errorService.AddError("Sport", "No sport with id " + id + " to remove" );
        }

    }

    @Override
    public void update(Sport sport) {

        try {
            sportRepository.save(sport);
        } catch (Exception e) {
            errorService.AddError("Sport", "Error updating " + sport.getName() );
        }
        
    }

    @Override
    public Iterable<Sport> getAll() {

        Iterable<Sport> sports = null;
        try {
            sports = sportRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("Sport", "Error getting sports" );
        }
       return sports;
    }

    public Iterable<SportDto> getAllDto() {

        Iterable<Sport> sports = null;
        try {
            sports = sportRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("Sport", "Error getting sports" );
        }
        
       return toListDto(sports);
    }

    public static Iterable<SportDto> toListDto(Iterable<Sport> sports ){
        List<SportDto> sportDtos=StreamSupport.stream(sports.spliterator(), false)
        .map(sport ->sport.toDto())
        .collect(Collectors.toList());

        return sportDtos;
    }

    @Override
    public Sport findById(Long id) {

       Sport sport = null;
        try {
            sport = sportRepository.findById(id).orElse(null);
        } catch (Exception e) {
            errorService.AddError("Sport", "Error getting sport with id " + id );
        }
       return sport;

    }

    public Sport findByName(String name){
        
        Sport sport = null;

        try {
            sport = sportRepository.findByName(name);
        } catch (Exception e) {
            errorService.AddError("Sport", "Error getting sport with name " + name );
        }
        
        return sport;
    }

    public boolean exist(String name){

        boolean sportExist = false;
        try {
            sportExist = sportRepository.findByName(name) != null;
        } catch (Exception e) {
            errorService.AddError("Sport", "Error while finding sport with name " + name );
        }
       return sportExist;

    }

    public boolean exist(Long id){

        Optional<Sport> sportExist = null;
        try {
            sportExist = sportRepository.findById(id);
        } catch (Exception e) {
            errorService.AddError("Sport", "Error while finding sport with id " + id );
        }
       return sportExist.isPresent();

    }

    public HashMap<String,String> getErrors(){
        return errorService.getErrors();
    }

    @Override
    public void create(Sport sport) {

        if(exist(sport.getName())){
            errorService.AddError("Sport", "Sport already" + sport.getName() + " exist");
        }
        else
        {
            try {
                sportRepository.save(sport);
            } catch (Exception e) {
                errorService.AddError("Sport", e.toString());
            }
           
        }
        
    }

    public SportDto create(SportDto sportDto) {
        Sport sport = sportDto.toSource();
        if(exist(sport.getName())){
            errorService.AddError("Sport", "Sport already" + sport.getName() + " exist");
        }
        else
        {
            sportRepository.save(sport);
        }
        return sport.toDto();
    }

    @Override
    public Iterable<SportDto> getSportsByKeyWord(String filter) {
       
        Iterable<Sport> sports;

        sports = sportRepository.findSportsByKeyword(filter);

        return toListDto(sports);
    }

    @Override
    public Iterable<EventDto> getEventsForSport(Long sportId) {
        
        Iterable<EventDto> events = null;

        try {
            events = sportRepository.findEvents(sportId);
        } catch (Exception e) {
           errorService.AddError("Sports", e.toString());
        }

        return events;
    }

    @Override
    public Iterable<UserDto> getUsersForSport(Long sportId) {
        Iterable<UserDto> users = null;

        try {
            users = sportRepository.findUsers(sportId);
        } catch (Exception e) {
            errorService.AddError("Sports", e.toString());
        }
        
        
        return users;
    }



}
