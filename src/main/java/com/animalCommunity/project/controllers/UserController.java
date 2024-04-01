package com.animalCommunity.project.controllers;


import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.models.User;
import com.animalCommunity.project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")  // 회원가입
    public List<String> signup(@Valid @RequestBody UserDto userDto, Errors errors) {
        System.out.println(userDto);
        List<ObjectError> errorList = errors.getAllErrors();
        List<String> errStr = new ArrayList<String>();
        if(errors.hasErrors()){
            for (ObjectError list : errorList) {
                errStr.add(list.getDefaultMessage());
            }
            return errStr;
        }else{
            userService.signup(userDto);
            return errStr;
        }
    }

    @PostMapping("/idCheck")  // 회원가입시 id 중복체크
    public String idCheck(@RequestBody UserDto userDto){
        return userService.idCheck(userDto);
    }
    @PostMapping("/nicknameCheck") // 회원가입시 닉네임 중복체크
    public String nicknameCheck(@RequestBody UserDto userDto){
        System.out.println(userDto.getNickname());
        String test  = userService.nicknameCheck(userDto);
        System.out.println(test);
        return test;
    }
    @PostMapping("/exitMember")  // 회원탈퇴
    public String exitMember(@RequestBody UserDto userDto){
        String retrunValue = userService.exitMember(userDto);
        System.out.println(retrunValue + " : 컨트롤러");
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
    @PostMapping("/findId")
    public String findID(@RequestBody UserDto userDto){
        return userService.findId(userDto);
    }
}
