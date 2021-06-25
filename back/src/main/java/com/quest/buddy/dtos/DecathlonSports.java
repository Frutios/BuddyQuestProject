package com.quest.buddy.dtos;

import java.util.List;

public class DecathlonSports {
    private List<DecathlonSport> data;

    public DecathlonSports() {
    }

    public List<DecathlonSport> getData() {
        return data;
    }

    public void setData(List<DecathlonSport> data) {
        this.data = data;
    }
}
