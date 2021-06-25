package com.quest.buddy.services;

import com.quest.buddy.models.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderServiceImpl {
    public List<Gender> getAll(){
        List<Gender> listGender = new ArrayList<>();
        listGender.add(new Gender(1l,"Male"));
        listGender.add(new Gender(2l,"Women"));
        listGender.add(new Gender(3l,"Mixte"));
        return listGender;
    }
}
