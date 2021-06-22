package com.buddyquest.services;

import com.buddyquest.models.Localisation;
import com.buddyquest.repositories.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalisationServiceImpl implements LocalisationService {
    private LocalisationRepository localisationRepository;

    @Autowired
    public LocalisationServiceImpl(LocalisationRepository localisationRepository) {
        this.localisationRepository = localisationRepository;
    }

    @Override
    public void createLocalisation(Localisation localisation) {
        localisationRepository.save(localisation);
    }

    @Override
    public void removeLocalisation(Long id) {
        localisationRepository.deleteById(id);
    }

    @Override
    public void updateLocalisation(Localisation localisation) {
        localisationRepository.save(localisation);
    }

    @Override
    public List<Localisation> getAll() {
        return localisationRepository.findAll();
    }

    @Override
    public Localisation findLocalisation(Long id) {
        return localisationRepository.findById(id).orElse(null);
    }
}
