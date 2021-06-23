package com.quest.buddy.services;

import com.quest.buddy.models.UserEvent;
import com.quest.buddy.repository.UserEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserEventService")
public class UserEventServiceImpl implements UserEventService{
    @Autowired
    private UserEventRepository userEventRepository;

    @Override
    public void create(UserEvent userEvent) {
        userEventRepository.save(userEvent);
    }

    @Override
    public void remove(Long id) {
        userEventRepository.deleteById(id);
    }

    @Override
    public void update(UserEvent userEvent) {
        userEventRepository.save(userEvent);
    }

    @Override
    public Iterable<UserEvent> getAll() {
        return userEventRepository.findAll();
    }

    @Override
    public UserEvent findById(Long id) {
        return userEventRepository.findById(id).orElse(null);
    }
}
