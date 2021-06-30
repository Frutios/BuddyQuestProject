package com.quest.buddy.dtos;

import java.time.LocalDateTime;

import com.quest.buddy.models.User;

import org.modelmapper.ModelMapper;

public class UserDto implements BaseDto<User> {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String pseudonym;
    private String password;
    private String email;
    private LocalDateTime inscriptionDate;

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
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public LocalDateTime getInscriptionDate(){
        return inscriptionDate;
    }

    public void setInscriptionDate(LocalDateTime inscriptionDate){
        this.inscriptionDate = inscriptionDate;
    }

    @Override
    public User toSource(){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(this, User.class);
        return user;
    }

    
}
