package com.quest.buddy.repository;


import java.util.List;

import com.quest.buddy.models.Sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long> {
    
    @Autowired
    public List<Sport> findByName(String name);
}