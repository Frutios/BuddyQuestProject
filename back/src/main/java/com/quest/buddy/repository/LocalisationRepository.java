package com.quest.buddy.repository;


import com.quest.buddy.models.Localisation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationRepository extends CrudRepository<Localisation, Long> {
}