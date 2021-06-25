package com.quest.buddy.services;

import com.quest.buddy.dtos.DecathlonSports;
import com.quest.buddy.models.Sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ImportService")
public class ImportServiceImp implements ImportService {

    @Autowired
    SportServiceImpl sportService;

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
    
}
