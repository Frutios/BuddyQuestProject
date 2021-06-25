package com.quest.buddy.services;


import com.quest.buddy.dtos.SportDto;
import com.quest.buddy.models.Sport;


public interface SportService extends BaseService<Sport,Long> {
    
    public SportDto create(SportDto sportDto);
    public Iterable<SportDto> getAllDto();
    public Iterable<SportDto> findSportsByKeyword(String filter);

}


