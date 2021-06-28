package com.quest.buddy.dtos;

import com.quest.buddy.models.Event;

import org.modelmapper.ModelMapper;

public class EventDto implements BaseDto<Event> {

    private String title;

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
    public Event toSource() {
        ModelMapper modelMapper = new ModelMapper();
        Event event = modelMapper.map(this, Event.class);
        return event;
    }

}
