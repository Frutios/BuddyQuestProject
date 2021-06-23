package com.quest.buddy.services;

import com.quest.buddy.models.Sport;
import com.quest.buddy.models.User;
import com.quest.buddy.repository.SportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SportService")
public class SportServiceImpl implements SportService {
    
    @Autowired
    private SportRepository sportRepository;


    @Override
    public void create(Sport sport) {
        sportRepository.save(sport);
    }

    @Override
    public void remove(Long id) {
        sportRepository.deleteById(id);
    }

    @Override
    public void update(Sport sport) {
        sportRepository.save(sport);
    }

    @Override
    public Iterable<Sport> getAll() {
       return sportRepository.findAll();
    }

    @Override
    public Sport findById(Long id) {
        return sportRepository.findById(id).orElse(null);
    }
}
