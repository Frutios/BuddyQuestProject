package com.quest.buddy.services;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("ErrorService")
public class ErrorServiceImp implements ErrorService{

    private HashMap<String,String> errors = new HashMap<>();


    @Override
    public void AddError(String title, String message) {
        errors.put(title, message);
    }
    
    @Override
    public HashMap<String,String> getErrors(){
        return errors;
    }
    
}
