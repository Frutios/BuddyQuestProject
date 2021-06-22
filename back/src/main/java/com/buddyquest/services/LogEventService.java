package com.buddyquest.services;

import com.buddyquest.models.LogEvent;

import java.util.List;

public interface LogEventService {
    void createLogEvent(LogEvent logEvent);
    void removeLogEvent(Long id);
    void updateLogEvent(LogEvent logEvent);
    List<LogEvent> getAll();
    LogEvent findLogEvent(Long id);
}
