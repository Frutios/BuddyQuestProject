package com.quest.buddy.repository;


import java.util.List;

import com.quest.buddy.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUserName(String userName);
}