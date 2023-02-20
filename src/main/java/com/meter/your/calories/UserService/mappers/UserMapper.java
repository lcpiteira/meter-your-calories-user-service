package com.meter.your.calories.UserService.mappers;

import com.meter.your.calories.UserService.models.dto.UserDto;
import com.meter.your.calories.UserService.models.entities.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserEntity mapUserDtoToUserEntity(UserDto userDto){

        UserEntity user = new UserEntity();
        user.setName(user.getName());
        user.setEmail(user.getEmail() != null ? user.getEmail() : null);
        return user;

    }
}
