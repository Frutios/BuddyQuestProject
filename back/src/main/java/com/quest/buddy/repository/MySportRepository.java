package com.quest.buddy.repository;


import com.quest.buddy.models.MySport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySportRepository extends CrudRepository<MySport, Long> {
}