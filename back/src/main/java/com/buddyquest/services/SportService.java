package com.buddyquest.services;

import com.buddyquest.models.Sport;
import com.buddyquest.models.User;

import java.util.List;

public interface SportService {
    void createSport(Sport sport);
    void removeSport(Long id);
    void updateSport(Sport sport);
    List<Sport> getAll();
    Sport findSport(Long id);
}
