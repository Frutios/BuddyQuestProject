package com.buddyquest.services;

import java.util.List;

import com.buddyquest.models.User;
import com.buddyquest.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        
        return userRepository.findAll();
    }

}