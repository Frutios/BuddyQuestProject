package com.quest.buddy.services;

import com.quest.buddy.models.EventState;

import java.util.ArrayList;
import java.util.List;

public class EventStateServiceImpl {
    public List<EventState> getAll(){
        List<EventState> liststate = new ArrayList<>();
        liststate.add(new EventState((byte)1,"Active"));
        liststate.add(new EventState((byte)2,"Finalize"));

        return liststate;
    }
}
