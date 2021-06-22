package com.buddyquest.services;

import com.buddyquest.models.MySport;

import java.util.List;

public interface MySportService {
    void createMySport(MySport mySport);
    void removeMySport(Long id);
    void updateMySport(MySport mySport);
    List<MySport> getAll();
    MySport findMySport(Long id);
}
