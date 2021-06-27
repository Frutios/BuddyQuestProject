package com.quest.buddy.repository;


import java.util.List;

import com.quest.buddy.models.MySport;
import com.quest.buddy.models.Sport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySportRepository extends CrudRepository<MySport, Long> {
    public List<MySport> findBySport(Sport sport);
}