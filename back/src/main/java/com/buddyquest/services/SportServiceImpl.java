package com.buddyquest.services;

import com.buddyquest.models.Sport;
import com.buddyquest.models.User;
import com.buddyquest.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SportServiceImpl implements BaseService<Sport, Long> {
    private SportRepository sportRepository;

    @Autowired
    public SportServiceImpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

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
    public List<Sport> getAll() {
       return sportRepository.findAll();
    }

    @Override
    public Sport findById(Long id) {
        return sportRepository.findById(id).orElse(null);
    }
}
