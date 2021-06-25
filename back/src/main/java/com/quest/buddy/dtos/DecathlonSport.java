package com.quest.buddy.dtos;


public class DecathlonSport {
    private String type;
    private Attribute attributes;
    
    public DecathlonSport() {
    }
    public String getType() {
        return type;
    }
    public Attribute getAttributes() {
        return attributes;
    }
    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    
}
