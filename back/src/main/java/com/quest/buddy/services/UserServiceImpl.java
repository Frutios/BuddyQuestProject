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
    public void create(UserDto userDto) {
        userRepository.save(userDto.toSource());
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserDto userDto) {
        User user = findById(userDto.getId()).toSource();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setPseudonym(userDto.getPseudonym());
      
        userRepository.save(user);
    }

    @Override
    public Iterable<UserDto> getAll() {
        Iterable<User> users = null;
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("User", "Error getting users");
        }
        return toListDto(users);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).get();

        return user.toDto();
    }

    public HashMap<String,String> getErrors(){
        return errorService.getErrors();
    }

    public static Iterable<UserDto> toListDto(Iterable<User> users ){
        List<UserDto> usersDto=StreamSupport.stream(users.spliterator(), false)
        .map(user ->user.toDto())
        .collect(Collectors.toList());

        return usersDto;
    }

}