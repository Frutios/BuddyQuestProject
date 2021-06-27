package com.quest.buddy.services;

import java.util.List;

import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.MySport;
import com.quest.buddy.models.Sport;

public interface MySportService extends BaseService<MySport,Long> {
    public List<UserDto> findUserBySport(Sport sport);
}


