package com.buddyquest.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "sport")
    private List<Event> events;

    @OneToMany(mappedBy = "sport")
    private List<MySport> mySports;


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

    public List<MySport> getMySports() {
        return mySports;
    }

    public void setMySports(List<MySport> mySports) {
        this.mySports = mySports;
    }
}
