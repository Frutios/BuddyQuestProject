package com.quest.buddy.services;

import java.util.List;

import com.quest.buddy.dtos.UserDto;

public interface UserService extends BaseService<UserDto,Long> {

    List<UserDto> findByUserName(String userName);
}


