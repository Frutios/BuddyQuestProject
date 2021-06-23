package com.buddyquest.services;

import com.buddyquest.models.UserEvent;
import com.buddyquest.repositories.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserEventServiceImpl implements BaseService<UserEvent, Long>{
    private UserEventRepository userEventRepository;

    @Autowired
    public UserEventServiceImpl(UserEventRepository userEventRepository) {
        this.userEventRepository = userEventRepository;
    }

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
    public List<UserEvent> getAll() {
        return userEventRepository.findAll();
    }

    @Override
    public UserEvent findById(Long id) {
        return userEventRepository.findById(id).orElse(null);
    }
}
