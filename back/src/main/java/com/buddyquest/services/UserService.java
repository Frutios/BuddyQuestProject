package com.buddyquest.services;

import java.util.List;

import com.buddyquest.models.User;

public interface UserService {
    void createUser(User user);
    void removeUser(Long id);
    void updateUser(User user);
    List<User> getAll();
    User findUser(Long id);
}
