package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.EmailDto;
import com.animalCommunity.project.services.EmailService;
import com.animalCommunity.project.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    EmailService emailService;

    public EmailController(UserService userService, EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/sendmail")
    public boolean sendMail(@RequestBody EmailDto emailDto){
        System.out.println(emailDto.getEmail());
        System.out.println(emailDto.getUserId());
        return emailService.sendMail(emailDto);
    }
    @PostMapping("/rePassword")    // 이메일 재설정
    public boolean rePassword(@RequestBody EmailDto emailDto){
        return emailService.rePassword(emailDto);
    }
}
