package com.buddyquest.services;

import com.buddyquest.models.MySport;
import com.buddyquest.repositories.MySportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MySportServiceImpl implements MySportService {
    private MySportRepository mySportRepository;

    @Autowired
    public MySportServiceImpl(MySportRepository mySportRepository) {
        this.mySportRepository = mySportRepository;
    }

    @Override
    public void createMySport(MySport mySport) {
        mySportRepository.save(mySport);
    }

    @Override
    public void removeMySport(Long id) {
         mySportRepository.deleteById(id);
    }

    @Override
    public void updateMySport(MySport mySport) {
        mySportRepository.save(mySport);
    }

    @Override
    public List<MySport> getAll() {
       return mySportRepository.findAll();
    }

    @Override
    public MySport findMySport(Long id) {
        return mySportRepository.findById(id).orElse(null);
    }
}
