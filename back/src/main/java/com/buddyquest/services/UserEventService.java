package com.buddyquest.services;

import com.buddyquest.models.UserEvent;

import java.util.List;

public interface UserEventService {
    void createUserEvent(UserEvent userEvent);
    void removeUserEvent(Long id);
    void updateUserEvent(UserEvent userEvent);
    List<UserEvent> getAll();
    UserEvent findUserEvent(Long id);
}
