package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.TestDto;
import com.animalCommunity.project.mappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public void TestService (TestDto testDto){
        testMapper.TestMapper(testDto);
    }
}
