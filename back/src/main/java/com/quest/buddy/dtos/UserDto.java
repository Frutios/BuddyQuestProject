package com.quest.buddy.dtos;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.annotations.JMap;
import com.quest.buddy.models.User;

public class UserDto implements BaseDto<User> {
    @JMap
    private String firstName;
    @JMap
    private String lastName;


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public User toSource(){
        JMapper<User, UserDto> eventMapper = new JMapper<>(User.class, UserDto.class);

        User sport = eventMapper.getDestination(this); 
        return sport; 
    }

    
}
