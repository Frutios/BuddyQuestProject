package com.buddyquest.repositories;

import com.buddyquest.models.MySport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySportRepository extends JpaRepository<MySport,Long> {
}
