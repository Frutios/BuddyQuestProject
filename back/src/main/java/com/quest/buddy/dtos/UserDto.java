package com.quest.buddy.dtos;

import com.quest.buddy.models.User;

import org.modelmapper.ModelMapper;

public class UserDto implements BaseDto<User> {
    private String firstName;
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
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(this, User.class);
        return user;
    }

    
}
