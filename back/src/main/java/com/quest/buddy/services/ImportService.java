package com.quest.buddy.services;

import com.quest.buddy.dtos.DecathlonSports;

public interface ImportService {
    public void importDecathlon(DecathlonSports sports);
    public void seedDatabase();
}
