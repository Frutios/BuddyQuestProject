package com.buddyquest.services;

import com.buddyquest.models.Localisation;
import com.buddyquest.repositories.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalisationServiceImpl implements BaseService<Localisation, Long> {
    private LocalisationRepository localisationRepository;

    @Autowired
    public LocalisationServiceImpl(LocalisationRepository localisationRepository) {
        this.localisationRepository = localisationRepository;
    }

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
    public List<Localisation> getAll() {
        return localisationRepository.findAll();
    }

    @Override
    public Localisation findById(Long id) {
        return localisationRepository.findById(id).orElse(null);
    }
}
