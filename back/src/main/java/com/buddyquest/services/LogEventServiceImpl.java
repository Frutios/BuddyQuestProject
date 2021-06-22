package com.buddyquest.services;

import com.buddyquest.models.LogEvent;
import com.buddyquest.repositories.LogEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogEventServiceImpl implements LogEventService{
    private LogEventRepository logEventRepository;

    @Autowired
    public LogEventServiceImpl(LogEventRepository logEventRepository) {
        this.logEventRepository = logEventRepository;
    }

    @Override
    public void createLogEvent(LogEvent logEvent) {
        logEventRepository.save(logEvent);
    }

    @Override
    public void removeLogEvent(Long id) {
        logEventRepository.deleteById(id);
    }

    @Override
    public void updateLogEvent(LogEvent logEvent) {
        logEventRepository.save(logEvent);
    }

    @Override
    public List<LogEvent> getAll() {
        return logEventRepository.findAll();
    }

    @Override
    public LogEvent findLogEvent(Long id) {
        return logEventRepository.findById(id).orElse(null);
    }
}
