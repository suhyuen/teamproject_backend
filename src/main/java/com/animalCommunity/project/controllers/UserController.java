package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.SignupDto;
import com.animalCommunity.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto signupDto){
        System.out.println("1");
        userService.signup(signupDto);
    }
}
