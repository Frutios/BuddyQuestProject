package com.quest.buddy.repository;


import com.quest.buddy.models.Sport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long> {
}