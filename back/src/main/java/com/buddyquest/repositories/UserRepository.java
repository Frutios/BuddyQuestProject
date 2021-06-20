package com.buddyquest.repositories;

import com.buddyquest.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}