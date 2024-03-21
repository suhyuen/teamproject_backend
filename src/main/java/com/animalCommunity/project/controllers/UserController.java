package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.models.User;
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
    public int signup(@RequestBody UserDto userDto){
        int a = userService.signup(userDto);
        return a;
    }
    @PostMapping("/idCheck")  // 회원가입시 id 중복체크
    public int idCheck(@RequestBody UserDto userDto){
        return userService.idCheck(userDto);
    }
    @PostMapping("/nicknameCheck") // 회원가입시 닉네임 중복체크
    public int nicknameCheck(@RequestBody UserDto userDto){
        return userService.nicknameCheck(userDto);
    }
    @PostMapping("/exitMember")  // 회원탈퇴
    public int exitMember(@RequestBody UserDto userDto){
        int retrunValue = userService.exitMember(userDto);
        return retrunValue;
    }
    @PostMapping("/userInfo")  // 회원정보조회
    public User userInfo(@RequestBody UserDto userDto){
        return userService.userInfo(userDto);
    }
    @PostMapping("/userInfoUpdate") // 회원정보수정
    public int userInfoUpdate (@RequestBody UserDto userDto){
        return userService.userInfoUpdate(userDto);
    }
}
