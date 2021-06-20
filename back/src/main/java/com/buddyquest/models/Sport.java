package com.buddyquest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "sport")
public class Sport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "sport")
    private Collection<Event> events;

    @OneToMany(mappedBy = "sport")
    private Collection<MySport> mySports;


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

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }

    public Collection<MySport> getMySports() {
        return mySports;
    }

    public void setMySports(Collection<MySport> mySports) {
        this.mySports = mySports;
    }
}
