package com.quest.buddy.services;

import com.quest.buddy.models.Localisation;
import com.quest.buddy.repository.LocalisationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LocalisationService")
public class LocalisationServiceImpl implements LocalisationService {

    @Autowired
    private LocalisationRepository localisationRepository;


    @Override
    public void create(Localisation localisation) {
        localisationRepository.save(localisation);
    }

    @Override
    public void remove(Long id) {
        localisationRepository.deleteById(id);
    }

    @Override
    public void update(Localisation localisation) {
        localisationRepository.save(localisation);
    }

    @Override
    public Iterable<Localisation> getAll() {
        return localisationRepository.findAll();
    }

    @Override
    public Localisation findById(Long id) {
        return localisationRepository.findById(id).orElse(null);
    }
}
