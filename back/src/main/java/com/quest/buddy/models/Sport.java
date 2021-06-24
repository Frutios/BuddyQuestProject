package com.quest.buddy.models;

import javax.persistence.*;

import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Table(name = "sport")
@Lazy
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "sport")
    private List<Event> events;

    @OneToMany(mappedBy = "sport")
    @Lazy
    private List<MySport> myUsers;


    public Sport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<MySport> getMyUsers() {
        return myUsers;
    }

    public void setMyUsers(List<MySport> myUsers) {
        this.myUsers = myUsers;
    }
}
