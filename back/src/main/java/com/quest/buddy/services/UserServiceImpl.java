package com.quest.buddy.services;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.User;
import com.quest.buddy.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ErrorServiceImp errorService;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public HashMap<String,String> getErrors(){
        return errorService.getErrors();
    }

    public static Iterable<UserDto> toListDto(Iterable<User> users ){
        List<UserDto> usersDto=StreamSupport.stream(users.spliterator(), false)
        .map(event ->event.toDto())
        .collect(Collectors.toList());

        return usersDto;
    }

}