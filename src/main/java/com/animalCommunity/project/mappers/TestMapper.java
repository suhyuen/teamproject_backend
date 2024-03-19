package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.TestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    void TestMapper(TestDto testDto);
}
