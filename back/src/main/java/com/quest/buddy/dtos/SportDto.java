package com.quest.buddy.dtos;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.annotations.JMap;
import com.quest.buddy.models.Sport;

public class SportDto implements BaseDto<Sport> {

    @JMap
    private Long id;

    @JMap
    private String name;

    @JMap
    private String description;

    @JMap
    private String icon;
    
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
    
    @Override
    public Sport toSource(){
        JMapper<Sport, SportDto> sportMapper = new JMapper<>(Sport.class, SportDto.class);

        Sport sport = sportMapper.getDestination(this); 
        return sport; 
    }
    
}
