package com.quest.buddy.models;

public class EventState {
    private byte Id;
    private String name;

    public EventState(byte id, String name) {
        Id = id;
        this.name = name;
    }

    public byte getId() {
        return Id;
    }

    public void setId(byte id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
