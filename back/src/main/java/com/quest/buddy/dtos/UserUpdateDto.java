package com.quest.buddy.dtos;

import com.quest.buddy.models.User;

import org.modelmapper.ModelMapper;

public class UserUpdateDto implements BaseDto<User>{

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String pseudonym;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPseudonym(){
        return pseudonym;
    }

    public void setPseudonym(String pseudonym){
        this.pseudonym = pseudonym;
    }

    @Override
    public User toSource(){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(this, User.class);
        return user;
    }
    
}
