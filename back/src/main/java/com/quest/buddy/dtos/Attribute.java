package com.quest.buddy.dtos;

public class Attribute {
    private String name;
    private String description;
    private String icon;

    public Attribute() {
    }
    
    public String getName() {
        return name;
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
    public void setName(String name) {
        this.name = name;
    }
}
