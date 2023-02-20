package com.meter.your.calories.UserService.web;

import com.meter.your.calories.UserService.models.dto.UserDto;
import com.meter.your.calories.UserService.models.entities.UserEntity;
import com.meter.your.calories.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    ResponseEntity createUserUSingPost(@RequestBody UserDto userDto){
        try {
            UserEntity user = userService.createUser(userDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<Void>( HttpStatus.OK );
    }

}
