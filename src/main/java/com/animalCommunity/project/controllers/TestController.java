package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.TestDto;
import com.animalCommunity.project.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/test")
    public void testController(@RequestBody TestDto testDto){
        testService.TestService(testDto);
    }
}
