package com.quest.buddy.repository;


import com.quest.buddy.models.UserEvent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long> {
}