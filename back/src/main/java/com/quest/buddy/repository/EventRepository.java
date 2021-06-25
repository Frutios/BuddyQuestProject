package com.quest.buddy.repository;

import com.quest.buddy.models.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Autowired
    public List<Event> findEventByTitle(String title);
    //@Autowired
    //public List<Event> findByName(String name);
}