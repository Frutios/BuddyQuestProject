package com.buddyquest.services;

import com.buddyquest.models.Localisation;

import java.util.List;

public interface LocalisationService {
    void createLocalisation(Localisation localisation);
    void removeLocalisation(Long id);
    void updateLocalisation(Localisation localisation);
    List<Localisation> getAll();
    Localisation findLocalisation(Long id);
}
