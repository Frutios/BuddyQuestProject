package com.quest.buddy.models;

import javax.persistence.*;

import com.googlecode.jmapper.JMapper;
import com.quest.buddy.dtos.SportDto;

import java.util.List;

@Entity
@Table(name = "sport")
public class Sport implements BaseModel<SportDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;


    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "icon", length = 500)
    private String icon;

    @OneToMany(mappedBy = "sport")
    private List<Event> events;

    @OneToMany(mappedBy = "sport")
    private List<MySport> myUsers;

    public Sport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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


    @Override
    public SportDto toDto(){
        JMapper<SportDto, Sport> sportMapper = new JMapper<>(SportDto.class, Sport.class);
        
        SportDto sportDto = sportMapper.getDestination(this);
        return sportDto;
    }

}
