package com.buddyquest.services;

import com.buddyquest.models.Message;
import com.buddyquest.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements BaseService<Message, Long>{
    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

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
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }
}
