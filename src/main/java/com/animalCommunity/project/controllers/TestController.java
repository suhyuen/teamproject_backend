package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.TestDto;
import com.animalCommunity.project.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/postTest")
    public void testController(@RequestBody TestDto testDto){
        testService.TestService(testDto);
    }
    @GetMapping("/getTest")
    public String getTest(){
        return "Hello Get";
    }
    @PostMapping("/postTest2")
    public String postTest(){
        // Authentication안에 있는 userUid 가지고 오기 SecurityContextHolder를 까서 내용 가지고 오기
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "Hello Post";
    }
}