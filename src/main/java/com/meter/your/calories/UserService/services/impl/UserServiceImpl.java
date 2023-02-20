package com.meter.your.calories.UserService.services.impl;

import com.meter.your.calories.UserService.mappers.UserMapper;
import com.meter.your.calories.UserService.models.dto.UserDto;
import com.meter.your.calories.UserService.models.entities.UserEntity;
import com.meter.your.calories.UserService.repositories.UserRepository;
import com.meter.your.calories.UserService.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserDto userDto) throws Exception {
        if(userDto.getName() == null ){
            throw new Exception("The user name can not be null!");
        }
        Optional<UserEntity> userOpt = userRepository.findUserEntitiesByName(userDto.getName());
        if(userOpt.isPresent()){
            throw new Exception("User with name "+userDto.getName()+" already exists.");
        }
        UserEntity user = UserMapper.mapUserDtoToUserEntity(userDto);
        return userRepository.save(user);
    }
}
