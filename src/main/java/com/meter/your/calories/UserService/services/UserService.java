package com.meter.your.calories.UserService.services;


import com.meter.your.calories.UserService.models.dto.UserDto;
import com.meter.your.calories.UserService.models.entities.UserEntity;

public interface UserService {

    UserEntity createUser(UserDto userDto) throws Exception;

}
