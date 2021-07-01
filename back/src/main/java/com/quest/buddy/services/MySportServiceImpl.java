package com.quest.buddy.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.MySport;
import com.quest.buddy.models.Sport;
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

    @Override
    public List<UserDto> findUserBySport(Sport sport) {
        Iterable<MySport> sports = mySportRepository.findBySport(sport);

        List<UserDto> usersDto = StreamSupport.stream(sports.spliterator(), false)
        .map(userDto->userDto.getUser().toDto())
        .collect(Collectors.toList());

        return usersDto;
    }

    public Iterable<MySport> findMySportByUserId(Long userId){
        Iterable<MySport> mySports = null;
        try {
             mySports = mySportRepository.findMySportsByUserId(userId);
        } catch (Exception e) {

        }
        return mySports;
    }
}
