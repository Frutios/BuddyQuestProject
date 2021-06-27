package com.quest.buddy.services;

import com.quest.buddy.models.LogEvent;
import com.quest.buddy.repository.LogEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LogEventService")
public class LogEventServiceImpl implements LogEventService{

    @Autowired
    private LogEventRepository logEventRepository;

    @Override
    public void create(LogEvent logEvent) {
        logEventRepository.save(logEvent);
    }

    @Override
    public void remove(Long id) {
        logEventRepository.deleteById(id);
    }

    @Override
    public void update(LogEvent logEvent) {
        logEventRepository.save(logEvent);
    }

    @Override
    public Iterable<LogEvent> getAll() {
        return logEventRepository.findAll();
    }

    @Override
    public LogEvent findById(Long id) {
        return logEventRepository.findById(id).orElse(null);
    }
}
