package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.SignupDto;
import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")  // 회원가입
    public void signup(@RequestBody UserDto userDto){
        userService.signup(userDto);
    }

    @PostMapping("/exitMember")
    public int exitMember(@RequestBody UserDto userDto){
        int retrunValue = userService.exitMember(userDto);
        System.out.println(retrunValue);  // 1이 출력되면 정상 0이 출력되면 오류
        return retrunValue;
    }
}
