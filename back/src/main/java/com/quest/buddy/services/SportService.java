package com.quest.buddy.services;


import com.quest.buddy.dtos.EventDto;
import com.quest.buddy.dtos.SportDto;
import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.Sport;


public interface SportService extends BaseService<Sport,Long> {
    
    public SportDto create(SportDto sportDto);
    public Iterable<SportDto> findByName(String name);
    public Iterable<EventDto> getEventsForSport(Long sportId);
    public Iterable<UserDto> getUsersForSport(Long sportId);

}


