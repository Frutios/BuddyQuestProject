package com.quest.buddy.repository;


import com.quest.buddy.models.LogEvent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEventRepository extends CrudRepository<LogEvent, Long> {
}