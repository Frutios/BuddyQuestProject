package com.quest.buddy.services;

import com.quest.buddy.models.Message;
import com.quest.buddy.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MessageService")
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;
    
    @Override
    public void create(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void remove(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void update(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Iterable<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }
}
