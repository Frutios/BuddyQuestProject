package com.quest.buddy.services;

import com.quest.buddy.models.MySport;
import com.quest.buddy.repository.MySportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MySportService")
public class MySportServiceImpl implements MySportService {

    @Autowired
    private MySportRepository mySportRepository;

    @Override
    public void create(MySport mySport) {
        mySportRepository.save(mySport);
    }

    @Override
    public void remove(Long id) {
         mySportRepository.deleteById(id);
    }

    @Override
    public void update(MySport mySport) {
        mySportRepository.save(mySport);
    }

    @Override
    public Iterable<MySport> getAll() {
       return mySportRepository.findAll();
    }

    @Override
    public MySport findById(Long id) {
        return mySportRepository.findById(id).orElse(null);
    }
}
