package com.buddyquest.services;

import com.buddyquest.models.MySport;
import com.buddyquest.repositories.MySportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MySportServiceImpl implements BaseService<MySport, Long> {
    private MySportRepository mySportRepository;

    @Autowired
    public MySportServiceImpl(MySportRepository mySportRepository) {
        this.mySportRepository = mySportRepository;
    }

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
    public List<MySport> getAll() {
       return mySportRepository.findAll();
    }

    @Override
    public MySport findById(Long id) {
        return mySportRepository.findById(id).orElse(null);
    }
}
