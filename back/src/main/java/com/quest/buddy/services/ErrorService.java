package com.quest.buddy.services;

import java.util.HashMap;



public interface ErrorService {
    void AddError(String title,String message);
    HashMap<String,String> getErrors();
}
