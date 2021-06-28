package com.quest.buddy.models;

import javax.persistence.*;

import com.quest.buddy.dtos.SportDto;

import org.hibernate.annotations.Formula;
import org.modelmapper.ModelMapper;

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

    @Column(name ="active", nullable = false)
    private Boolean active = true;

    @Formula("(select count(e.id) from Event e where e.sport_id = id)")
    private Long nbEvents;

    @Formula("(select count(s.id) from my_sport s where s.sport_id = id)")
    private Long nbUsers;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getNbEvents() {
        return nbEvents;
    }

    public void setNbEvents(Long nbEvents) {
        this.nbEvents = nbEvents;
    }
    public Long getNbUsers() {
        return nbUsers;
    }
    public void setNbUsers(Long nbUsers) {
        this.nbUsers = nbUsers;
    }
    @Override
    public SportDto toDto(){
        ModelMapper modelMapper = new ModelMapper();
        SportDto sportDto = modelMapper.map(this, SportDto.class);
        return sportDto;
    }

}
