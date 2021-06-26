package com.quest.buddy.dtos;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.annotations.JMap;
import com.quest.buddy.models.Event;

public class EventDto implements BaseDto<Event> {
    
    @JMap
    private String title;

    @JMap
    private String description;

    public EventDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Event toSource(){
        JMapper<Event, EventDto> eventMapper = new JMapper<>(Event.class, EventDto.class);

        Event sport = eventMapper.getDestination(this); 
        return sport; 
    }

}
