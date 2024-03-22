package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.EmailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {
    void rePassword(EmailDto emailDto);
}
