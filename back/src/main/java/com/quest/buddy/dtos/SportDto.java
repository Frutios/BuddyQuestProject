package com.quest.buddy.dtos;


import com.quest.buddy.models.Sport;

import org.modelmapper.ModelMapper;


public class SportDto implements BaseDto<Sport> {

    private Long id;

    private String name;

    private String description;

    private String icon;

    private Boolean active;

    private Long nbEvents ;

    private Long nbUsers ;

    
    public SportDto() {
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
    public Sport toSource(){
        ModelMapper modelMapper = new ModelMapper();
        Sport sport = modelMapper.map(this, Sport.class);
        return sport;
    }
    
}
