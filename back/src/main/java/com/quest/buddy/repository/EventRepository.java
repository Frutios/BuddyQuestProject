package com.quest.buddy.repository;

import com.quest.buddy.models.Event;

import com.quest.buddy.models.User;
import com.quest.buddy.models.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Autowired
    public List<Event> findEventByTitle(String title);

    @Autowired
    public Iterable<Event> findEventByUser(User user);


    public Iterable<Event>findByTitleContaining(String title);

}