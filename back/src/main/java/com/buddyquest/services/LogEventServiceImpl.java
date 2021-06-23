package com.buddyquest.services;

import com.buddyquest.models.LogEvent;
import com.buddyquest.repositories.LogEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogEventServiceImpl implements BaseService<LogEvent, Long>{
    private LogEventRepository logEventRepository;

    @Autowired
    public LogEventServiceImpl(LogEventRepository logEventRepository) {
        this.logEventRepository = logEventRepository;
    }

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
    public List<LogEvent> getAll() {
        return logEventRepository.findAll();
    }

    @Override
    public LogEvent findById(Long id) {
        return logEventRepository.findById(id).orElse(null);
    }
}
