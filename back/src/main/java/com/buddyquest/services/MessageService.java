package com.buddyquest.services;

import com.buddyquest.models.Message;

import java.util.List;

public interface MessageService {
    void createMessage(Message message);
    void removeMessage(Long id);
    void updateMessage(Message message);
    List<Message> getAll();
    Message findMessage(Long id);
}
